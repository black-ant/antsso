package com.gang.antsso.support.entity;

import org.springframework.stereotype.Component;

/**
 * @Classname VCodeMsgSetting
 * @Description 容联云通信配置类
 * @Date 2020/3/14 20:38
 * @Created by zengzg
 */
@Component
public class VCodeRongYunSmsMsgSetting implements ISSOMsgSetting {

    private String account;

    private String password;

    private String protocol;

    private String host;

    private String port;

    private String auth;

    private boolean enable;

    private int time;

    //    public EmailSendSetting buidlEmailSetting() {
    //        EmailSendSetting emailSendSetting = new EmailSendSetting();
    //        BeanUtils.copyProperties(this, emailSendSetting);
    //        return emailSendSetting;
    //
    //    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
