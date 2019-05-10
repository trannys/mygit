package com.lucq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucq.entity.Organization;
import com.lucq.organization.bo.QueryOrganizationBo;
import com.lucq.organization.vo.QueryOrganizationVo;

@Mapper
public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    /**
     * 查询机构是否存在
     * @param queryOrganizationBo
     * @return
     */
    List<QueryOrganizationVo> queryOrganizationList(QueryOrganizationBo queryOrganizationBo);


    /**
     * 查询机构列表
     * @param queryOrganizationBo
     * @return
     */
    List<QueryOrganizationVo> queryOrganizations(QueryOrganizationBo queryOrganizationBo);
    
}