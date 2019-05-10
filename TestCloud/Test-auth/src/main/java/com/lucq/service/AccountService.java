package com.lucq.service;

import com.lucq.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by dell on 2019/1/24.
 */
public interface AccountService  extends UserDetailsService {

    Account findById(Integer accountid);

    Account findByName(String name);
}
