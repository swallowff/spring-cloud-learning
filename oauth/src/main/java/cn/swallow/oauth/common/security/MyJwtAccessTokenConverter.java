package cn.swallow.oauth.common.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;

/**
 * @author shenyu
 * @create 2019/11/13
 */
public class MyJwtAccessTokenConverter extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        if (accessToken instanceof DefaultOAuth2AccessToken) {
            //((DefaultOAuth2AccessToken) accessToken).setRefreshToken();
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserInfo) {
                UserInfo user = (UserInfo) principal;
                HashMap<String, Object> map = new HashMap<>();
                map.put("user_id", user.getId());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
            }
        }
        return super.enhance(accessToken, authentication);
    }
}
