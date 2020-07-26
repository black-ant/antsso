package com.gang.antsso.wechat.config;

/**
 * @Classname DingtalkProperties
 * @Description TODO
 * @Date 2020/4/30 23:08
 * @Created by zengzg
 */
public final class WechatProperties {

    private WechatProperties() {
    }

    public static final String GET_TOKEN = "https://oapi.dingtalk.com/sso/gettoken?corpid=${corpid}&corpsecret=${corpsecret}";
    public static final String GET_OAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize" +
            "?appid=${appid}&redirect_uri=${redirect_uri}&response_type=code&scope=${scope}&state=${state}#wechat_redirect";
    public static final String GET_OAUTH_URL_CODE = "https://open.work.weixin.qq.com/wwopen/sso/3rd_qrConnect?" +
            "?appid=${appid}&redirect_uri=${redirect_uri}&state=&usertype=${usertype}";
    /**
     * 二维码登录获取用户信息
     */
    public static final String RQCODE_URL = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?"
            + "accessKey=${AppId}"
            + "&timestamp=${Timestamp}"
            + "&signature=${Signature}";


}
