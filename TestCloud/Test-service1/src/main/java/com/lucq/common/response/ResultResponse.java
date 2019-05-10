package com.lucq.common.response;

public class ResultResponse<T> extends BaseResponse {

    
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
    
}
