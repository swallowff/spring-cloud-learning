package cn.swallow.cloudlearn.service.goods.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swallowff
 * @create 2019/10/9
 */
@RestController
@RequestMapping(value = "/api")
public class GoodsCtrl {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/goodsList",method = RequestMethod.GET)
    public String goodsList(){
        return "goodsList service from port:" +port;
    }

}