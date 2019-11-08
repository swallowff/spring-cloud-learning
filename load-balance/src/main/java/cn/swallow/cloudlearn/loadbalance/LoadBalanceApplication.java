package cn.swallow.cloudlearn.loadbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients     //开启feign负载均衡
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix          //开启ribbon断路器
public class LoadBalanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);
    }

}
