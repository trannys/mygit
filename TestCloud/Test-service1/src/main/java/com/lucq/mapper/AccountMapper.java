package com.lucq.mapper;

import com.lucq.account.bo.QueryAccountBo;
import com.lucq.account.vo.QueryAccountVo;
import com.lucq.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<QueryAccountVo> queryAccountInfo(QueryAccountBo queryAccountBo);
}