package cn.swallow.loadbalance.ctrl;

import cn.swallow.loadbalance.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ribbon负载均衡
 * @author swallowff
 * @create 2019/10/9
 */
@RestController
@RequestMapping(value = "/api/ribbon")
public class RibbonCtrl {
    @Autowired
    private RibbonService ribbonService;

    /**
     * ribbon负载均衡,将请求转发至注册的 /api/goodsList 服务
     * @param
     * @return
     */
    @RequestMapping("/goodsList")
    public String goodsList(){
        return ribbonService.goodsList();
    }

}
