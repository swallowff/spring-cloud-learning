package cn.swallow.oauth.common.security;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @Description 可用于自定义加载client 使用方法参考UserDetailsService
 * @author shenyu
 * @create 2019/11/9
 */
public class ClientDetailServiceImpl implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        //自定义从数据库中加载client
        return null;
    }
}
