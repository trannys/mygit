package com.lucq.organization.service;

import com.lucq.common.response.ResultResponse;
import com.lucq.organization.bo.AddOrganizationBo;
import com.lucq.organization.bo.QueryOrganizationBo;
import org.springframework.ui.ModelMap;

/**
 * 机构相关服务
 * @author dell
 *
 */
public interface OrganizationService {

    /**
     * 创建机构信息
     * @param addOrganizationBo
     * @return
     */
    public ResultResponse<String> createOrganization(AddOrganizationBo addOrganizationBo);
    
    /**
     * 机构信息入库
     * @param addOrganizationBo
     * @return
     */
    public int addOrganization(AddOrganizationBo addOrganizationBo);
    
    
    /**
     * 修改机构信息
     * @param addOrganizationBo
     * @return
     */
    public ResultResponse<String> updateOrganization(AddOrganizationBo addOrganizationBo);
    
    /**
     * 删除机构信息
     * @param id
     * @return
     */
    public ResultResponse<String> delOrganization(Integer id);

    /**
     * 查询机构信息
     * @param queryOrganizationBo
     * @return
     */
    public ResultResponse<ModelMap> queryOrganizationList(QueryOrganizationBo queryOrganizationBo);
}
