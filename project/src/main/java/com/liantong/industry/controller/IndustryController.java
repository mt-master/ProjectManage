package com.liantong.industry.controller;

import com.liantong.industry.pojo.Industry;
import com.liantong.industry.pojo.IndustryVo;
import com.liantong.industry.service.IndustryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "/",description = "行业管理")
public class IndustryController {

	@Autowired
	IndustryService industryService;

	@ApiOperation(value="新增行业")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/createIndustry")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> createIndustry(HttpServletRequest request, HttpServletResponse response,
										 Industry industry
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			industryService.createIndustry(industry);
			map.put("result", 0);
			map.put("message", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询行业")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/selectIndustry")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> selectIndustry(HttpServletRequest request, HttpServletResponse response
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<IndustryVo> list = industryService.selectIndustry();
			map.put("result","0");
			map.put("message","操作成功");
			map.put("list",list);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询禁用的行业")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/selectDisableIndustry")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> selectDisableIndustry(HttpServletRequest request, HttpServletResponse response
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<IndustryVo> list = industryService.selectDisableIndustry();
			map.put("result","0");
			map.put("message","操作成功");
			map.put("list",list);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="禁用行业")
	@ApiImplicitParams({
			@ApiImplicitParam(name="industryId",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@DeleteMapping(value = "/deleteIndustry")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> deleteIndustry(HttpServletRequest request, HttpServletResponse response,
											 @RequestParam(value="industryId",required=true)long industryId
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			industryService.deleteIndustry(industryId);
			map.put("result","0");
			map.put("message","操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="启用行业")
	@ApiImplicitParams({
			@ApiImplicitParam(name="industryId",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PutMapping(value = "/enableIndustry")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> enableIndustry(HttpServletRequest request, HttpServletResponse response,
											 @RequestParam(value="industryId",required=true)long industryId
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			industryService.enableIndustry(industryId);
			map.put("result","0");
			map.put("message","操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="修改行业名称")
	@ApiImplicitParams({
			@ApiImplicitParam(name="industryId",value="1",required=true ),
			@ApiImplicitParam(name="name",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PutMapping(value = "/updateIndustry")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> updateIndustry(HttpServletRequest request, HttpServletResponse response,
											 @RequestParam(value="industryId",required=true)long industryId,
											 @RequestParam(value="name",required=true)String name
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			industryService.updateIndustry(industryId,name);
			map.put("result","0");
			map.put("message","操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}
}
