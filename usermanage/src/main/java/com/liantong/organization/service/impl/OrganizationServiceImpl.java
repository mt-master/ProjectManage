package com.liantong.organization.service.impl;

import com.liantong.organization.mapper.OrganizationMapper;
import com.liantong.organization.po.Organization;
import com.liantong.organization.po.OrganizationVo;
import com.liantong.organization.po.RegionVo;
import com.liantong.organization.service.OrganizationService;
import com.liantong.sys.util.IdWorker;
import com.liantong.sys.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationMapper organizationMapper;

	@Override
	public void createOrganization(Organization organization) throws Exception{
		long id = IdWorker.nextId();
		organization.setId(id);
		if(organizationMapper.selectOrganizationByName(organization.getName())){
			throw new Exception("名称重复");
		}
		int code = organizationMapper.countOrganization()+1;
		String parentCode = organizationMapper.selectParentCodeById(organization.getParentId());
		if(parentCode!=null&&!("".equals(parentCode))){
			parentCode = parentCode+code+"/";
		}else{
			parentCode = code+"/";
		}
		organizationMapper.updateIsParentByOrganizationId(organization.getParentId());
		organization.setParentCode(parentCode);
		organization.setCode(code);
		organization.setCreateTime(new Date());
		organization.setIsParent('0');
		organization.setCreateBy(UserUtil.getUser().getId());
		organizationMapper.createOrganization(organization);
	}

	@Override
	public List<OrganizationVo> selectOrganization() throws Exception {
		long organizationId = UserUtil.getUser().getOrganizationId();
		List<OrganizationVo> list = organizationMapper.selectOrganization(organizationId);
		return list;
	}

	@Override
	public void deleteOrganization(long organizationId) throws Exception {
		String parentcode = organizationMapper.selectParentCodeById(organizationId);
		organizationMapper.deleteOrganization(parentcode);
	}

	@Override
	public List<RegionVo> selectRegionList() throws Exception {
		long organizationId = UserUtil.getUser().getOrganizationId();
		List<RegionVo> list = organizationMapper.selectRegion(organizationId);
		return list;
	}

	@Override
	public List<OrganizationVo> selectOrganizationByParentId(long parentId,int selectfalg) throws Exception {
		List<OrganizationVo> list= null;
		if(parentId==0||("").equals(parentId)){
			parentId = UserUtil.getUser().getOrganizationId();
		}
		if(selectfalg==1){
			list = organizationMapper.selectOrganizationByOrganizationId(parentId);
		}else{
			list = organizationMapper.selectOrganizationByParentId(parentId);
		}
		return list;
	}

	@Override
	public List<RegionVo> selectRegion(String parentId,int selectfalg) throws Exception {
		List<RegionVo> list= null;
		if(parentId==null||("").equals(parentId)){
			long organizationId = UserUtil.getUser().getOrganizationId();
			list = organizationMapper.selectRegionByOrganizationId(organizationId);
		}
		if(selectfalg==1){
			list = organizationMapper.selectRegionByRegionId(parentId);
		}else{
			list = organizationMapper.selectRegionByParentId(parentId);
		}
		return list;
	}
}
