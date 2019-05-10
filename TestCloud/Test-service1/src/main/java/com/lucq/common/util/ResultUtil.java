package com.lucq.common.util;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

import com.github.pagehelper.PageInfo;
import com.lucq.common.errorcode.ErrorCodeEnum;
import com.lucq.common.response.ResultResponse;

public class ResultUtil {

    /**
     * 成功返回
     * @return
     */
    public static <T> ResultResponse<T> getSuccessResult(Class<T>  clazz) {
        ResultResponse<T> result = new ResultResponse<T>();
        result.setMsg(ErrorCodeEnum.SUCCESS.getMsg());
        result.setStatus(ErrorCodeEnum.SUCCESS.getStatus());
        return result;
    }
    
    
    /**
     *  失败返回
     * @return
     */
    public static <T> ResultResponse<T> getFailResult(Class<T>  clazz) {
        
        ResultResponse<T> result = new ResultResponse<T>();
        result.setMsg(ErrorCodeEnum.COMMON_ERROR.getMsg());
        result.setStatus(ErrorCodeEnum.COMMON_ERROR.getStatus());
        return result;
    }
    
    /**
     *  失败返回
     * @return
     */
    public static <T> ResultResponse<T> getFailResult(Class<T> clazz, ErrorCodeEnum errorCodeEnum) {
        
        ResultResponse<T> result = new ResultResponse<T>();
        result.setMsg(errorCodeEnum.getMsg());
        result.setStatus(errorCodeEnum.getStatus());
        
        return result;
    }
    
    public static ModelMap getResultMap(PageInfo<?> pageList) {
        ModelMap result = new ModelMap();
        if (null == pageList || pageList.getSize() == 0) {
            result.put("list", new ArrayList<>());
        } else {
            result.put("list", pageList.getList());
            result.put("nextPage", pageList.getNextPage());
            result.put("total", pageList.getTotal());
            result.put("prePage", pageList.getPrePage());
        }
        return result;
    }
    
    
    
}
