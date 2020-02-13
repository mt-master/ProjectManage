package com.liantong.gatewayclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayclientApplication.class, args);
	}

}
