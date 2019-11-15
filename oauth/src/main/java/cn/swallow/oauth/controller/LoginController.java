package cn.swallow.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shenyu
 * @create 2019/11/14
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String userLogin() {
        return "login";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "login";
    }


}
