package cn.swallow.cloudlearn.loadbalance.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-goods",fallback = FeignFallbackService.class)
@Service
public interface IFeignService {

    @RequestMapping(value = "/api/goodsList",method = RequestMethod.GET)
    String goodsList();


}
