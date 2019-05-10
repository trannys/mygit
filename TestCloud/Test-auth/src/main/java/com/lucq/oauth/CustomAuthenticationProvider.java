package com.lucq.oauth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lucq.model.AuthorizeClientBase;
import com.lucq.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

@Named
@Component
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    // 构造函数中注入
    @Inject
    public CustomAuthenticationProvider(AccountService accountService) {
        this.setUserDetailsService(accountService);
    }

    /**
     * 自定义验证方式: 通常请求使用参数 client_id, client_secret, grant_type
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        CustomUserDetails userDetails = (CustomUserDetails)
                this.getUserDetailsService().loadUserByUsername(username);
        if (userDetails == null) {
            Map<String, Object> map = (Map<String, Object>) authentication.getDetails();
            AuthorizeClientBase base = (AuthorizeClientBase) JSON.parseObject(JSON.toJSONString(map),
                    AuthorizeClientBase.class);
            if (base != null) {
                userDetails = (CustomUserDetails) this.getUserDetailsService().loadUserByUsername(
                        base.getClient_id());
            }
        }
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        Authentication token = new UsernamePasswordAuthenticationToken(
                JSON.toJSONString(userDetails, SerializerFeature.WriteMapNullValue), password, authorities);
        logger.info(token.toString());
        return token;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}