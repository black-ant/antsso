package com.gang.antsso.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.error.AntSsoException;
import com.gang.antsso.wechat.config.WechatProperties;
import com.gang.common.lib.utils.TemplateResolve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DingTalkService
 * @Description TODO
 * @Date 2020/6/26 21:01
 * @Created by zengzg
 */
@Component
public class WechatService {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 请求 Token
     *
     * @param corpid
     * @param corpsecret
     * @return
     */
    public String requestToken(String corpid, String corpsecret) {

        Map<String, Object> map = new HashMap<>();
        map.put("corpid", corpid);
        map.put("corpsecret", corpsecret);

        String requestUrl = TemplateResolve.resolveByMap(WechatProperties.GET_TOKEN, map);
        JSONObject response = restTemplate.getForObject(requestUrl, JSONObject.class);
        if (!response.isEmpty()) {
            return response.getString("");
        } else {
            throw new AntSsoException("DingTalk get Token error");
        }
    }

}
