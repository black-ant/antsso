package com.gang.antsso.vcode.service.send;

import com.gang.antsso.vcode.api.ICodeSend;
import com.gang.antsso.vcode.entity.VCodeAliyunMsgSetting;
import com.gang.antsso.vcode.entity.VCodeRongYunSmsMsgSetting;
import com.gang.common.msg.to.MsgRequestTO;
import org.springframework.stereotype.Component;

/**
 * @Classname RongYunSmsServie
 * @Description TODO
 * @Date 2020/5/2 11:53
 * @Created by zengzg
 */
@Component
public class RongYunSmsSendServie implements ICodeSend<VCodeRongYunSmsMsgSetting> {

    @Override
    public String send(MsgRequestTO msgRequestTO) {
        return null;
    }
}
