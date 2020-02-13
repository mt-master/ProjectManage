package com.liantong.sys.config;

import com.liantong.user.po.Permission;
import com.liantong.user.po.Role;
import com.liantong.user.po.User;
import com.liantong.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;

	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("执行授权逻辑");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Set<Role> roles = user.getRoles();
		Collection<String> permissionCollection = new HashSet<>();
		Collection<String> roleCollection = new HashSet<>();
		for(Role role:roles){
			roleCollection.add(role.getName());
			Set<Permission> permissions = role.getPermissions();
			for(Permission permission:permissions){
				permissionCollection.add(permission.getUrl());
			}
		}
		info.addStringPermissions(permissionCollection);
		info.addRoles(roleCollection);
		return info;
	}

	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = userService.selectUserByLoginId(token.getUsername());
		if(user==null){
			//用户名不存在
			return null;//shiro底层会抛出UNKnowAccountException
		}
		ByteSource source = ByteSource.Util.bytes(user.getMss());
		//判断密码
		return new SimpleAuthenticationInfo(user,user.getPassword(),source,getName());
	}
}
