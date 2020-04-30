package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.entity.InternetRequest;
import com.gang.antsso.auth.api.entity.InternetResponse;
import com.gang.common.lib.to.ResponseModel;

/**
 * @Classname OAuthInternet
 * @Description TODO
 * @Date 2020/4/30 22:22
 * @Created by zengzg
 */
public interface IOAuthInternet {

    public InternetResponse execute(InternetRequest request);
}
