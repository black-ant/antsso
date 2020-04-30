package com.gang.antsso.vcode;

import com.gang.common.msg.email.to.EmailSendSetting;
import com.gang.common.msgapi.IMsgSetting;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname VCodeMsgSetting
 * @Description TODO
 * @Date 2020/3/14 20:38
 * @Created by zengzg
 */
@Component//perosn 需要纳入spring ioc 容器里
@ConfigurationProperties(prefix = "com.gang.antsso.msg.email")
@Data
public class VCodeMsgSetting {

    private String account;

    private String password;

    private String protocol;

    private String host;

    private String port;

    private String auth;

    private boolean enable;

    private int time;


    public EmailSendSetting buidlEmailSetting() {
        EmailSendSetting emailSendSetting = new EmailSendSetting();
        BeanUtils.copyProperties(this, emailSendSetting);
        return emailSendSetting;

    }

}
