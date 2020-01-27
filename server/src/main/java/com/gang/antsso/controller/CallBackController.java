package com.gang.antsso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname CallBackController
 * @Description TODO
 * @Date 2020/1/27 20:29
 * @Created by zengzg
 */
@RequestMapping("/callback")
@RestController
public class CallBackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("info")
    public void info() {
        logger.info("------> this is in info <-------");
    }
}
