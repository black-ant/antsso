package com.gang.antsso.config;

import com.gang.antsso.configuration.LoginViewConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginViewConfiguration viewEntity;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


        registry.addViewController("/unauth/hello").setViewName("test");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/tologin").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/before/register").setViewName("register");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/admin2").setViewName("user");

        // 登录跳转
        registry.addViewController("/loginWechat").setViewName("login_wechat");
        registry.addViewController("/loginVcode").setViewName("login_vcode");
        registry.addViewController("/loginDingtalk").setViewName("login_dingtalk");
        registry.addViewController("/loginSaml").setViewName("login_saml");
        if (viewEntity != null && viewEntity.getViewMap() != null) {
            viewEntity.getViewMap().keySet().forEach(item -> {
                logger.info("------> add view :{} --{} <-------", item, viewEntity.getViewMap().get(item));
                registry.addViewController("/" + item).setViewName(viewEntity.getViewMap().get(item));
            });
        }
    }
}

