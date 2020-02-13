package com.liantong.sys.config;

//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

	/**
	 * 1.配置Cookie对象
	 * 记住我的cookie：
	 * @return  SimpleCookie Cookie
	 */
	@Bean
	public SimpleCookie Cookie() {
		//这个参数是cookie的名称，对应前端的checkbox的name = 
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		//setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：

		//setcookie()的第七个参数
		//设为true后，只能通过http访问，javascript无法访问
		//防止xss读取cookie
		simpleCookie.setHttpOnly(true);
		//<!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(60*60*24);
		return simpleCookie;
	}

	/**
	 * 2.配置cookie管理对象
	 * @return CookieManager
	 */
	@Bean
	public CookieRememberMeManager cookieManager() {
		CookieRememberMeManager cookieManager = new CookieRememberMeManager();
		cookieManager.setCookie(Cookie());
		// cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
		cookieManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		return cookieManager;
	}

	/**
	 * 对密码进行编码的，防止密码在数据库里明码保存，当然在登陆认证的生活，这个类也负责对form里输入的密码进行编码
	 * @return
	 */
	@Bean("hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher =
				new HashedCredentialsMatcher();
		//指定加密方式为MD5
		credentialsMatcher.setHashAlgorithmName("MD5");
		//加密次数
		credentialsMatcher.setHashIterations(2);
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}

	@Bean("userRealm")
	public UserRealm userRealm(@Qualifier("hashedCredentialsMatcher")
									   HashedCredentialsMatcher matcher) {

		UserRealm userRealm = new UserRealm();
		userRealm.setCredentialsMatcher(matcher);
		return userRealm;
	}

	@Bean
	public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager")
													 DefaultWebSecurityManager securityManager) {

		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		// 设置 SecurityManager
		bean.setSecurityManager(securityManager);
		// 设置登录成功跳转Url
		/*bean.setSuccessUrl("/index");
		// 设置登录跳转Url
		bean.setLoginUrl("/login");
		// 设置未授权提示Url
		bean.setUnauthorizedUrl("/error/unAuth");*/

		/**
		 * anon：匿名用户可访问
		 * authc：认证用户可访问
		 * user：使用可访问
		 * perms：对应权限可访问
		 * role：对应角色权限可访问
		 **/
		Map<String, String> filterMap = new LinkedHashMap<>();
		/*filterMap.put("/login","anon");
		filterMap.put("/static/**","anon");
		filterMap.put("/webjars/**","anon");
		filterMap.put("/common/**","authc");
		filterMap.put("/**", "user");
		filterMap.put("/index","user");*/
		bean.setFilterChainDefinitionMap(filterMap);
		return bean;
	}

	/**
	 * 注入 securityManager
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(
			HashedCredentialsMatcher hashedCredentialsMatcher) {

		DefaultWebSecurityManager securityManager =
				new DefaultWebSecurityManager();
		// 关联realm.
		securityManager.setRealm(userRealm(hashedCredentialsMatcher));
		securityManager.setRememberMeManager(cookieManager());
		return securityManager;
	}

	//会话管理器
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionIdUrlRewritingEnabled(true);
		sessionManager.setGlobalSessionTimeout(1 * 60 * 60 * 1000);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionIdCookie(Cookie());
		return sessionManager;
	}

	/*@Bean
	public ShiroDialect getShiroDialect(){
		return new ShiroDialect();
	}*/
}
