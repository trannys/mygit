package com.lucq.utils;

import java.io.Serializable;

public class CommonRlt<T> implements Serializable {

    private static final long serialVersionUID = -5008363147174256209L;

    private String returnCode;
    private String returnMsg;
    private T data;

    public CommonRlt() {
        
    }

    public CommonRlt(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public CommonRlt(CommonMsgEnum commonMsgEnum) {
        this.returnCode = commonMsgEnum.getReturnCode();
        this.returnMsg = commonMsgEnum.getReturnMsg();
    }

    public CommonRlt(CommonMsgEnum commonMsgEnum, T data) {
        this.returnCode = commonMsgEnum.getReturnCode();
        this.returnMsg = commonMsgEnum.getReturnMsg();
        this.data = data;
    }

    public void setError(CommonMsgEnum commonMsgEnum) {
        this.returnCode = commonMsgEnum.getReturnCode();
        this.returnMsg = commonMsgEnum.getReturnMsg();
    }

    public void setError(BusinessException e) {
        this.returnCode = e.getErrCode();
        this.returnMsg = e.getErrMsg();
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return this.returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonRlt{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", data=" + data +
                '}';
    }
}