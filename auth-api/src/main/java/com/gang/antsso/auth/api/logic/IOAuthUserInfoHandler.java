package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.to.UserInfo;

/**
 * @Classname AbstractUserLogic
 * @Description TODO
 * @Date 2020/1/26 17:46
 * @Created by zengzg
 */
public interface IOAuthUserInfoHandler<T> {

    UserInfo searchUserInfo(UserInfoSearchTO<T> userInfoSearchTO);

    UserInfo checkUserInfo(UserInfoSearchTO<T> userInfoSearchTO);

}
