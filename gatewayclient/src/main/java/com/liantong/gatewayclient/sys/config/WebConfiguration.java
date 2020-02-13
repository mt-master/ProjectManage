package com.liantong.gatewayclient.sys.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
 
import java.net.InetSocketAddress;
import java.util.Objects;
 
/*
If you want to keep Spring Boot WebFlux features and you want to add additional WebFlux configuration, you can add your own @Configuration class of type WebFluxConfigurer but without @EnableWebFlux.
If you want to take complete control of Spring WebFlux, you can add your own @Configuration annotated with @EnableWebFlux.
 */
@Configuration
public class WebConfiguration implements WebFluxConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTION")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true)
                .maxAge(3600);
    }
 
    /**
     * https://stackoverflow.com/questions/51192630/how-do-you-get-clients-ip-address-spring-webflux-websocket?rq=1
     * https://stackoverflow.com/questions/50981136/how-to-get-client-ip-in-webflux
     * https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-filters
     * 由于在低版本的 spring-webflux 中不支持直接获得请求 IP（https://jira.spring.io/browse/SPR-16681），因此写了一个补丁曲线救国，
     * 从 org.springframework.web.server.ServerWebExchange 中获得 IP 后，在放到 header 里
     */
    @Component
    public static class RetrieveClientIpWebFilter implements WebFilter {
 
        @SuppressWarnings("deprecation")
		@Override
        public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
            InetSocketAddress remoteAddress = exchange.getRequest().getRemoteAddress();
            String clientIp = Objects.requireNonNull(remoteAddress).getAddress().getHostAddress();
            ServerHttpRequest mutatedServerHttpRequest = exchange.getRequest().mutate().header("X-CLIENT-IP", clientIp).build();
            ServerWebExchange mutatedServerWebExchange = exchange.mutate().request(mutatedServerHttpRequest).build();
            return chain.filter(mutatedServerWebExchange);
        }
    }
}
