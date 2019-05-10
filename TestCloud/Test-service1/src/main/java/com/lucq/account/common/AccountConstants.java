package com.lucq.account.common;

public interface AccountConstants {

    /**
                 * 正则表达式：验证手机号
     */
    String MOBILE_REGEX = "^1\\d{10}$";
    
    /**
                 * 正则表达式：验证邮箱
     */
    String EMIAL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    
    
    
}
