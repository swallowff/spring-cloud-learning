package cn.swallow.loadbalance.ctrl;

import cn.swallow.loadbalance.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign负载均衡
 * @author swallowff
 * @create 2019/10/9
 */
@RestController
@RequestMapping(value = "/api/feign")
public class FeignCtrl {
    @Autowired
    private IFeignService feignService;

    @RequestMapping(value = "testFeign")
    public String testFeign(@RequestParam String name){
        return feignService.doTest(name);
    }

}
