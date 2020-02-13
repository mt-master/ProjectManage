package com.liantong.user.service.impl;

import com.liantong.sys.util.JsonUtils;
import com.liantong.user.mapper.UserMapper;
import com.liantong.user.po.User;
import com.liantong.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public User selectUserByLoginId(String loginId) {
		// 查询用户是否存在
		User bean = userMapper.selectUserByLoginId(loginId);
		if (bean != null) {
			// 查询用户信息、角色、权限
			bean = userMapper.selectUserById(bean.getId());
		}
		return bean;
	}

	@Override
	public List<List<?>> selectUserList() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void cacheUserLoginInfo(HttpServletRequest request, User user) {
		/*--------------------------------获取用户IP---------------------------------*/
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		ip = ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		/*--------------------------------获取用户IP---------------------------------*/

		HttpSession session =request.getSession();
		redisTemplate.opsForValue().set(session.getId(), JsonUtils.objectToJson(user));
		redisTemplate.expire(session.getId(), 21600, TimeUnit.SECONDS);//设置用户缓存信息两小时过期
//		User kk = JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("user"), User.class);
		userMapper.updateUserLoginIP(user.getId(),ip);
	}
}