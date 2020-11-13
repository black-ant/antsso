package com.gang.antsso.config.auth.adapter;

import com.gang.antsso.config.entity.AntSSOWebSecurityConfiguration;
import com.gang.antsso.handle.SsoFailureService;
import com.gang.antsso.handle.SsoLogoutService;
import com.gang.antsso.handle.SsoSuccessService;
import com.gang.common.lib.utils.ReflectionUtils;
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
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.CollectionUtils;

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
    private SsoFailureService oAuthFailureService;

    @Autowired
    private SsoSuccessService oAuthSuccessService;

    @Autowired
    private SsoLogoutService logoutService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AntSSOWebSecurityConfiguration webSecurityConfiguration;

    @Autowired
    private ReflectionUtils reflectionUtils;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        injectWebConfig(auth);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 添加过滤器流程
        injectWebConfig(http);

        //此方法中进行了请求授权，用来规定对哪些请求进行拦截
        //其中：antMatchers--使用ant风格的路径匹配
        //regexMatchers--使用正则表达式匹配
        http.authorizeRequests()
                .regexMatchers(".*before.*").permitAll()
                .regexMatchers(".*login.*").permitAll()
                .regexMatchers(".*swagger.*").permitAll()
                .regexMatchers(".*docs.*").permitAll()
                .regexMatchers(".*sign.*").permitAll()
                .regexMatchers(".*unauth.*").permitAll()
                .antMatchers("/admin2").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()                      //其它请求都需要校验才能访问
                .and()
                // ----> do Login
                .formLogin()
                .loginPage("/login").permitAll()
                .failureHandler(oAuthFailureService)
                .successHandler(oAuthSuccessService)
                .defaultSuccessUrl("/index")
                .and()
                // ----> do Logout
                //默认的"/logout", 允许访问
                .logout()
                .logoutUrl("/logout").logoutSuccessHandler(logoutService)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login ").invalidateHttpSession(true);

    }


    /**
     * 注入 Provide
     *
     * @param auth
     */
    public void injectWebConfig(AuthenticationManagerBuilder auth) {
        if (webSecurityConfiguration != null && !CollectionUtils.isEmpty(webSecurityConfiguration.getSettingList())) {
            webSecurityConfiguration.getSettingList().forEach(item -> {
                auth.authenticationProvider(reflectionUtils.springClassLoad(item.getProvider()));
            });
        }
        logger.info("------> provider 注入完成 <-------");
    }


    /**
     * 注入 Filter
     *
     * @param http
     */
    public void injectWebConfig(HttpSecurity http) {
        if (webSecurityConfiguration != null && !CollectionUtils.isEmpty(webSecurityConfiguration.getSettingList())) {
            webSecurityConfiguration.getSettingList().forEach(item -> {
                AbstractAuthenticationProcessingFilter filter = reflectionUtils.classLoadReflect(item.getFilter());
                filter.setAuthenticationManager(authenticationManager);
                http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class
                );
            });
        }
        logger.info("------> provider 注入完成 <-------");
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

}
