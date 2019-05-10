package com.lucq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lucq.entity.Account;
import com.lucq.model.AuthorizeClientBase;
import com.lucq.oauth.CustomUserDetails;
import com.lucq.oauth.GrantConstants;
import com.lucq.service.AccountService;
import com.lucq.util.EncryptUtils;
import com.lucq.utils.CommonMsgEnum;
import com.lucq.utils.CommonResponse;
import com.lucq.utils.CommonRlt;
import com.lucq.utils.StringFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.InvalidScopeException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestValidator;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2019/1/24.
 */
/**
 * 自定义表单登录授权: 通常请求使用参数 username, password
 */
@FrameworkEndpoint
@Slf4j
@ResponseBody
public class SecurityTokenEndpoint implements InitializingBean {

    private static final String SECRET_KEY = "CYGzmZRJivo8QtjgQNYK0om4tZ4T4FnN";

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    @Qualifier("defaultAuthorizationServerTokenServices")
    private AuthorizationServerTokenServices tokenServices;


    private OAuth2RequestFactory oauthRequestFactory;
    private OAuth2RequestFactory defaultOauthRequestFactory;
    private OAuth2RequestValidator oauthRequestValidator = new DefaultOAuth2RequestValidator();


    /**
     * 自定义表单登录授权: 通常请求使用参数 username, password
     * 授权类型 Grant_type (固定) "password"
     * 兼容账号与手机号同时登录  共用字段 username
     */
    @PostMapping("/security/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        CommonRlt commonRlt = new CommonRlt(CommonMsgEnum.SUCCESS);
        try {

            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                commonRlt.setError(CommonMsgEnum.PARAMETERS_MANDATORY);
                log.info(commonRlt.toString());
                return CommonResponse.response(commonRlt, HttpStatus.BAD_REQUEST);
            }
            CustomUserDetails userDetails = (CustomUserDetails) this.accountService.loadUserByUsername(username);
            if (userDetails == null) {
                commonRlt.setError(CommonMsgEnum.USERNAME_OR_PASSWORD_INVALID);
                log.info(StringFormat.format("{0}: username no exists.", commonRlt.toString()));
                return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
            }
            Account account = userDetails.getAccount();
            if (account == null) {
                commonRlt.setError(CommonMsgEnum.USERNAME_OR_PASSWORD_INVALID);
                log.info(StringFormat.format("{0}: account no exists.", commonRlt.toString()));
                return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
            }
            // 使用手机号登录后需要重新将变量username替换为账号名
            if (!EncryptUtils.encodeSHA1(password + SECRET_KEY).equals(account.getPassword())) {
                log.error("##############密码错误######################");
                commonRlt.setError(CommonMsgEnum.USERNAME_OR_PASSWORD_INVALID);
                return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
            }

            ClientDetails authenticatedClient = clientDetailsService.loadClientByClientId(username);
            if (authenticatedClient == null) {
                commonRlt.setError(CommonMsgEnum.ACCOUNT_INVALID);
                log.info(StringFormat.format("{0}: Given username does not match " +
                        "authenticated client.", commonRlt.toString()));
                return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
            }
            Map<String, String> grant_req_parameters = new HashMap<String, String>();
            grant_req_parameters.put("client_id", username);
            grant_req_parameters.put("grant_type", GrantConstants.AUTHORIZED_GRANT_TYPE_REFRESH_TOKEN);
            grant_req_parameters.put("scope", GrantConstants.AUTHORIZED_GRANT_SCOPE_WRITE);
            log.info(StringFormat.format("grant_req_parameters = {0}", grant_req_parameters.toString()));
            TokenRequest tokenRequest = this.oauthRequestFactory.createTokenRequest(grant_req_parameters,
                    authenticatedClient);
            log.info("The tokenRequest is {}", tokenRequest);

            // 校验请求Token范围
            this.oauthRequestValidator.validateScope(tokenRequest, authenticatedClient);

            this.validateGrantType(tokenRequest.getGrantType(), authenticatedClient);

            // 生成用户授权认证信息
            AuthorizeClientBase base = new AuthorizeClientBase(username, password,
                    GrantConstants.AUTHORIZED_GRANT_TYPE_REFRESH_TOKEN);
            log.info(base.toString());
            Map<String, Object> map = JSON.parseObject(JSON.toJSONString(base), Map.class);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            log.info(authorities.toString());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    JSON.toJSONString(userDetails, SerializerFeature.WriteMapNullValue), password, authorities);
            authentication.setDetails(map);
            log.info(authentication.toString());
            // 组装Token请求参数头
            OAuth2Request storedOAuth2Request = this.oauthRequestFactory.createOAuth2Request(authenticatedClient, tokenRequest);
            // 创建Access Token及授权用户信息
            OAuth2AccessToken token = this.tokenServices.createAccessToken(
                    new OAuth2Authentication(storedOAuth2Request, (Authentication) authentication));
            if (token == null) {
                commonRlt.setError(CommonMsgEnum.ACCOUNT_INVALID);
                log.info(StringFormat.format("{0}: unsupported grant type '{1}'.",
                        commonRlt.toString(), tokenRequest.getGrantType()));
                return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
            }
            log.info(token.toString());
            commonRlt.setData(token);
            return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
        } catch (InvalidScopeException e) {
            log.error("the InvalidScopeException is error: {}",e);

        } catch (Exception ex) {
           log.error("The Exception is {}", ex);
        }

        commonRlt.setError(CommonMsgEnum.ACCOUNT_INVALID);
        return CommonResponse.response(commonRlt, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/findByName")
    public Object findByName(@RequestParam String name) {

        return accountService.findByName(name);
    }

    protected void validateGrantType(String grantType, ClientDetails clientDetails) {
        Collection<String> authorizedGrantTypes = clientDetails.getAuthorizedGrantTypes();
        if (authorizedGrantTypes != null && !authorizedGrantTypes.isEmpty() && !authorizedGrantTypes.contains(grantType)) {
            throw new InvalidClientException("Unauthorized grant type: " + grantType);
        }
    }

    /*public ClientDetailsService getClientDetailsService() {
        return clientDetailsService;
    }

    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }*/


    @Override
    public void afterPropertiesSet() throws Exception {
        this.defaultOauthRequestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);
        if (this.oauthRequestFactory == null) {
            this.oauthRequestFactory = this.defaultOauthRequestFactory;
        }
    }

    public static void main(String[] args) {
        System.out.println(EncryptUtils.encodeSHA1("88888888" + SECRET_KEY));
    }
}
