package com.gang.antsso.config.auth;

import com.gang.antsso.logic.OAuthFailureService;
import com.gang.antsso.logic.OAuthUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Classname WebSecurityConfig
 * @Description TODO
 * @Date 2020/1/12 15:24
 * @Created by zengzg
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OAuthUserDetailsService oAuthUserDetailsService;

    @Autowired
    private OAuthFailureService oAuthFailureService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        //该方法用于用户认证，此处添加内存用户，并且指定了权限
        logger.info("------> password :{} <-------", new BCryptPasswordEncoder().encode("123456"));
        auth.userDetailsService(oAuthUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //此方法中进行了请求授权，用来规定对哪些请求进行拦截
        //其中：antMatchers--使用ant风格的路径匹配
        //regexMatchers--使用正则表达式匹配
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .regexMatchers(".*sign.*").permitAll()
                .regexMatchers(".*unauth.*").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/admin2").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()                      //其它请求都需要校验才能访问
                .and()
                .formLogin()
                .failureHandler(oAuthFailureService)
                .loginPage("/login").permitAll()
                .and()
                .logout()                                           //默认的"/logout", 允许访问
                .permitAll();

    }
}
