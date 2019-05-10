package com.lucq.authority.bo;

import java.io.Serializable;

/**
 * Created by dell on 2019/1/4.
 */
public class MenuBO implements Serializable {

    private static final long serialVersionUID = 1897626659820965974L;

    private Integer id;

    private Integer levelMax;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(Integer levelMax) {
        this.levelMax = levelMax;
    }
}
