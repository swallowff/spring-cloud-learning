package cn.swallow.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

/**
 * @author shenyu
 * @create 2019/11/8
 */
@Configuration
public class PasswordEncoderConfig {
    // 加密方式 security2.0以后 密码无法明文保存，必须要经过加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8,new SecureRandom());
    }
}
