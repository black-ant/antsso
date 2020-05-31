package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.to.UserInfo;

/**
 * @Classname IUserConversion
 * @Description TODO
 * @Date 2020/5/31 18:10
 * @Created by zengzg
 */
public interface IUserConversion<S, T extends UserInfo> {

    UserInfo conversion(S source, UserInfo target);

}
