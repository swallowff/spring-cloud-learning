package cn.swallow.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author shenyu
 * @create 2019/11/7
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;  //注入我们自己的AuthenticationProvider

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHander;

    // 用户验证服务
    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    // 用户信息保存在内存中(测试用)
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String finalPassword = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user_1").password(finalPassword).authorities("USER").build());
//        manager.createUser(User.withUsername("user_2").password(finalPassword).authorities("USER").build());
//        return manager;
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }



    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/client/**")
//                .antMatchers("/login")
//                .antMatchers("/oauth/**");

    }


    // 配置拦截规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //传统security登录拦截规则配置
//        http.authorizeRequests()
//                .antMatchers("/oauth/**").permitAll()
////                .antMatchers("/user/**").hasRole("admin")//表示/user资源需要有ADMIN这个角色才能访问
//                .antMatchers("/user/**").permitAll()
//                .anyRequest().authenticated()
//                .anyRequest().access("@rbacService.hasPermission(request,authentication)")
////                .and().formLogin().loginPage("/auth/login.html").loginProcessingUrl("/auth/login")  //loginProcessingUrl为提交登录的接口
//                .and().formLogin()
//                .successHandler(myAuthenticationSuccessHandler)
//                .failureHandler(myAuthenticationFailHander)
//                .and().csrf().disable()
//                .httpBasic();

        //oauth2.0拦截规则配置
        http
                .formLogin().loginPage("/login").loginProcessingUrl("/login/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailHander)
                .permitAll() //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and()
                .authorizeRequests()
                .antMatchers("/index").permitAll() //这就表示 /index这个页面不需要权限认证，所有人都可以访问
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

//                .antMatchers("/client/**").hasRole("admin")
//                .antMatchers("/user/**").hasRole("role_a")
//                .antMatchers("/oauth/**").permitAll()
//                .and().csrf().disable().httpBasic();
    }


}
