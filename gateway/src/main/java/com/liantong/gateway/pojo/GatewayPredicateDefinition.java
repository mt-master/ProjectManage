package com.liantong.gateway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 路由断言模型
 * zhuyu 2019-01-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatewayPredicateDefinition {
	//断言对应的Name
	private String name;
	//配置的断言规则
	private Map<String, String> args = new LinkedHashMap<>();

}
