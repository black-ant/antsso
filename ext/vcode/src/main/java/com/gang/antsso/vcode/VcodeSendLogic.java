package com.gang.antsso.vcode;

import com.gang.common.cache.logic.RedisCache;
import com.gang.common.msg.email.to.EmailSendContent;
import com.gang.common.msgapi.logic.MsgConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Classname VcodeSendLogic
 * @Description TODO
 * @Date 2020/3/14 20:20
 * @Created by zengzg
 */
@Component
public class VcodeSendLogic {

    @Autowired
    private MsgConnect msgConnect;

    @Autowired
    private VCodeMsgSetting setting;

    @Autowired
    private RedisCache redisCache;

    public Boolean sendVCode(String receiver) {

        String code = getMsgCode(4);

        EmailSendContent emailSendContent = new EmailSendContent();
        emailSendContent.setContent(code);
        emailSendContent.setReceiverList(receiver);

        msgConnect.build(setting.buidlEmailSetting()).send(emailSendContent);

        redisCache.set(receiver, code);
        return Boolean.TRUE;
    }


    public static String getMsgCode(int len) {
        int digit = (int) Math.pow(10.0D, (double) (len - 1));
        int rs = (new Random()).nextInt(digit * 10);
        if (rs < digit) {
            rs += digit;
        }

        return String.valueOf(rs);
    }


}
