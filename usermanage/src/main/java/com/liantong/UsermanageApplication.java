package com.liantong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.liantong.*.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class UsermanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanageApplication.class, args);
	}

}
