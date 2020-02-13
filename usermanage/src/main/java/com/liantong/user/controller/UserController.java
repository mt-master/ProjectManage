package com.liantong.user.controller;

import com.liantong.organization.po.Organization;
import com.liantong.sys.util.JsonUtils;
import com.liantong.user.po.User;
import com.liantong.user.service.UserService;
import com.liantong.sys.util.UserUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "/",description = "用户管理")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value="查询用户信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name="realname",value="模糊用户名：‘李’" ),
			@ApiImplicitParam(name="organizationName",value="模糊组织机构名：‘李’" ),
			@ApiImplicitParam(name="roleId",value="角色ID：‘15516823121811007a6c6c72abc30000’" ),
			@ApiImplicitParam(name="pageNo",value="当前页码：‘1’",required=true ),
			@ApiImplicitParam(name="pageSize",value="分页大小：‘10’",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
//	@RequiresPermissions(value = "sys:permission:view")
	@GetMapping(value = "/queryUserList")
	public Map<String,Object> queryUserList(HttpServletRequest request, HttpServletResponse response,
											@RequestParam(value="realname",required=false) String realname,
											@RequestParam(value="organizationName",required=false) String organizationName,
											@RequestParam(value="roleId",required=false) String roleId,
											@RequestParam(value="pageNo",defaultValue="1",required=true) int pageNo,
											@RequestParam(value="pageSize",defaultValue="10",required=true) int pageSize
	) {
		Map<String,Object> map = new HashMap<String,Object>();

		try {
			String gridIDLike = "";

			User user = UserUtil.getUser();

			List<List<?>> list = userService.selectUserList();

//			List<List<?>> cl = userCurdService.selectUserList(gridIDLike,realname,organizationName,roleId,(pageNo-1)*pageSize,pageSize);
//			int count = (Integer)cl.get(1).get(0);
//			@SuppressWarnings("unchecked")
//			List<UserPage> list = (List<UserPage>) cl.get(0);
			map.put("userList", list);
			map.put("result", 0);
			map.put("message", "用户列表查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}

		return map;
	}

	@ApiOperation(value="新增用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name="organizationInfo",value="{\n" +
					"\t\"name\": \"\",\n" +
					"\t\"parentId\": \"\",\n" +
					"\t\"regionId\": \"\"\n" +
					"}",required=true ),

	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	@PostMapping(value = "/createUser")
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Map<String,Object> createUser(HttpServletRequest request, HttpServletResponse response,
												 User user
	) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {

		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 1);
			map.put("message", e.getMessage());
		}
		return map;
	}
}
