package com.gang.antsso.workwechat;

import com.gang.antsso.auth.api.entity.InternetRequest;
import com.gang.antsso.auth.api.entity.InternetResponse;
import com.gang.antsso.auth.api.logic.IOAuthInternet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Classname WechatInternetLogic
 * @Description TODO
 * @Date 2020/4/30 23:02
 * @Created by zengzg
 */
@Component
public class WechatInternetLogic implements IOAuthInternet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public InternetResponse execute(InternetRequest request) {
        return null;
    }
}
