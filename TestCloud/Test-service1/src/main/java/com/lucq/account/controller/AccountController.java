package com.lucq.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucq.account.bo.CreateAccountBo;
import com.lucq.account.bo.QueryAccountBo;
import com.lucq.account.service.AccountService;
import com.lucq.common.response.ResultResponse;

@RestController("accountController")
@RequestMapping("account/")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    /**
     * 创建用户信息
     * @param createAccountBo
     * @return
     */
    @PostMapping("/createAccount")
    public ResultResponse<String> createAccount(CreateAccountBo createAccountBo) {
        
        return accountService.createAccount(createAccountBo);
    }
    
    /**
     * 查询用户列表信息
     * @param queryAccountBo
     * @return
     */
    @PostMapping("/queryAccountInfo")
    public ResultResponse<ModelMap> queryAccountInfo(QueryAccountBo queryAccountBo) {
        
        return accountService.queryAccountInfo(queryAccountBo);
    }
	
}
