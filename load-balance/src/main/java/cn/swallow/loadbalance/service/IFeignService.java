package cn.swallow.loadbalance.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-one",fallback = FeignFallbackService.class)
@Service
public interface IFeignService {

    @RequestMapping(value = "/api/doTest",method = RequestMethod.GET)
    String doTest(@RequestParam(value = "name") String name);


}
