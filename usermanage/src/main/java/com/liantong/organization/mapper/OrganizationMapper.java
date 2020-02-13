package com.liantong.organization.mapper;

import com.liantong.organization.po.Organization;
import com.liantong.organization.po.OrganizationVo;
import com.liantong.organization.po.RegionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper {

	/**
	 * 新增组织机构
	 * @param organization
	 */
	void createOrganization(Organization organization);

	/**
	 * 统计组织机构个数
	 * @return
	 */
	int countOrganization();

	/**
	 * 查询节点的父节点编码
	 * @return
	 */
	String selectParentCodeById(@Param("id") long id);

	/**
	 * 查询同名的组织机构
	 */
	boolean selectOrganizationByName(@Param("name") String name);

	/**
	 * 查询组织机构列表
	 * @param organizationId
	 * @return
	 */
	List<OrganizationVo> selectOrganization(@Param("organizationId") long organizationId);

	/**
	 * 查询组织机构的父节点
	 * @param id
	 * @return
	 */
	Organization selectParentOrganiationById(@Param("id") long id);

	/**
	 * 查询组织机构下的行政区列表
	 * @param organizationId
	 * @return
	 */
	List<RegionVo> selectRegion(@Param("organizationId") long organizationId);

	/**
	 * 查询组织机构本级节点
	 * @param organizationId
	 * @return
	 */
	List<OrganizationVo> selectOrganizationByOrganizationId(@Param("organizationId") long organizationId);

	/**
	 * 查询组织机构子节点
	 * @param parentId
	 * @return
	 */
	List<OrganizationVo> selectOrganizationByParentId(@Param("parentId") long parentId);

	/**
	 * 根据组织机构ID修改isParent
	 * @param organizationId
	 */
	void updateIsParentByOrganizationId(@Param("organizationId") long organizationId);

	/**
	 * 通过组织机构查询当前下的行政区
	 * @param organizationId
	 * @return
	 */
	List<RegionVo> selectRegionByOrganizationId(@Param("organizationId") long organizationId);

	/**
	 * 通过组织机构查询当前下的行政区
	 * @param regionId
	 * @return
	 */
	List<RegionVo> selectRegionByRegionId(@Param("regionId") String regionId);

	/**
	 * 通过组织机构查询当前下的行政区
	 * @param parentId
	 * @return
	 */
	List<RegionVo> selectRegionByParentId(@Param("parentId") String parentId);

	void deleteOrganization(@Param("parentcode") String parentcode);
}
