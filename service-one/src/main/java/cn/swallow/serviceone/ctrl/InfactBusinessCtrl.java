package cn.swallow.serviceone.ctrl;

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
public class InfactBusinessCtrl {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/doTest",method = RequestMethod.GET)
    public String doTest(@RequestParam String name){
        return "hi "+name+",i am from port:" +port;
    }

}
