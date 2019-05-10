package com.lucq.newmapper;

import com.lucq.authority.bo.MenuBO;
import com.lucq.authority.vo.MenuVO;
import com.lucq.authority.vo.QueryMenuVO;
import com.lucq.newentity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

    List<MenuVO> findMenuList(MenuBO menuBO);
}