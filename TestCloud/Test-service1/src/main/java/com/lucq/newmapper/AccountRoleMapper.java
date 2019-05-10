package com.lucq.newmapper;

import com.lucq.newentity.AccountRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountRole record);

    int insertSelective(AccountRole record);

    AccountRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountRole record);

    int updateByPrimaryKey(AccountRole record);
}