package com.lucq.common.errorcode;

public enum ErrorCodeEnum {
	
	SUCCESS("0000","成功"),
	COMMON_ERROR("9999","失败"),
	BUSINESS_ERROR("1111","业务异常,请稍后"),
	PARAMS_NULL("40000000","参数不能为空"),
	PHONE_NUMBER_FORMAT_ERROR("40000001","手机格式不正确"),
	MAIL_FORMAT_ERROR("40000002","邮箱格式不正确"),
	PHONE_NUMBER_NULL("40000003","电话号码不能为空"),
	ACCOUNT_DISPLAY_NAME_NULL("40000004","用户名不能为空"),
	ACCOUNT_PASSWORD_NULL("40000005","密码不能为空"),
	MAIL_NULL("40000006","邮箱不能为空"),
	ORGANIZATION_NULL("40000007","机构编号不能为空"),
	ORGANIZATION_DISPLAY_NAME_NULL("40000008","机构名称不能为空"),
	ORGANIZATION_ADDRESS_NULL("40000009","机构地址不能为空"),
	LATITUDE_NULL("40000010","纬度不能为空"),
	LONGITUDE_NULL("40000011","经度不能为空"),
	CODE_NULL("40000012","中心编码不能为空"),
	CITY_ID_NULL("40000013","城市编号不能为空"),
	PHONE_NUMBER_EXISTS("40000014","此手机号码已注册，请确认后重试"),
	ORGANIZATION_EXISTS("40000015","该机构已注册，请确认后重试"),
	ORGANIZATION_NOT_EXISTS("40000016","该机构不存在，请确认后重试"),
	ACCOUNT_ID_NULL("40000017","账号不能为空，请确认后重试"),
	ACCOUNT_NOT_EXISTS("40000018","账号不存在，请确认后重试"),

	;
	
	private String status;
	
	private String msg;
	
	private ErrorCodeEnum(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	
	
	

}
