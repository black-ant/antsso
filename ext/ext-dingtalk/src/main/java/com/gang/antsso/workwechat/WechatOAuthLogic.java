package com.gang.antsso.workwechat;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.auth.api.to.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @Classname WechatOAuthLogic
 * @Description TODO
 * @Date 2020/1/27 17:20
 * @Created by zengzg
 */
@Component
public class DingTalkOAuthLogic implements OAuthUserInfo {

    @Override
    public UserInfo getUserInfo(UserInfoSearch userInfoSearch) {
        return null;
    }
}
