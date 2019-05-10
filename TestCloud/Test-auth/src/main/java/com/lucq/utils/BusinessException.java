package com.lucq.utils;


public class BusinessException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -8756996255820895805L;
    
    private String errCode; 
    
    private String errMsg;
    
    public BusinessException() {
        this.errCode = CommonMsgEnum.SERVICE_UNAVAILABLE.getReturnCode();
        this.errMsg = CommonMsgEnum.SERVICE_UNAVAILABLE.getReturnMsg();
    }
    public BusinessException(String errorMsg) {
        this.errCode = CommonMsgEnum.SERVICE_UNAVAILABLE.getReturnCode();
        this.errMsg = errorMsg;
    }
    
    public BusinessException(CommonMsgEnum errorCodeEnum) {
        this.errCode =  errorCodeEnum.getReturnCode();
        this.errMsg = errorCodeEnum.getReturnMsg();
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
