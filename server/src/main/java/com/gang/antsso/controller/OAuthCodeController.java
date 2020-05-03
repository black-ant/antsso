package com.gang.antsso.controller;

import com.gang.antsso.auth.api.to.InternetRequestTO;
import com.gang.antsso.auth.api.type.InternetType;
import com.gang.antsso.vcode.service.MsgCommonLogic;
import com.gang.common.lib.to.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OAuthCodeController
 * @Description TODO
 * @Date 2020/5/2 22:37
 * @Created by zengzg
 */
@RestController
@RequestMapping("/code")
public class OAuthCodeController {


    @Autowired
    private MsgCommonLogic sendLogic;

    @GetMapping("/unauth/send/{type}/{receiver}")
    public ResponseModel<String> sendVCode(@PathVariable("type") String type,
                                           @PathVariable("receiver") String receiver) {

        InternetRequestTO requestTO = new InternetRequestTO();
        requestTO.setType(InternetType.EMAIL_CODE);
        requestTO.addParam("username", receiver);
        return ResponseModel.commonResponse(sendLogic.send(requestTO));
    }
}
