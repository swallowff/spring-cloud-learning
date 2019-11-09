package cn.swallow.oauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author shenyu
 * @create 2019/11/9
 */
@Controller
@RequestMapping(value = "users")
public class UsersController {
    Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public Principal getUser(Principal principal) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(principal.toString());
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        return principal;
    }
}
