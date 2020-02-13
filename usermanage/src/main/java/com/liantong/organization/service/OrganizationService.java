package com.liantong.organization.service;

import com.liantong.organization.po.Organization;
import com.liantong.organization.po.OrganizationVo;
import com.liantong.organization.po.RegionVo;

import java.util.List;

public interface OrganizationService {

	void createOrganization(Organization organization) throws Exception;

	List<OrganizationVo> selectOrganization() throws Exception;

	void deleteOrganization(long organizationId) throws Exception;

	List<RegionVo> selectRegionList() throws Exception;

	List<OrganizationVo> selectOrganizationByParentId(long parentId,int selectfalg) throws Exception;

	List<RegionVo> selectRegion(String parentId,int selectfalg) throws Exception;
}
