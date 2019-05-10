package com.lucq.entity;

import java.util.Date;
import javax.persistence.*;

public class Account {
    /**
     * 自增主键
     */
    @Id
    private Integer id;

    /**
     * 用户手机号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 用户名称
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 实名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * hex(sha1(password+createtime))
     */
    private String password;

    /**
     * 第一次错误时间
     */
    @Column(name = "bad_password_time")
    private Date badPasswordTime;

    /**
     * 从第一次错误时间开始的累计错误次数
     */
    @Column(name = "bad_password_count")
    private Integer badPasswordCount;

    /**
     * 1 小时内密码允许错5 次，超出锁定
     */
    @Column(name = "lockout_time")
    private Date lockoutTime;

    /**
     * 上次登入时间
     */
    @Column(name = "last_logon")
    private Date lastLogon;

    /**
     * 上次登出时间
     */
    @Column(name = "last_log_off")
    private Date lastLogOff;

    /**
     * 用户邮件地址
     */
    private String mail;

    /**
     * 重设密码的时间
     */
    @Column(name = "password_last_set")
    private Date passwordLastSet;

    /**
     * organization 表主键，0 表示系统账户
     */
    @Column(name = "organization_id")
    private Integer organizationId;

    /**
     * 账号类型 0系统 1机构
     */
    private Byte type;

    /**
     * 数据状态0 无效；1 有效；-1 删除
     */
    private Byte state;

    /**
     * 数据创建用户id
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 数据创建时间，创建后不允许更新
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 数据更新用户id
     */
    @Column(name = "modify_by")
    private String modifyBy;

    /**
     * 数据更新时间，每次更新字段重写
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 是否是第一次登录 0否 1是
     */
    @Column(name = "first_login_flag")
    private Integer firstLoginFlag;

    /**
     * 个人信息图片
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 昵称
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户手机号码
     *
     * @return phone_number - 用户手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置用户手机号码
     *
     * @param phoneNumber 用户手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取用户名称
     *
     * @return account_name - 用户名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置用户名称
     *
     * @param accountName 用户名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取实名
     *
     * @return real_name - 实名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置实名
     *
     * @param realName 实名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取hex(sha1(password+createtime))
     *
     * @return password - hex(sha1(password+createtime))
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置hex(sha1(password+createtime))
     *
     * @param password hex(sha1(password+createtime))
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取第一次错误时间
     *
     * @return bad_password_time - 第一次错误时间
     */
    public Date getBadPasswordTime() {
        return badPasswordTime;
    }

    /**
     * 设置第一次错误时间
     *
     * @param badPasswordTime 第一次错误时间
     */
    public void setBadPasswordTime(Date badPasswordTime) {
        this.badPasswordTime = badPasswordTime;
    }

    /**
     * 获取从第一次错误时间开始的累计错误次数
     *
     * @return bad_password_count - 从第一次错误时间开始的累计错误次数
     */
    public Integer getBadPasswordCount() {
        return badPasswordCount;
    }

    /**
     * 设置从第一次错误时间开始的累计错误次数
     *
     * @param badPasswordCount 从第一次错误时间开始的累计错误次数
     */
    public void setBadPasswordCount(Integer badPasswordCount) {
        this.badPasswordCount = badPasswordCount;
    }

    /**
     * 获取1 小时内密码允许错5 次，超出锁定
     *
     * @return lockout_time - 1 小时内密码允许错5 次，超出锁定
     */
    public Date getLockoutTime() {
        return lockoutTime;
    }

    /**
     * 设置1 小时内密码允许错5 次，超出锁定
     *
     * @param lockoutTime 1 小时内密码允许错5 次，超出锁定
     */
    public void setLockoutTime(Date lockoutTime) {
        this.lockoutTime = lockoutTime;
    }

    /**
     * 获取上次登入时间
     *
     * @return last_logon - 上次登入时间
     */
    public Date getLastLogon() {
        return lastLogon;
    }

    /**
     * 设置上次登入时间
     *
     * @param lastLogon 上次登入时间
     */
    public void setLastLogon(Date lastLogon) {
        this.lastLogon = lastLogon;
    }

    /**
     * 获取上次登出时间
     *
     * @return last_log_off - 上次登出时间
     */
    public Date getLastLogOff() {
        return lastLogOff;
    }

    /**
     * 设置上次登出时间
     *
     * @param lastLogOff 上次登出时间
     */
    public void setLastLogOff(Date lastLogOff) {
        this.lastLogOff = lastLogOff;
    }

    /**
     * 获取用户邮件地址
     *
     * @return mail - 用户邮件地址
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置用户邮件地址
     *
     * @param mail 用户邮件地址
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 获取重设密码的时间
     *
     * @return password_last_set - 重设密码的时间
     */
    public Date getPasswordLastSet() {
        return passwordLastSet;
    }

    /**
     * 设置重设密码的时间
     *
     * @param passwordLastSet 重设密码的时间
     */
    public void setPasswordLastSet(Date passwordLastSet) {
        this.passwordLastSet = passwordLastSet;
    }

    /**
     * 获取organization 表主键，0 表示系统账户
     *
     * @return organization_id - organization 表主键，0 表示系统账户
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置organization 表主键，0 表示系统账户
     *
     * @param organizationId organization 表主键，0 表示系统账户
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取账号类型 0系统 1机构
     *
     * @return type - 账号类型 0系统 1机构
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置账号类型 0系统 1机构
     *
     * @param type 账号类型 0系统 1机构
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取数据状态0 无效；1 有效；-1 删除
     *
     * @return state - 数据状态0 无效；1 有效；-1 删除
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置数据状态0 无效；1 有效；-1 删除
     *
     * @param state 数据状态0 无效；1 有效；-1 删除
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取数据创建用户id
     *
     * @return create_by - 数据创建用户id
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置数据创建用户id
     *
     * @param createBy 数据创建用户id
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取数据创建时间，创建后不允许更新
     *
     * @return create_time - 数据创建时间，创建后不允许更新
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置数据创建时间，创建后不允许更新
     *
     * @param createTime 数据创建时间，创建后不允许更新
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取数据更新用户id
     *
     * @return modify_by - 数据更新用户id
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置数据更新用户id
     *
     * @param modifyBy 数据更新用户id
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 获取数据更新时间，每次更新字段重写
     *
     * @return modify_time - 数据更新时间，每次更新字段重写
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置数据更新时间，每次更新字段重写
     *
     * @param modifyTime 数据更新时间，每次更新字段重写
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取是否是第一次登录 0否 1是
     *
     * @return first_login_flag - 是否是第一次登录 0否 1是
     */
    public Integer getFirstLoginFlag() {
        return firstLoginFlag;
    }

    /**
     * 设置是否是第一次登录 0否 1是
     *
     * @param firstLoginFlag 是否是第一次登录 0否 1是
     */
    public void setFirstLoginFlag(Integer firstLoginFlag) {
        this.firstLoginFlag = firstLoginFlag;
    }

    /**
     * 获取个人信息图片
     *
     * @return image_url - 个人信息图片
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置个人信息图片
     *
     * @param imageUrl 个人信息图片
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * 获取昵称
     *
     * @return display_name - 昵称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置昵称
     *
     * @param displayName 昵称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }
}