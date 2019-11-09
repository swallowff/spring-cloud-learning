package cn.swallow.oauth.controller;

import cn.swallow.oauth.common.util.IdGenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shenyu
 * @create 2019/11/9
 */
@Controller
@RequestMapping(value = "client")
public class ClientController {
    @Autowired
    private ClientDetailsService clientDetailsService;

    @PostMapping("add")
    @ResponseBody
    public String addClient(BaseClientDetails clientDetails){
        JdbcClientDetailsService detailsService = (JdbcClientDetailsService) clientDetailsService;
        clientDetails.setClientId(IdGenUtil.uuid());
        detailsService.addClientDetails(clientDetails);
        return "success";
    }
}
