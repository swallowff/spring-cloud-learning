package cn.swallow.cloudlearn.service.goods.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author swallowff
 * @create 2019/10/9
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsCtrl {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "goodsList",method = RequestMethod.GET)
    @ResponseBody
    public String goodsList(){
        return "goodsList service from port:" +port;
    }

    @RequestMapping(value = "hello")
    public String helloGoods(){
        return "/hello-goods";
    }

}
