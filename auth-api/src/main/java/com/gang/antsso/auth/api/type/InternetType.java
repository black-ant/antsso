package com.gang.antsso.auth.api.type;

/**
 * @Classname InternetType
 * @Description TODO
 * @Date 2020/4/30 22:49
 * @Created by zengzg
 */
public enum InternetType {

    RQ_CODE,

    USERNAMEPASSWORD,

    /**
     * 短信验证码
     */
    SMS_CODE,

    /**
     * 钉钉验证码消息
     */
    DING_CODE,

    /**
     * 邮件验证码
     */
    EMAIL_CODE;
}
