package com.lucq.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class BaseEntity {
	
	/**
	 * 自增主键
	 */
	@Id
	@Column(name = "id")
	private Integer id;
	
	/**
	 * 数据状态0 无效；1 有效；-1 删除
	 */
	@Column(name = "state")
	private Integer state;

	/**
	 * 数据创建用户ID
	 */
	@Column(name = "create_by")
	private Integer createBy;

	/**
	 * 数据创建时间，创建后不允许更新
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 数据更新用户ID
	 */
	@Column(name = "modify_by")
	private Integer modifyBy;

	/**
	 * 数据更新时间，每次更新字段重写
	 */
	@Column(name = "modify_time")
	private Date modifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	


}
