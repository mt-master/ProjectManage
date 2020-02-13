package com.liantong.keyword.controller;

import com.liantong.keyword.pojo.Keyword;
import com.liantong.keyword.pojo.KeywordVo;
import com.liantong.keyword.service.KeywordService;
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
@Api(value = "/",description = "关键词管理")
public class KeywordController {

	@Autowired
	KeywordService keywordService;

	@ApiOperation(value="新增关键词")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/createKeyword")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> createKeyword(HttpServletRequest request, HttpServletResponse response,
										 Keyword keyword
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			keywordService.createKeyword(keyword);
			map.put("result", 0);
			map.put("message", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="查询关键词")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/selectKeyword")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> selectKeyword(HttpServletRequest request, HttpServletResponse response
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<KeywordVo> list = keywordService.selectKeyword();
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

	@ApiOperation(value="查询禁用的关键词")
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/selectDisableKeyword")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> selectDisableKeyword(HttpServletRequest request, HttpServletResponse response
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<KeywordVo> list = keywordService.selectDisableKeyword();
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

	@ApiOperation(value="禁用关键词")
	@ApiImplicitParams({
			@ApiImplicitParam(name="keywordId",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@DeleteMapping(value = "/deleteKeyword")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> deleteKeyword(HttpServletRequest request, HttpServletResponse response,
											 @RequestParam(value="keywordId",required=true)long keywordId
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			keywordService.deleteKeyword(keywordId);
			map.put("result","0");
			map.put("message","操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}

	@ApiOperation(value="启用关键词")
	@ApiImplicitParams({
			@ApiImplicitParam(name="keywordId",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PutMapping(value = "/enableKeyword")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> enableKeyword(HttpServletRequest request, HttpServletResponse response,
											 @RequestParam(value="keywordId",required=true)long keywordId
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			keywordService.enableKeyword(keywordId);
			map.put("result","0");
			map.put("message","操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}


	@ApiOperation(value="修改关键词名称")
	@ApiImplicitParams({
			@ApiImplicitParam(name="keywordId",value="1",required=true ),
			@ApiImplicitParam(name="name",value="1",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PutMapping(value = "/updateKeyword")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> updateKeyword(HttpServletRequest request, HttpServletResponse response,
											 @RequestParam(value="keywordId",required=true)long keywordId,
											 @RequestParam(value="name",required=true)String name
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			keywordService.updateKeyword(keywordId,name);
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
