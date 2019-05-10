package com.lucq.account.vo;

import java.io.Serializable;

public class QueryAccountVo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1216002263215796251L;

    /**
     * 账号id
     */
    private Integer id;
    
    /**
     * 用户手机号码
     */
    private String phoneNumber;
    
    /**
     * 用户显示名称，可以是英文名
     */
    private String displayName;
    
    /**
     * 机构名称
     */
    private String organizationName;
    
    /**
     * 账号类型 系统  机构
     */
    private String accountType;
    
    /**
     * 账号类型 系统  机构
     */
    private Integer organizationId;

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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
    
    
    
    
}
