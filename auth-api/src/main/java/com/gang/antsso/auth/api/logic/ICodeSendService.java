package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.to.InternetRequestTO;

/**
 * @Classname ICodeSendService
 * @Description TODO
 * @Date 2020/5/2 11:57
 * @Created by zengzg
 */
public interface ICodeSendService {

    String send(InternetRequestTO requestTO);
}
