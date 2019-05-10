package com.lucq.account.bo;

import java.io.Serializable;

import com.lucq.common.bo.PageBo;

public class QueryAccountBo extends PageBo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4660540007185040121L;

    /**
     * 用户手机号码
     */
    private String phoneNumber;
    
    /**
     * 用户显示名称，可以是英文名
     */
    private String displayName;
    
    /**
     * 数据状态0 无效；1 有效；-1 删除
     */
    private Integer state;

    /**
     * 查询除了当前id以外的账号
     */
    private Integer exceptId;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getExceptId() {
        return exceptId;
    }

    public void setExceptId(Integer exceptId) {
        this.exceptId = exceptId;
    }
}
