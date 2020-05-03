package com.gang.antsso.vcode.service;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.logic.ICodeSendService;
import com.gang.antsso.auth.api.to.InternetRequestTO;
import com.gang.antsso.vcode.entity.VCodeEmailMsgSetting;
import com.gang.antsso.vcode.service.send.AliyunSmsSendLogic;
import com.gang.antsso.vcode.service.send.EmailMsgSendLogic;
import com.gang.antsso.vcode.service.send.RongYunSmsSendServie;
import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.email.to.EmailSendContent;
import com.gang.common.msg.to.IMsgContent;
import com.gang.common.msg.to.MsgRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname MsgCommonLogic
 * @Description TODO
 * @Date 2020/5/2 12:00
 * @Created by zengzg
 */
@Component
public class MsgCommonLogic implements ICodeSendService {

    @Autowired
    private EmailMsgSendLogic emailMsgSendLogic;

    @Autowired
    private AliyunSmsSendLogic aliyunSmsSendLogic;

    @Autowired
    private RongYunSmsSendServie rongYunSmsSendServie;

    @Autowired
    private VcodeCacheLogic cacheLogic;

    @Override
    public String send(InternetRequestTO requestTO) {


        String code = cacheLogic.saveCode(
                requestTO.backStringParams("username"), "");


        switch (requestTO.getType()) {
            case EMAIL_CODE:
                sendEmail(requestTO, code);
                break;
            case SMS_CODE:
                sendSms(requestTO, code);
        }
        return "";

    }

    public String sendSms(InternetRequestTO requestTO, String code) {
        return "";
    }

    public String sendEmail(InternetRequestTO requestTO, String code) {
        MsgRequestTO msgRequestTO = new MsgRequestTO();
        //        msgRequestTO.setMsgSetting(requestTO.getoAuthExtSettingTO().getSettingBody());


        String info = "{\"password\":\"fuhlgvhjwqcbeaac\",\"protocol\":\"SMTP\",\"port\":\"465\"," +
                "\"auth\":\"true\",\"enable\":true,\"host\":\"smtp.qq.com\",\"time\":\"200\"," +
                "\"account\":\"2331746732@qq.com\"}";
        VCodeEmailMsgSetting setting = JSONObject.parseObject(info, VCodeEmailMsgSetting.class);
        msgRequestTO.setSettingTO((IMsgSetting) setting);

        EmailSendContent content = new EmailSendContent();
        content.setContent(code);
        content.setTitle("测试发送");
        content.setReceiverList(requestTO.backStringParams("username"));
        msgRequestTO.setContentTO((IMsgContent) content);

        return emailMsgSendLogic.send(msgRequestTO);
    }


}
