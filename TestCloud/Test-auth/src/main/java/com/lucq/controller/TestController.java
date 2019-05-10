package com.lucq.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2019/4/18.
 */
@RestController
@RequestMapping("/v1/")
public class TestController {

    @PostMapping("list")
    public ModelMap getList() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("sss", "你好");
        return modelMap;
    }
}
