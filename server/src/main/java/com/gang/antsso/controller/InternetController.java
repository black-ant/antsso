package com.gang.antsso.controller;

import com.gang.antsso.logic.OAuthSettingService;
import com.gang.common.lib.to.ResponseModel;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname InternetController
 * @Description TODO
 * @Date 2020/5/1 12:19
 * @Created by zengzg
 */
@RestController
@RequestMapping("/internet")
public class InternetController {

    @Autowired
    protected OAuthSettingService oAuthSettingService;
}
