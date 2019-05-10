package com.lucq.entity;

import java.util.Date;

public class Account {
    private Integer id;

    private String phoneNumber;

    private String accountName;

    private String realName;

    private String password;

    private Date badPasswordTime;

    private Integer badPasswordCount;

    private Date lockoutTime;

    private Date lastLogon;

    private Date lastLogOff;

    private String mail;

    private Date passwordLastSet;

    private Integer organizationId;

    private Integer type;

    private Integer state;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private Integer firstLoginFlag;

    private String imageUrl;

    private String displayName;

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
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBadPasswordTime() {
        return badPasswordTime;
    }

    public void setBadPasswordTime(Date badPasswordTime) {
        this.badPasswordTime = badPasswordTime;
    }

    public Integer getBadPasswordCount() {
        return badPasswordCount;
    }

    public void setBadPasswordCount(Integer badPasswordCount) {
        this.badPasswordCount = badPasswordCount;
    }

    public Date getLockoutTime() {
        return lockoutTime;
    }

    public void setLockoutTime(Date lockoutTime) {
        this.lockoutTime = lockoutTime;
    }

    public Date getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon(Date lastLogon) {
        this.lastLogon = lastLogon;
    }

    public Date getLastLogOff() {
        return lastLogOff;
    }

    public void setLastLogOff(Date lastLogOff) {
        this.lastLogOff = lastLogOff;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Date getPasswordLastSet() {
        return passwordLastSet;
    }

    public void setPasswordLastSet(Date passwordLastSet) {
        this.passwordLastSet = passwordLastSet;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getFirstLoginFlag() {
        return firstLoginFlag;
    }

    public void setFirstLoginFlag(Integer firstLoginFlag) {
        this.firstLoginFlag = firstLoginFlag;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }
}