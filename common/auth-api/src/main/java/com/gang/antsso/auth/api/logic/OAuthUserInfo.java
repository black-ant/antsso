package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.lib.to.UserInfo;

/**
 * @Classname AbstractUserLogic
 * @Description TODO
 * @Date 2020/1/26 17:46
 * @Created by zengzg
 */
public interface OAuthUserInfo {

    UserInfo getUserInfo(UserInfoSearch userInfoSearch);
}
