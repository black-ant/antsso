package com.gang.antsso.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.wechat.config.WechatProperties;
import com.gang.common.lib.to.ResponseModel;
import com.gang.common.lib.utils.TemplateResolve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WechatOAuthController
 * @Description TODO
 * @Date 2020/6/27 13:42
 * @Created by zengzg
 */
@RestController
@RequestMapping("wechat")
public class WechatOAuthController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("unauth/url")
    public ResponseModel<String> getRequestUrl() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("appid", "ww72f872df46c2b36f");
        paramMap.put("redirect_uri", "http://127.0.0.1:8089/sso/wechat/backAuth");
        paramMap.put("scope", "snsapi_userinfo");
        paramMap.put("state", "test");

        String oauthUrl = TemplateResolve.resolveByMap(WechatProperties.GET_OAUTH_URL, paramMap);
        return ResponseModel.commonResponse(oauthUrl);
    }

    @GetMapping("unauth/urlCode")
    public ResponseModel<String> getRequesurlCode() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("appid", "ww72f872df46c2b36f");
        paramMap.put("redirect_uri", "http://127.0.0.1:8089/sso/wechat/bacAuthkCode");
        paramMap.put("usertype", "usertype");
        paramMap.put("state", "test");

        String oauthUrl = TemplateResolve.resolveByMap(WechatProperties.GET_OAUTH_URL_CODE, paramMap);
        return ResponseModel.commonResponse(oauthUrl);
    }

    @GetMapping("backAuth")
    public ResponseModel<JSONObject> backAuth(@RequestParam("code") String code, @RequestParam("state") String state) {
        logger.info("------> code is  :{} state is {} <-------", code, state);
        return ResponseModel.commonResponse(null);
    }

    @GetMapping("bacAuthkCode")
    public ResponseModel<JSONObject> backAuthCode(@RequestParam("auth_code") String code) {
        logger.info("------> code is  :{} <-------", code);
        return ResponseModel.commonResponse(null);
    }


}
