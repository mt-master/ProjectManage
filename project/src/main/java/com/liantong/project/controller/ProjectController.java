package com.liantong.project.controller;

import com.liantong.project.pojo.Project;
import com.liantong.project.service.ProjectService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "/",description = "项目管理")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@ApiOperation(value="新增项目")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/createProject")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> createUser(HttpServletRequest request, HttpServletResponse response,
										 Project project) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			projectService.createProject(project);
			map.put("result", 0);
			map.put("message", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询项目列表")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/selectProjectList")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> selectProjectList(HttpServletRequest request, HttpServletResponse response,
										 Project project) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {

//			List<List<?>> list = projectService.selectProjectList();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}
}
