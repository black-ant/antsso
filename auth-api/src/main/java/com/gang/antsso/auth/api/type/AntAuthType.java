package com.gang.antsso.auth.api.type;

/**
 * @Classname AuthType
 * @Description TODO
 * @Date 2019/11/21 21:51
 * @Created by zengzg
 */
public enum AntAuthType {

    EASY("EASY"),

    // 数据库校验
    DATABASE("DATABASE"),

    // 数据库校验
    VCODE("VCODE"),

    // OTP 认证
    OTP("OPT"),

    // LDAP 认证
    LDAP("LDAP"),

    // VCODE
    VOCDE("VCODE"),

    // DingDing 认证
    DINGTALK("DINGTALK");

    private String code;

    AntAuthType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
