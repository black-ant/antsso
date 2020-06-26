package com.gang.antsso.controller;

import com.gang.antsso.auth.api.to.AuthInfo;
import com.gang.antsso.auth.api.to.UserInfo;

/**
 * @Classname AbstractAuthHandle
 * @Description TODO
 * @Date 2019/11/21 22:24
 * @Created by zengzg
 */
public abstract class AbstractAuthHandle {

    public abstract UserInfo doAuth(AuthInfo authInfo);
}
