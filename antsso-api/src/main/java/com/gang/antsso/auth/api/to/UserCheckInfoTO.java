package com.gang.antsso.auth.api.to;

import lombok.Data;

import java.util.Map;

/**
 * @Classname UserCheckInfoTO
 * @Description 账号密码/验证码校验TO
 * @Date 2020/5/2 10:49
 * @Created by zengzg
 */
@Data
public class UserCheckInfoTO {


    private String type;

    /**
     * 校验值 : salt / Username
     */
    private String saltCode;

    /**
     * 密码值 : Password / Code
     */
    private String cipherCode;

    private Map<String, String> extMap;


    public UserCheckInfoTO(String saltCode, String cipherCode) {
        this.saltCode = saltCode;
        this.cipherCode = cipherCode;
    }


}
