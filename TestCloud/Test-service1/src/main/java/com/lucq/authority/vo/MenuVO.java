package com.lucq.authority.vo;

import java.util.Date;

/**
 * Created by dell on 2019/1/4.
 */
public class MenuVO {

    private Integer id;

    private String menuName;

    private Integer level;

    private Integer parentId;

    private Date createTime;


    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
