package com.lucq.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Organization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2522919624686552098L;

	/**
	 * 自增主键
	 */
	@Id
	private Integer id;

	/**
	 * 机构名称
	 */
	@Column(name = "display_name")
	private String displayName;

	/**
	 * 机构地址
	 */
	private String address;

	/**
	 * 纬度
	 */
	private BigDecimal latitude;

	/**
	 * 经度
	 */
	private BigDecimal longitude;

	/**
	 * 中心编码
	 */
	private String code;

	/**
	 * 城市id
	 */
	private Integer city;

	/**
	 * 数据状态0 无效；1 有效；-1 删除
	 */
	private Integer state;

	/**
	 * 数据创建用户id
	 */
	@Column(name = "create_by")
	private Integer createBy;

	/**
	 * 数据创建时间，创建后不允许更新
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 数据更新用户id
	 */
	@Column(name = "modify_by")
	private Integer modifyBy;

	/**
	 * 数据更新时间，每次更新字段重写
	 */
	@Column(name = "modify_time")
	private Date modifyTime;

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
	 * 获取机构名称
	 *
	 * @return display_name - 机构名称
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 设置机构名称
	 *
	 * @param displayName 机构名称
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName == null ? null : displayName.trim();
	}

	/**
	 * 获取机构地址
	 *
	 * @return address - 机构地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置机构地址
	 *
	 * @param address 机构地址
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * 获取纬度
	 *
	 * @return latitude - 纬度
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * 设置纬度
	 *
	 * @param latitude 纬度
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获取经度
	 *
	 * @return longitude - 经度
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度
	 *
	 * @param longitude 经度
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获取中心编码
	 *
	 * @return code - 中心编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置中心编码
	 *
	 * @param code 中心编码
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * 获取城市id
	 *
	 * @return city - 城市id
	 */
	public Integer getCity() {
		return city;
	}

	/**
	 * 设置城市id
	 *
	 * @param city 城市id
	 */
	public void setCity(Integer city) {
		this.city = city;
	}

	/**
	 * 获取数据状态0 无效；1 有效；-1 删除
	 *
	 * @return state - 数据状态0 无效；1 有效；-1 删除
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 设置数据状态0 无效；1 有效；-1 删除
	 *
	 * @param state 数据状态0 无效；1 有效；-1 删除
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 获取数据创建用户id
	 *
	 * @return create_by - 数据创建用户id
	 */
	public Integer getCreateBy() {
		return createBy;
	}

	/**
	 * 设置数据创建用户id
	 *
	 * @param createBy 数据创建用户id
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
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
	public Integer getModifyBy() {
		return modifyBy;
	}

	/**
	 * 设置数据更新用户id
	 *
	 * @param modifyBy 数据更新用户id
	 */
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
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
}