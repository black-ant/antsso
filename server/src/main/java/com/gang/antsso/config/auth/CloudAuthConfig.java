package com.gang.antsso.config.auth;

import com.gang.antsso.logic.OAuthClientDetailsService;
import com.gang.antsso.logic.OAuthUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * @Classname CloudAuthConfig
 * @Description TODO
 * @Date 2020/2/23 17:51
 * @Created by zengzg
 */
@Configuration
@EnableAuthorizationServer
public class CloudAuthConfig extends AuthorizationServerConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private OAuthUserDetailsService userService;

    @Autowired
    private OAuthClientDetailsService clientDetailsService;

    /**
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        logger.info("------> this is create CloudAuthConfig  configure<-------");
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        logger.info("------> this is create CloudAuthConfig  ClientDetailsServiceConfigurer<-------");
        clients.withClientDetails(clientDetailsService);

    }
}
