package com.lucq.account.service;

import org.springframework.ui.ModelMap;

import com.lucq.account.bo.CreateAccountBo;
import com.lucq.account.bo.QueryAccountBo;
import com.lucq.common.response.ResultResponse;

/**
 * 用户账号相关服务
 * @author dell
 *
 */
public interface AccountService {

    /**
     * 创建账号服务
     * @param createAccountBo
     * @return
     */
	public ResultResponse<String> createAccount(CreateAccountBo createAccountBo);
	
	
	/**
	 * 账号入库操作
	 * @param createAccountBo
	 * @return
	 */
	public int addAccount(CreateAccountBo createAccountBo);
	
	
	/**
	 * 查询用户列表信息
	 * @param queryAccountBo
	 * @return
	 */
	public ResultResponse<ModelMap> queryAccountInfo(QueryAccountBo queryAccountBo);


	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public ResultResponse<String> delAccountInfo(Integer id);

	/**
	 * 更新用户信息
	 * @param createAccountBo
	 * @return
	 */
	public ResultResponse<String> updateAccountInfo(CreateAccountBo createAccountBo);
}
