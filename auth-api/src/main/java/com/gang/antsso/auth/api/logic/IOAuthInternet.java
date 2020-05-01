package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.to.InternetRequestTO;
import com.gang.antsso.auth.api.to.InternetResponseTO;

/**
 * @Classname OAuthInternet
 * @Description TODO
 * @Date 2020/4/30 22:22
 * @Created by zengzg
 */
public interface IOAuthInternet {

    InternetResponseTO execute(InternetRequestTO request);
}
