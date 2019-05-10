package com.lucq.common;

import com.lucq.common.errorcode.ErrorCodeEnum;

public class BusinessException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -8756996255820895805L;
    
    private String errCode; 
    
    private String errMsg;
    
    public BusinessException() {
        this.errCode =  ErrorCodeEnum.BUSINESS_ERROR.getStatus();
        this.errMsg = ErrorCodeEnum.BUSINESS_ERROR.getMsg();
    }
    
    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        this.errCode =  errorCodeEnum.getStatus();
        this.errMsg = errorCodeEnum.getMsg();
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    
    
}
