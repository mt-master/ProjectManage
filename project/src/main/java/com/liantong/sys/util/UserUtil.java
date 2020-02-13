package com.liantong.sys.util;

import com.liantong.sys.po.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
	@SuppressWarnings("rawtypes")
	private static RedisTemplate redisTemplate = SpringContextHolder.getBean(RedisTemplate.class);

	private static final String USERSESSION = "userSession";

	/**
	 * 获取系统当前操作人的信息
	 * @return UserLoginInfo 用户对象信息
	 */
	public static User getUser() throws Exception{
		HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		String userSessionHeader = request.getHeader(USERSESSION);

		User uli;

		if(userSessionHeader != null && !userSessionHeader.equals("")) {

			uli  =JsonUtils.jsonToPojo((String)redisTemplate.opsForValue().get(userSessionHeader),User.class);
		}else {
			HttpSession session =request.getSession();
			uli  =JsonUtils.jsonToPojo((String)redisTemplate.opsForValue().get(session.getId()),User.class);
		}
		if(uli==null){
			throw  new Exception("请登录后操作");
		}
		return uli;
	}
}
