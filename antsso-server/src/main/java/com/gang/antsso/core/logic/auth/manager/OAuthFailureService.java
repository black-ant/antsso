package com.gang.antsso.core.logic.auth.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname OAuthFailureService
 * @Description TODO
 * @Date 2020/1/26 23:13
 * @Created by zengzg
 */
@Component
public class OAuthFailureService implements AuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        logger.error("E----> onAuthenticationFailure :{} -- content :{}",
                exception.getClass() + exception.getMessage());
    }
}
