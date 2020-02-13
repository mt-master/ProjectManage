package com.liantong.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

// 启动时加载类
@Configuration
// 启用Swagger API文档
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createOuterRestApi() {

		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("userSession").description("用户session")
				.modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build(); //header中的ticket参数非必填，传空也可以
		pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(outerApiInfo())
				.globalOperationParameters(pars)
				.select()
				//.apis(MutipartBasePackageUtil.basePackage("ServerUser.rolePermission.controller"))
				.apis(MutipartBasePackageUtil.basePackage("com.liantong"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo outerApiInfo() {//swagger-ui 外部接口的顶部标题信息
		return new ApiInfoBuilder()
				.title("集成集约化管理系统")
				.description(" <strong>使用本服务名称为项目管理（project）</strong>")
				.version("1.0.0")
				.build();
	}


}
