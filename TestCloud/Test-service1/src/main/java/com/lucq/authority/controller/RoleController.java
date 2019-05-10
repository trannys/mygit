package com.lucq.authority.controller;

import com.lucq.authority.bo.MenuBO;
import com.lucq.authority.vo.MenuVO;
import com.lucq.authority.vo.QueryMenuVO;
import com.lucq.newmapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dell on 2019/1/4.
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @GetMapping("/menu/list")
    public ModelMap getMenuList() {
        MenuBO menuBO = new MenuBO();
        menuBO.setId(1);
        menuBO.setLevelMax(1);

        //只查询0有和1级菜单
        List<MenuVO> menuVOList =  roleMenuMapper.findMenuList(menuBO);

        ModelMap modelMap = new ModelMap();
        modelMap.put("menuVOList", menuVOList);

        return modelMap;
    }

}
