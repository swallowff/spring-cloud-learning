package cn.swallow.servicetwo.ctrl;

import cn.swallow.servicetwo.service.RibbonService;
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
     * ribbon负载均衡,将请求转发至注册的/doTest接口
     * @param name
     * @return
     */
    @RequestMapping("/testRibbon")
    public String testRibbon(@RequestParam String name){
        return ribbonService.doTest(name);
    }

}
