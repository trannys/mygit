package com.lucq.organization.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.lang.NonNull;

import com.lucq.common.BusinessException;
import com.lucq.common.errorcode.ErrorCodeEnum;
import com.lucq.util.StringUtils;

public class AddOrganizationBo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4253680958747714024L;

    /**
     * 机构id
     */
    private Integer id;
    /**
     * 机构名称
     */
    @NonNull
    private String displayName;

    /**
     * 机构地址
     */
    @NonNull
    private String address;

    /**
     * 纬度
     */
    @NonNull
    private BigDecimal latitude;

    /**
     * 经度
     */
    @NonNull
    private BigDecimal longitude;

    /**
     * 中心编码
     */
    @NonNull
    private String code;

    /**
     * 城市id
     */
    @NonNull
    private Integer city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * 校验必需参数
     * 
     * @throws BusinessException
     */
    public void checkParams() throws BusinessException {

        if (StringUtils.isEmpty(this.displayName)) {
            throw new BusinessException(ErrorCodeEnum.ORGANIZATION_DISPLAY_NAME_NULL);
        }
        if (StringUtils.isEmpty(this.address)) {
            throw new BusinessException(ErrorCodeEnum.ORGANIZATION_ADDRESS_NULL);
        }
        if (null == this.latitude) {
            throw new BusinessException(ErrorCodeEnum.LATITUDE_NULL);
        }
        if (null == this.longitude) {
            throw new BusinessException(ErrorCodeEnum.LONGITUDE_NULL);
        }
        if (null == this.code) {
            throw new BusinessException(ErrorCodeEnum.CODE_NULL);
        }
        if (null == this.city) {
            throw new BusinessException(ErrorCodeEnum.CITY_ID_NULL);
        }

    }

}
