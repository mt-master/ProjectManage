package com.liantong.organization.controller;

import com.liantong.organization.po.Organization;
import com.liantong.organization.po.OrganizationVo;
import com.liantong.organization.po.RegionVo;
import com.liantong.organization.service.OrganizationService;
import com.liantong.sys.util.JsonUtils;
import com.liantong.sys.util.UserUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "/",description = "组织管理")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;

	@ApiOperation(value="新增组织机构")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/createOrganization")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> createOrganization(HttpServletRequest request, HttpServletResponse response,
										 Organization organization
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserUtil.getUser();
			organizationService.createOrganization(organization);
			map.put("result", 0);
			map.put("message", "新增组织机构成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询组织机构列表")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@GetMapping(value = "/selectOrganizationList")
	public Map<String,Object> selectOrganizationList(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserUtil.getUser();
			List<OrganizationVo> list = organizationService.selectOrganization();
			map.put("organizationList",list);
			map.put("result", 0);
			map.put("message", "查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询组织机构（本节点/子节点）")
	@ApiImplicitParams({
			@ApiImplicitParam(name="parentId",value="查询单级组织机构(默认为用户所在的组织机构)",required=true ),
			@ApiImplicitParam(name="selectfalg",value="查询子节点：0，查询本级节点：1(默认为1)",dataType = "int",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@GetMapping(value = "/selectOrganization")
	public Map<String,Object> selectOrganization(HttpServletRequest request, HttpServletResponse response,
												 @RequestParam(value="parentId",required=false)long parentId
			,@RequestParam(value="selectfalg",required=false)int selectfalg) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserUtil.getUser();
			List<OrganizationVo> list = organizationService.selectOrganizationByParentId(parentId,selectfalg);
			map.put("organizationList",list);
			map.put("result", 0);
			map.put("message", "查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="删除组织机构(删除节点以下的所有子节点)")
	@ApiImplicitParams({
			@ApiImplicitParam(name="organizationId",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@DeleteMapping(value = "/deleteOrganization")
	public Map<String,Object> deleteOrganization(HttpServletRequest request, HttpServletResponse response,
													 @RequestParam(value="organizationId",required=true)long organizationId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserUtil.getUser();
			organizationService.deleteOrganization(organizationId);
			map.put("result", 0);
			map.put("message", "操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询行政区列表")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@GetMapping(value = "/selectRegionList")
	public Map<String,Object> selectRegionList(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserUtil.getUser();
			List<RegionVo> list = organizationService.selectRegionList();
			map.put("regionList",list);
			map.put("result", 0);
			map.put("message", "查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询行政区域（本节点/子节点）")
	@ApiImplicitParams({
			@ApiImplicitParam(name="parentId",value="查询单级行政区域(默认为用户所在的组织机构下的行政区域)",required=true ),
			@ApiImplicitParam(name="selectfalg",value="查询子节点：0，查询本级节点：1(默认为1)",dataType = "int",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@GetMapping(value = "/selectRegion")
	public Map<String,Object> selectRegion(HttpServletRequest request, HttpServletResponse response,
												 @RequestParam(value="parentId",required=false)String parentId
			,@RequestParam(value="selectfalg",required=false)int selectfalg) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserUtil.getUser();
			List<RegionVo> list = organizationService.selectRegion(parentId,selectfalg);
			map.put("regionList",list);
			map.put("result", 0);
			map.put("message", "查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}
}
