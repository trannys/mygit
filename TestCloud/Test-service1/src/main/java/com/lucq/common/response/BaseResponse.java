package com.lucq.common.response;

import com.lucq.common.errorcode.ErrorCodeEnum;

/**
 * 返回结果
 * @author dell
 *
 */
public class BaseResponse {
    
    /**
                 * 返回状态
     */
    private String status = ErrorCodeEnum.SUCCESS.getStatus();
    
    /**
                 * 返回信息
     */
    private String msg = ErrorCodeEnum.SUCCESS.getMsg();
    
    
    

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

    public Boolean isSuccess() {
        
        return ErrorCodeEnum.SUCCESS.getStatus().equals(status);
    }
    
    public void setError(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public void setError(ErrorCodeEnum errorCodeEnum) {
        this.status = errorCodeEnum.getStatus();
        this.msg = errorCodeEnum.getMsg();
    }
    
    public void setError(String msg) {
        this.status = ErrorCodeEnum.COMMON_ERROR.getStatus();
        this.msg = msg;
    }
    
    

}
