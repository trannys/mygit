package com.lucq.common;

/**
 * 数据状态
 * @author dell
 *
 */
public interface State {
    
    /**
     * 数据状态0 无效；1 有效；-1 删除
     */
    int STATE_NO_VALID = 0;

    int STATE_VALID = 1;
    
    int STATE_DELETE = -1;
}
