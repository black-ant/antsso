package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.to.UserInfo;

/**
 * @Classname AbstractUserLogic
 * @Description TODO
 * @Date 2020/1/26 17:46
 * @Created by zengzg
 */
public interface OAuthUserInfo<T> {

    UserInfo getUserInfo(UserInfoSearch<T> userInfoSearch);
}
