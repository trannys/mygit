package com.lucq.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucq.account.bo.CreateAccountBo;
import com.lucq.account.bo.QueryAccountBo;
import com.lucq.account.service.AccountService;
import com.lucq.account.vo.QueryAccountVo;
import com.lucq.common.BusinessException;
import com.lucq.common.CommonConstants;
import com.lucq.common.State;
import com.lucq.common.errorcode.ErrorCodeEnum;
import com.lucq.common.response.ResultResponse;
import com.lucq.common.util.ResultUtil;
import com.lucq.entity.Account;
import com.lucq.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;



@Service("accountService")
@Slf4j
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public ResultResponse<String> createAccount(CreateAccountBo createAccountBo) {
		
	    log.info("The input params of  createAccount  is   {}", createAccountBo);
	    
	    ResultResponse<String> result = ResultUtil.getSuccessResult(String.class);
	    
	    if (null == createAccountBo) {
	        result.setStatus(ErrorCodeEnum.PARAMS_NULL.getStatus());
	        result.setMsg(ErrorCodeEnum.PARAMS_NULL.getMsg());
	        return result;
	    }
	    
	    try {
            createAccountBo.checkParams();
            
            checkExistsByPhone(createAccountBo.getPhoneNumber(), null);
            
            int dataResult = addAccount(createAccountBo);
            
            if (!CommonConstants.DB_SUCCESS.equals(dataResult)) {
                log.info("The data insert DB fail.");
                result.setError("The data insert DB fail.");
            } 
            
        } catch (BusinessException e) {
            log.error("The createAccount's running is error : {}", e);
            result.setError(e.getErrCode(), e.getErrMsg());
            return result;
    	} catch (Exception e) {
    	    log.error("The createAccount's running is error : {}", e);
    	    result.setError(ErrorCodeEnum.BUSINESS_ERROR);
    	    return result;
    	}
	    log.info("The createAccount success.");
		
		return result;
	}

	/**
	 *
	 * @param phoneNum
	 * @param exceptId 除了此id以外的数据，如果 不需要则传 null
	 * @throws BusinessException
	 */
	private void checkExistsByPhone(String phoneNum, Integer exceptId) throws BusinessException {
	    QueryAccountBo queryAccountBo = new QueryAccountBo();
	    queryAccountBo.setPhoneNumber(phoneNum);
		queryAccountBo.setExceptId(exceptId);
	    List<QueryAccountVo> dataList =  accountMapper.queryAccountInfo(queryAccountBo);
	    if (!CollectionUtils.isEmpty(dataList)) {
	        
	        log.error("手机号已注册！");
	        throw new BusinessException(ErrorCodeEnum.PHONE_NUMBER_EXISTS);
	    }
	}
	
	
	/**
	 *插入账户信息
	 * @param createAccountBo
	 * @return
	 */
	@Override
	public int addAccount(CreateAccountBo createAccountBo) {
	    Date date = new Date();
	    
	    Account account = new Account();
	    account.setCreateBy(CommonConstants.SYSTEM_ID);
	    account.setCreateTime(date);
	    account.setDisplayName(createAccountBo.getDisplayName());
	    account.setMail(createAccountBo.getMail());
	    account.setPassword(createAccountBo.getPassword());
	    account.setPhoneNumber(createAccountBo.getPhoneNumber());
	    account.setRealName(createAccountBo.getRealName());
	    account.setState(State.STATE_VALID);
	    account.setOrganizationId(createAccountBo.getOrganizationId());
	    account.setModifyBy(CommonConstants.SYSTEM_ID);
	    account.setModifyTime(date);
	    account.setPasswordLastSet(date);
	    
	    return accountMapper.insertSelective(account);
	}


    @Override
    public ResultResponse<ModelMap> queryAccountInfo(QueryAccountBo queryAccountBo) {
        
        log.info("The input params of  queryAccountInfo  is   {}", queryAccountBo);
        
        ResultResponse<ModelMap> result = ResultUtil.getSuccessResult(ModelMap.class);
        if (null == queryAccountBo) {
           queryAccountBo = new QueryAccountBo();
        }
        
        queryAccountBo.setState(State.STATE_VALID);//查询有效数据
        
        PageHelper.startPage(queryAccountBo.getPageNum(), queryAccountBo.getPageSize());
        
        List<QueryAccountVo> dataList =  accountMapper.queryAccountInfo(queryAccountBo);
        
        PageInfo<QueryAccountVo> pageList = new PageInfo<>(dataList);
        
        log.info("The dataList of queryAccountInfo is {}", pageList);
        
        result.setData(ResultUtil.getResultMap(pageList));
        
        return result;
    }

	@Override
	public ResultResponse<String> delAccountInfo(Integer id) {
		log.info("The input params of  delAccountInfo  is {}", id);

		ResultResponse<String> result = ResultUtil.getSuccessResult(String.class);

		if (null == id) {
			result.setStatus(ErrorCodeEnum.ACCOUNT_ID_NULL.getStatus());
			result.setMsg(ErrorCodeEnum.ACCOUNT_ID_NULL.getMsg());
			return result;
		}

		try {

			Account account = accountMapper.selectByPrimaryKey(id);
			if (null == account) {
				log.error("账号不存在");
				result.setStatus(ErrorCodeEnum.ACCOUNT_NOT_EXISTS.getStatus());
				result.setMsg(ErrorCodeEnum.ACCOUNT_NOT_EXISTS.getMsg());
				return result;
			}

			//逻辑删除机构信息
			account = new Account();
			account.setId(id);
			account.setState(State.STATE_NO_VALID);
			accountMapper.updateByPrimaryKeySelective(account);

		} catch (Exception e) {
			log.error("The delAccountInfo's running is error : {}", e);
			result.setError(ErrorCodeEnum.BUSINESS_ERROR);
			return result;
		}
		return result;
	}

	@Override
	public ResultResponse<String> updateAccountInfo(CreateAccountBo createAccountBo) {

		log.info("The input params of  updateAccountInfo  is   {}", createAccountBo);

		ResultResponse<String> result = ResultUtil.getSuccessResult(String.class);

		if (null == createAccountBo || null == createAccountBo.getId()) {
			result.setStatus(ErrorCodeEnum.ACCOUNT_ID_NULL.getStatus());
			result.setMsg(ErrorCodeEnum.ACCOUNT_ID_NULL.getMsg());
			return result;
		}

		try {
			Account account = JSON.parseObject(JSON.toJSONString(createAccountBo), Account.class);
			account.setModifyTime(new Date());

			//修改账号信息
			accountMapper.updateByPrimaryKeySelective(account);

		} catch (Exception e) {
			log.error("The updateAccountInfo's running is error : {}", e);
			result.setError(ErrorCodeEnum.BUSINESS_ERROR);
			return result;
		}
		return result;
	}


}
