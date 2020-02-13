package com.liantong.user.controller;

import com.liantong.user.po.User;
import com.liantong.user.service.UserService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/",description = "登录")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	@ApiOperation(value = "用户登录",httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name="loginId",value="user",required=true ),
			@ApiImplicitParam(name="password",value="123456",required=true )
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数没填好"),
			@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	})
	public Map<String,Object> login(HttpServletRequest request,String loginId,String password){
		Map<String,Object> map = new HashMap<>();
		if(loginId==null&&password==null){
			map.put("msg", "请输入账号密码");
			map.put("code","0");
			return map;
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =null;
		token = new UsernamePasswordToken(loginId,password);
		try {
			subject.login(token);
			User user=(User) subject.getPrincipal();
			user.setPassword(null);
			userService.cacheUserLoginInfo(request,user);
			//登录成功
			map.put("SessionId", request.getSession().getId());
			map.put("user",user);
			map.put("code","1");
			map.put("msg","登录成功");
			return map;
		}catch (UnknownAccountException e) {
			map.put("code","0");
			map.put("msg","用户名不存在");
		}catch (IncorrectCredentialsException e) {
			map.put("code","0");
			map.put("msg", "密码错误");
		}
		return map;
	}

}
