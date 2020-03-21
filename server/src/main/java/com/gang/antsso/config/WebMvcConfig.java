package com.gang.antsso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname MyMvcConfig
 * @Description TODO
 * @Date 2020/1/12 19:02
 * @Created by zengzg
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        //        registry.addViewController("/page/setting").setViewName("setting");
        //        registry.addViewController("/page/type").setViewName("type");
        //        registry.addViewController("/page/client").setViewName("client");
        //        registry.addViewController("/page/list/client").setViewName("clientlist");
        //        registry.addViewController("/page/list/user").setViewName("userlist");
        //        registry.addViewController("/page/list/type").setViewName("typelist");
        //        registry.addViewController("/page/list/setting").setViewName("settinglist");
        registry.addViewController("/tologin").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/before/register").setViewName("register");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/admin2").setViewName("user");
    }
}

