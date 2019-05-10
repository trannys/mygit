package com.lucq.account.bo;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import com.lucq.account.common.AccountConstants;
import com.lucq.common.BusinessException;
import com.lucq.common.errorcode.ErrorCodeEnum;
import com.lucq.util.StringUtils;

public class CreateAccountBo implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 3631089098213767157L;

	/**
	 * 自增主键
	 */
	private Integer id;

    /**
	 * 用户手机号码
	 */
	@NonNull
	private String phoneNumber;

	/**
	 * 用户显示名称，可以是英文名
	 */
	@NonNull
	private String displayName;

	/**
	 * 实名
	 */
	private String realName;

	/**
	 * hex(sha1(password+createtime))
	 */
	@NonNull
	private String password;


	/**
	 * 用户邮件地址
	 */
	@NonNull
	private String mail;


	/**
	 * organization 表主键，0 表示系统账户
	 */
	@NonNull
	private Integer organizationId;

	/**
	 * 数据状态0 无效；1 有效；-1 删除
	 */
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Integer getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 校验必需参数
	 * @throws BusinessException
	 */
	public void checkParams() throws BusinessException {
	    
	    if (StringUtils.isEmpty(this.phoneNumber)) {
	        throw new BusinessException(ErrorCodeEnum.PHONE_NUMBER_NULL);
	    }
	    if (StringUtils.isEmpty(this.displayName)) {
	        throw new BusinessException(ErrorCodeEnum.ACCOUNT_DISPLAY_NAME_NULL);
	    }
	    if (StringUtils.isEmpty(this.password)) {
	        throw new BusinessException(ErrorCodeEnum.ACCOUNT_PASSWORD_NULL);
	    }
	    if (StringUtils.isEmpty(this.mail)) {
	        throw new BusinessException(ErrorCodeEnum.MAIL_NULL);
	    }
	    if (null == this.organizationId) {
	        throw new BusinessException(ErrorCodeEnum.ORGANIZATION_NULL);
	    }
	    
		if (!this.phoneNumber.matches(AccountConstants.MOBILE_REGEX)) {
		    throw new BusinessException(ErrorCodeEnum.PHONE_NUMBER_FORMAT_ERROR);
		}
		
		if (!this.mail.matches(AccountConstants.EMIAL_REGEX)) {
		    throw new BusinessException(ErrorCodeEnum.MAIL_FORMAT_ERROR);
		}
		
		
	}
	
	
}
