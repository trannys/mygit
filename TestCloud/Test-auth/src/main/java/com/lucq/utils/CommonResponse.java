package com.lucq.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * HTTP协议请求响应报文
 */
public class CommonResponse {
    public static ResponseEntity response(Object o, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-store");
        headers.set("Pragma", "no-cache");
        return new ResponseEntity(o, headers, status);
    }
}


