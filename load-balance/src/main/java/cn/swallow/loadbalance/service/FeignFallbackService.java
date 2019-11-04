package cn.swallow.loadbalance.service;

import org.springframework.stereotype.Component;

/**
 * @author swallowff
 * @create 2019/10/9
 */
@Component
public class FeignFallbackService implements IFeignService {

    @Override
    public String goodsList() {
        return "Feign hystrix error ! Service-goods is um-useful now ! Please try again later";
    }
}
