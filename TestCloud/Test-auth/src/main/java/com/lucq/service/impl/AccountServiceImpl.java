package com.lucq.service.impl;

import com.lucq.entity.Account;
import com.lucq.mapper.AccountMapper;
import com.lucq.oauth.CustomUserDetails;
import com.lucq.service.AccountService;
import com.lucq.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by dell on 2019/1/24.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public Account findById(Integer accountid) {
        return accountMapper.selectByPrimaryKey(accountid);
    }

    @Override
    public Account findByName(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Account account = new Account();
        account.setAccountName(username);
        System.out.println(EncryptUtils.getRamdomStr(10));

        return accountMapper.selectOne(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = new Account();
        account.setAccountName(username);

        Account accountData = accountMapper.selectOne(account);

        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setUsername(accountData.getAccountName());
        userDetails.setPassword(accountData.getPassword());
        userDetails.setAccount(accountData);
        return userDetails;
    }
}
