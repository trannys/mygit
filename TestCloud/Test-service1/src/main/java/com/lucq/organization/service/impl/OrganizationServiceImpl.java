package com.lucq.organization.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucq.common.BusinessException;
import com.lucq.common.CommonConstants;
import com.lucq.common.State;
import com.lucq.common.errorcode.ErrorCodeEnum;
import com.lucq.common.response.ResultResponse;
import com.lucq.common.util.ResultUtil;
import com.lucq.entity.Organization;
import com.lucq.mapper.OrganizationMapper;
import com.lucq.organization.bo.AddOrganizationBo;
import com.lucq.organization.bo.QueryOrganizationBo;
import com.lucq.organization.service.OrganizationService;
import com.lucq.organization.vo.QueryOrganizationVo;
import com.lucq.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service("organizationService")
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
    
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public ResultResponse<String> createOrganization(AddOrganizationBo addOrganizationBo) {
        
        log.info("The input params of  createOrganization  is   {}", addOrganizationBo);
        
        ResultResponse<String> result = ResultUtil.getSuccessResult(String.class);
        
        if (null == addOrganizationBo) {
            result.setStatus(ErrorCodeEnum.PARAMS_NULL.getStatus());
            result.setMsg(ErrorCodeEnum.PARAMS_NULL.getMsg());
            return result;
        }
        
        try {
            //判断参数的合法性
            addOrganizationBo.checkParams();
            
            //判断该机构是否已经注册过
            checkDisplayName(addOrganizationBo.getDisplayName(), null);
            
            //插入机构信息
            int dataResult = addOrganization(addOrganizationBo);
            
            if (!CommonConstants.DB_SUCCESS.equals(dataResult)) {
                log.info("The createOrganization's data insert DB fail.");
                result.setError("The createOrganization's data insert DB fail.");
            } 
        } catch (BusinessException e) {
            log.error("The createAccount's running is error : {}", e);
            result.setError(e.getErrCode(), e.getErrMsg());
            return result;
        } catch (Exception e) {
            log.error("The createAccount's running is error : {}", e);
            result.setError(ErrorCodeEnum.BUSINESS_ERROR);
            return result;
        }
        return result;
    }
    
    /**
     * 判断企业是否已经注册过
     * @param displayName
     * @param exceptId 用于更新时查询是否已经存在此机构名称 插入时exceptId传null
     * @throws BusinessException
     */
    private void checkDisplayName(String displayName, Integer exceptId) throws BusinessException {
        
        QueryOrganizationBo queryOrganizationBo = new QueryOrganizationBo();
        queryOrganizationBo.setDisplayName(displayName);
        queryOrganizationBo.setExceptId(exceptId);
        
        List<QueryOrganizationVo> orgList = organizationMapper.queryOrganizationList(queryOrganizationBo);
        
        if (!CollectionUtils.isEmpty(orgList)) {
            throw new BusinessException(ErrorCodeEnum.ORGANIZATION_EXISTS);
        }
    }
    
    
    @Override
    public int addOrganization(AddOrganizationBo addOrganizationBo) {
        Date date = new Date();
        Organization organization = new Organization();
        organization.setAddress(addOrganizationBo.getAddress());
        organization.setCity(addOrganizationBo.getCity());
        organization.setCode(addOrganizationBo.getCode());
        organization.setCreateBy(Integer.parseInt(CommonConstants.SYSTEM_ID));
        organization.setCreateTime(date);
        organization.setDisplayName(addOrganizationBo.getDisplayName());
        organization.setLatitude(addOrganizationBo.getLatitude());
        organization.setLongitude(addOrganizationBo.getLongitude());
        organization.setState(State.STATE_VALID);
        organization.setModifyBy(Integer.parseInt(CommonConstants.SYSTEM_ID));
        organization.setModifyTime(date);
        
        return organizationMapper.insertSelective(organization);
    }

    @Override
    public ResultResponse<String> updateOrganization(AddOrganizationBo addOrganizationBo) {
        log.info("The input params of  updateOrganization  is   {}", addOrganizationBo);
        
        ResultResponse<String> result = ResultUtil.getSuccessResult(String.class);
        
        if (null == addOrganizationBo || null == addOrganizationBo.getId()) {
            result.setStatus(ErrorCodeEnum.ORGANIZATION_NULL.getStatus());
            result.setMsg(ErrorCodeEnum.ORGANIZATION_NULL.getMsg());
            return result;
        }
        
        try {
            
            //如果修改企业名称, 判断企业是否已经存在
            if (StringUtils.isEmpty(addOrganizationBo.getDisplayName())) {
                checkDisplayName(addOrganizationBo.getDisplayName(), addOrganizationBo.getId());
            }
            
            Organization organization = JSON.parseObject(JSON.toJSONString(addOrganizationBo), Organization.class);
            organization.setModifyTime(new Date());
            
            //修改机构信息
            organizationMapper.updateByPrimaryKeySelective(organization);
        
        } catch (BusinessException e) {
            log.error("The updateOrganization's running is error : {}", e);
            result.setError(e.getErrCode(), e.getErrMsg());
            return result;
        } catch (Exception e) {
            log.error("The updateOrganization's running is error : {}", e);
            result.setError(ErrorCodeEnum.BUSINESS_ERROR);
            return result;
        }
        return result;
    }

    @Override
    public ResultResponse<String> delOrganization(Integer id) {
        
        log.info("The input params of  delOrganization  is   {}", id);
        
        ResultResponse<String> result = ResultUtil.getSuccessResult(String.class);
        
        if (null == id) {
            result.setStatus(ErrorCodeEnum.ORGANIZATION_NULL.getStatus());
            result.setMsg(ErrorCodeEnum.ORGANIZATION_NULL.getMsg());
            return result;
        }

        try {

            Organization organization = organizationMapper.selectByPrimaryKey(id);
            if (null == organization) {
                log.error("机构不存在");
                result.setStatus(ErrorCodeEnum.ORGANIZATION_NOT_EXISTS.getStatus());
                result.setMsg(ErrorCodeEnum.ORGANIZATION_NOT_EXISTS.getMsg());
                return result;
            }

            //逻辑删除机构信息
            organization = new Organization();
            organization.setId(id);
            organization.setState(State.STATE_NO_VALID);
            organizationMapper.updateByPrimaryKeySelective(organization);

        } catch (Exception e) {
            log.error("The updateOrganization's running is error : {}", e);
            result.setError(ErrorCodeEnum.BUSINESS_ERROR);
            return result;
        }
        return result;
    }

    @Override
    public ResultResponse<ModelMap> queryOrganizationList(QueryOrganizationBo queryOrganizationBo) {

        log.info("The input params of  queryOrganizationList  is   {}", queryOrganizationBo);

        ResultResponse<ModelMap> result = ResultUtil.getSuccessResult(ModelMap.class);
        if (null == queryOrganizationBo) {
            queryOrganizationBo = new QueryOrganizationBo();
        }

        queryOrganizationBo.setState(State.STATE_VALID);//查询有效数据

        PageHelper.startPage(queryOrganizationBo.getPageNum(), queryOrganizationBo.getPageSize());

        List<QueryOrganizationVo> dataList =  organizationMapper.queryOrganizations(queryOrganizationBo);

        PageInfo<QueryOrganizationVo> pageList = new PageInfo<>(dataList);

        log.info("The dataList is {}", pageList);

        result.setData(ResultUtil.getResultMap(pageList));

        return result;
    }


}
