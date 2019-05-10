package com.lucq.organization.bo;

import java.io.Serializable;

import com.lucq.common.bo.PageBo;

public class QueryOrganizationBo  extends PageBo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6465110111730923554L;


    /**
                 * 机构名称
     */
    private String displayName;
    
    
    /**
                 * 中心编码
     */
    private String code;
    
    
    /**
     * 数据状态0 无效；1 有效；-1 删除
     */
    private Integer state;
    
    /**
         * 用于查询除了此id以外的机构
    */
    private Integer exceptId;

    /**
     * 机构地址
     */
    private String address;


    public String getDisplayName() {
        return displayName;
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
