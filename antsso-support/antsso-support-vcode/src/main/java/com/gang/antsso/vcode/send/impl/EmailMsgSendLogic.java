package com.gang.antsso.vcode.send.impl;

import com.gang.antsso.vcode.send.ICodeSend;
import com.gang.antsso.vcode.entity.VCodeAliyunMsgSetting;
import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msg.logic.MsgConnect;
import com.gang.common.msg.to.MsgRequestTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname EmailMsgSendLogic
 * @Description TODO
 * @Date 2020/5/2 11:54
 * @Created by zengzg
 */
@Component
public class EmailMsgSendLogic implements ICodeSend<VCodeAliyunMsgSetting> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MsgConnect msgConnect;

    @Override
    public String send(MsgRequestTO msgRequestTO) {
        try {
            ResponseModel back = msgConnect.getInstance(msgRequestTO.getSettingTO()).sendMsg(msgRequestTO);
            return "success";
        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass(), e.getMessage());
        }
        return "";
    }
}
