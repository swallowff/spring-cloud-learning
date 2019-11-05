package cn.swallow.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenyu
 * @create 2019/11/6
 */
@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator customRouteLocator(ConfigurableApplicationContext configurableApplicationContext) {
//        RouteLocatorBuilder builder = new RouteLocatorBuilder(configurableApplicationContext);
//        return builder.routes().route(r -> r.path("/test/custom").uri("http://ww.baidu.com"))
//                .route(r -> r.path("/goods/**").uri("lb://service-goods"))
//                .build();
//
//    }
}
