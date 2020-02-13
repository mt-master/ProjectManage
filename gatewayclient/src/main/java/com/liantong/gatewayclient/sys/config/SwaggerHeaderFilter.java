package com.liantong.gatewayclient.sys.config;//package gateway.sys.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter; 
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory; 
//import org.springframework.http.server.reactive.ServerHttpRequest; 
//import org.springframework.util.StringUtils; 
//import org.springframework.web.server.ServerWebExchange;
//
//@SuppressWarnings("rawtypes") 
//
//public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {
//	private static final String API_URI = "/v2/api-docs";
//    private static final String HEADER_NAME = "X-Forwarded-Prefix";
// 
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            String path = request.getURI().getPath();
//            if (!StringUtils.endsWithIgnoreCase(path, API_URI)) {
//                return chain.filter(exchange);
//            }
//            String basePath = path.substring(0, path.lastIndexOf(API_URI));
//            @SuppressWarnings("deprecation")
//			ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
//            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
//            return chain.filter(newExchange);
//        };
//    }
//}
