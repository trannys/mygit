package com.lucq.authority.vo;

import java.util.List;

/**
 * Created by dell on 2019/1/4.
 */
public class QueryMenuVO {
    private Integer id;
    private String menuName;
    private Integer parentId;

    private List<MenuVO> menuVOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<MenuVO> getMenuVOList() {
        return menuVOList;
    }

    public void setMenuVOList(List<MenuVO> menuVOList) {
        this.menuVOList = menuVOList;
    }
}
