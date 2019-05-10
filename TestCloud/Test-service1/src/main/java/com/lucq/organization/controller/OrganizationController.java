package com.lucq.organization.controller;

import com.lucq.common.response.ResultResponse;
import com.lucq.organization.bo.AddOrganizationBo;
import com.lucq.organization.bo.QueryOrganizationBo;
import com.lucq.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("organizationController")
@RequestMapping("organization/")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    
    
    /**
     * 创建机构信息
     * @param addOrganizationBo
     * @return
     */
    @PostMapping("/createOrganization")
    public ResultResponse<String> createOrganization(AddOrganizationBo addOrganizationBo) {
        
        return organizationService.createOrganization(addOrganizationBo);
    }

    /**
     * 修改机构信息
     * @param addOrganizationBo
     * @return
     */
    @PostMapping("/updateOrganization")
    public ResultResponse<String> updateOrganization(AddOrganizationBo addOrganizationBo) {

        return organizationService.updateOrganization(addOrganizationBo);
    }

    /**
     * 逻辑删除机构信息
     * @param id
     * @return
     */
    @PostMapping("/delOrganization")
    public ResultResponse<String> delOrganization(@RequestParam("id") Integer id) {

        return organizationService.delOrganization(id);
    }

    /**
     * 创建机构信息
     * @param queryOrganizationBo
     * @return
     */
    @PostMapping("/queryOrganizationList")
    public ResultResponse<ModelMap> queryOrganizationList(QueryOrganizationBo queryOrganizationBo) {

        return organizationService.queryOrganizationList(queryOrganizationBo);
    }
    
}
