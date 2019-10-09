package cn.swallow.loadbalance.service;

import org.springframework.stereotype.Component;

/**
 * @author swallowff
 * @create 2019/10/9
 */
@Component
public class FeignFallbackService implements IFeignService {

    @Override
    public String doTest(String name) {
        return "hi,"+name+",sorry,error! execute feign hystrix";
    }
}
