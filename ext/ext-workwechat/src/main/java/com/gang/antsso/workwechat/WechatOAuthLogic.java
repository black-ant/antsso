package com.gang.antsso.workwechat;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.logic.IOAuthUserInfo;
import com.gang.antsso.auth.api.to.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @Classname WechatOAuthLogic
 * @Description TODO
 * @Date 2020/1/27 17:20
 * @Created by zengzg
 */
@Component
public class WechatOAuthLogic implements IOAuthUserInfo {

    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO userInfoSearchTO) {
        return null;
    }
}
