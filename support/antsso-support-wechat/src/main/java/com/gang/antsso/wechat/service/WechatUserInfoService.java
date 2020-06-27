package com.gang.antsso.wechat.service;

import com.gang.antsso.auth.api.logic.IOAuthUserInfoHandler;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import org.springframework.stereotype.Component;

/**
 * @Classname DingTalkUserInfoService
 * @Description TODO
 * @Date 2020/6/26 18:05
 * @Created by zengzg
 */
@Component
public class WechatUserInfoService implements IOAuthUserInfoHandler<String> {


    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        return null;
    }

    @Override
    public UserInfo checkUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        return null;
    }
}
