package com.liantong.gatewayclient.sys.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String apName;
	
    private static final String API_URI = "/v2/api-docs";
    
    @SuppressWarnings("unused")
	private final RouteLocator routeLocator;
    
    @SuppressWarnings("unused")
	private final GatewayProperties gatewayProperties;
    
    private final DiscoveryClient discoveryClient;
    
    @Autowired
    public SwaggerProvider(RouteLocator routeLocator,GatewayProperties gatewayProperties,DiscoveryClient discoveryClient) {
       this.gatewayProperties = gatewayProperties;
 	   this.routeLocator = routeLocator;
 	   this.discoveryClient = discoveryClient;
    }
    
 
    @Override
    public List<SwaggerResource> get() {
    	
        List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
        
        List<String> services = new ArrayList<String>();
        services =  discoveryClient.getServices();
        
        services.stream()
        		.filter(e -> !e.equals(apName.toLowerCase()) && !e.equals("configserver"))
        		.forEach(e -> resources.add(swaggerResource( e, "/"+ e + API_URI)));
//        
//        for(String serverName : services) {
//        	
//        	if(!serverName.equals(apName.toLowerCase()) && !serverName.equals("configserver") ) {
//        		resources.add(swaggerResource(serverName, "/"+serverName + API_URI));
//        	}
//        }
        return resources;
    }
 
    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
