package cn.swallow.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shenyu
 * @create 2019/11/8
 */
@Controller
@RequestMapping(value = "/auth")
public class SysAuthController {

    @RequestMapping("login.html")
    public String login(){
        return "/login";
    }


}
