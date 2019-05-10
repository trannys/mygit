package com.lucq.oauth;

import com.lucq.entity.Account;
import com.lucq.utils.StringFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Slf4j
public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = -7221852740983991218L;

    private String username;

    private String password;

    private Account account;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * 重写getAuthorities方法，将用户的角色作为权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.account != null) {
            log.info(this.account.toString());
            String authorityRoles = this.account.getAccountName();
//            if(StringUtils.isEmpty(authorityRoles)) {
//                authorityRoles = StringFormat.format("{0}{1}",
//                        GrantConstants.AUTHENTICATED_DICT_ROLE_PREFIX, GrantConstants.AUTHENTICATED_DEFAULT_ROLE);
//                if (GrantConstants.AUTHENTICATED_ROOT_ACCOUNT.equals(this.account.getAccountName())) {
//                    authorityRoles = StringFormat.format("{0}{1}",
//                            GrantConstants.AUTHENTICATED_DICT_ROLE_PREFIX, GrantConstants.AUTHENTICATED_ROOT);
//                }
//            }
            log.info(authorityRoles);
            return AuthorityUtils.commaSeparatedStringToAuthorityList(authorityRoles);
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(StringFormat.format("{0}{1}",
                GrantConstants.AUTHENTICATED_DICT_ROLE_PREFIX,
                GrantConstants.AUTHENTICATED_DEFAULT_ROLE));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}