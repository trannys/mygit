package com.lucq.mapper;

import com.lucq.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}