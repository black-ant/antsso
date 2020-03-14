package com.gang.antsso.controller;

import com.gang.antsso.vcode.VcodeSendLogic;
import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SsoAuthBefore
 * @Description TODO
 * @Date 2020/3/14 21:40
 * @Created by zengzg
 */
@RestController
@RequestMapping("/before")
public class SsoAuthBefore {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private VcodeSendLogic vcodeSendLogic;

    @GetMapping("test")
    public void test() {
        logger.info("------> this is in test <-------");
    }

    @GetMapping("vcodesend/{receiver}")
    public ResponseModel<Boolean> sendVCode(@PathVariable("receiver") String receiver) {
        return ResponseModel.commonResponse(vcodeSendLogic.sendVCode(receiver));
    }
}
