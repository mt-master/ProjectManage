package com.liantong.gatewayclient.sys.config;

import com.liantong.gatewayclient.sys.util.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringContextHolderConfig {
		
	 @Bean
	 public SpringContextHolder springContextHolder() {
		 SpringContextHolder springContextHolder = new SpringContextHolder();
		 return springContextHolder;
	 }
}
