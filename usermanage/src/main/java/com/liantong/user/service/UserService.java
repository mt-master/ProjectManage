package com.liantong.user.service;

import com.liantong.user.po.Role;
import com.liantong.user.po.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * UserService抽象接口
 */
public interface UserService {

	User selectUserByLoginId(String loginId);

	List<List<?>> selectUserList();

	void cacheUserLoginInfo(HttpServletRequest request, User user);
}