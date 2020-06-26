package com.gang.antsso.controller;

import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SDKAuthController
 * @Description TODO
 * @Date 2020/2/23 14:12
 * @Created by zengzg
 */
@RestController("/sdk")
public class SDKAuthController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("auth")
    public ResponseModel<String> auth() {
        logger.info("------> this is in auth <-------");
        return ResponseModel.commonResponse("isok");
    }
}
