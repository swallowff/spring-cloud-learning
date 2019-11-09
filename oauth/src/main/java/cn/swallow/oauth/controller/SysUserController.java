package cn.swallow.oauth.controller;

import cn.swallow.oauth.model.SysUser;
import cn.swallow.oauth.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shenyu
 * @create 2019/11/7
 */
@Controller
@RequestMapping(value = "/user")
public class SysUserController {
    Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService userInfoService;

    @RequestMapping("add")
    @ResponseBody
    public String addUser(SysUser userInfo){
        userInfo = userInfoService.save(userInfo);
        if (userInfo.getId()!=null){
            return "success";
        }else {
            return "failed";
        }
    }

    @GetMapping("/web")
    @ResponseBody
    public String web(){
        return  "hello web";
    }

    @GetMapping("/android")
    @ResponseBody
    public String android(){
        return  "hello android";
    }



}
