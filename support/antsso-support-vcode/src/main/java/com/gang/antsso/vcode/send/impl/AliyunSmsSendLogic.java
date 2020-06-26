package com.gang.antsso.vcode.send.impl;

import com.gang.antsso.vcode.send.ICodeSend;
import com.gang.antsso.vcode.entity.VCodeAliyunMsgSetting;
import com.gang.common.msg.to.MsgRequestTO;
import org.springframework.stereotype.Component;

/**
 * @Classname AliyunSmsSendLogic
 * @Description TODO
 * @Date 2020/5/2 11:51
 * @Created by zengzg
 */
@Component
public class AliyunSmsSendLogic implements ICodeSend<VCodeAliyunMsgSetting> {

    @Override
    public String send(MsgRequestTO msgRequestTO) {
        return null;
    }
}
