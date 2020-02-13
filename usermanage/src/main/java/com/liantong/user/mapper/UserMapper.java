package com.liantong.user.mapper;

import com.liantong.user.po.Role;
import com.liantong.user.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

	// 查询用户信息
	User selectUserByLoginId(String loginId);

	// 查询用户信息、角色、权限
	User selectUserById(long id);

	//查询用户列表
//	List<List<?>> selectUserList();

	//查询角色列表
	List<Role> selectRoleList();

	//更新登录用户的ip地址
	void updateUserLoginIP(@Param("id") long id, @Param("ip") String ip);
}
