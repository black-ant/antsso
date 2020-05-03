package com.gang.antsso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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



    @GetMapping("test")
    public void test() {
        logger.info("------> this is in test <-------");
    }

}
