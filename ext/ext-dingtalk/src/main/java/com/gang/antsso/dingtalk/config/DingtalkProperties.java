package com.gang.antsso.dingtalk.config;

/**
 * @Classname DingtalkProperties
 * @Description TODO
 * @Date 2020/4/30 23:08
 * @Created by zengzg
 */
public final class DingtalkProperties {

    private DingtalkProperties() {
    }

    public static final String GET_TOKEN = " https://oapi.dingtalk.com/sso/gettoken?corpid=${corpid&corpsecret=$" +
            "{corpsecret}";


    /**
     * 二维码登录获取用户信息
     */
    public static final String RQCODE_URL = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?"
            + "accessKey=${AppId}"
            + "&timestamp=${Timestamp}"
            + "&signature=${Signature}";
}
