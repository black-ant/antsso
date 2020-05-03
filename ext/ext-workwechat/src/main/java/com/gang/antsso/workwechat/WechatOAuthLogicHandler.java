package com.gang.antsso.workwechat;

import com.gang.antsso.auth.api.logic.IOAuthUserInfoHandler;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.to.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @Classname WechatOAuthLogicHandler
 * @Description TODO
 * @Date 2020/1/27 17:20
 * @Created by zengzg
 */
@Component
public class WechatOAuthLogicHandler implements IOAuthUserInfoHandler {

    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO userInfoSearchTO) {
        return null;
    }

    @Override
    public UserInfo checkUserInfo(UserInfoSearchTO userInfoSearchTO) {
        return null;
    }
}
