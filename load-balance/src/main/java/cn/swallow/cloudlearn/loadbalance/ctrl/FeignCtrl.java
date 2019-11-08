package cn.swallow.cloudlearn.loadbalance.ctrl;

import cn.swallow.cloudlearn.loadbalance.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "goodsList")
    public String goodsList(){
        return feignService.goodsList();
    }

}
