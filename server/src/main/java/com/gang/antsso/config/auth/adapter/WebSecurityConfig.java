package com.gang.antsso.config.auth.adapter;

import com.gang.antsso.filter.AntQRCodeAuthenticationFilter;
import com.gang.antsso.filter.AntUsernamePasswordAuthenticationFilter;
import com.gang.antsso.filter.AntVCodeAuthenticationFilter;
import com.gang.antsso.logic.auth.manager.OAuthFailureService;
import com.gang.antsso.logic.auth.OAuthUserDetailsService;
import com.gang.antsso.logic.auth.manager.OAuthSuccessService;
import com.gang.antsso.logic.auth.provide.OAuthQRCodeAuthenticationProvide;
import com.gang.antsso.logic.auth.provide.OAuthUsernamePasswordAuthenticationProvide;
import com.gang.antsso.logic.auth.provide.OAuthVCodeAuthenticationProvide;
import com.gang.antsso.support.filter.DatabaseAuthenticationFilter;
import com.gang.antsso.support.provider.DatabaseAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Autowired
    private OAuthSuccessService oAuthSuccessService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .authenticationProvider(oAuthQRCodeAuthenticationProvider())
                .authenticationProvider(usernamePasswordAuthenticationProvider())
                .authenticationProvider(oAuthVCodeAuthenticationProvider())
                .authenticationProvider(getDatabaseAuthenticationProvider());


        //        //该方法用于用户认证，此处添加内存用户，并且指定了权限
        //        logger.info("------> password :{} <-------", new BCryptPasswordEncoder().encode("123456"));
        auth.userDetailsService(oAuthUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 添加过滤器流程
        http.addFilterBefore(usernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(oAuthVCodeAuthenticationFilter(), AntUsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(getDatabaseAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        //此方法中进行了请求授权，用来规定对哪些请求进行拦截
        //其中：antMatchers--使用ant风格的路径匹配
        //regexMatchers--使用正则表达式匹配
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .regexMatchers(".*before.*").permitAll()
                .regexMatchers(".*login.*").permitAll()
                .regexMatchers(".*swagger.*").permitAll()
                .regexMatchers(".*docs.*").permitAll()
                .regexMatchers(".*sign.*").permitAll()
                .regexMatchers(".*unauth.*").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/admin2").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()                      //其它请求都需要校验才能访问
                .and()
                .formLogin()
                .failureHandler(oAuthFailureService)
                .successHandler(oAuthSuccessService)
                .defaultSuccessUrl("/index")
                .loginPage("/login").permitAll()
                .and()
                .logout()                                           //默认的"/logout", 允许访问
                .permitAll();

    }

    /**
     * 设置不拦截
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**",
                "/images/**", "/img/**", "/druid/**", "/fonts/**",
                "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg",
                "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg");
    }


    @Bean
    public OAuthQRCodeAuthenticationProvide oAuthQRCodeAuthenticationProvider() {
        return new OAuthQRCodeAuthenticationProvide();
    }

    @Bean
    public OAuthUsernamePasswordAuthenticationProvide usernamePasswordAuthenticationProvider() {
        return new OAuthUsernamePasswordAuthenticationProvide();
    }

    @Bean
    public OAuthVCodeAuthenticationProvide oAuthVCodeAuthenticationProvider() {
        return new OAuthVCodeAuthenticationProvide();
    }

    @Bean
    public DatabaseAuthenticationProvider getDatabaseAuthenticationProvider() {
        return new DatabaseAuthenticationProvider();
    }

    @Bean
    public AntQRCodeAuthenticationFilter oAuthQRCodeAuthenticationFilter() {
        AntQRCodeAuthenticationFilter filter = new AntQRCodeAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

    @Bean
    public DatabaseAuthenticationFilter getDatabaseAuthenticationFilter() {
        DatabaseAuthenticationFilter filter = new DatabaseAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

    @Bean
    public AntUsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() {
        AntUsernamePasswordAuthenticationFilter filter = new AntUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

    @Bean
    public AntVCodeAuthenticationFilter oAuthVCodeAuthenticationFilter() {
        AntVCodeAuthenticationFilter filter = new AntVCodeAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }


}
