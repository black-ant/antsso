package com.gang.antsso.vcode.api;

import com.gang.antsso.vcode.entity.ISSOMsgSetting;
import com.gang.common.msg.to.MsgRequestTO;

/**
 * @Classname ICodeSend
 * @Description TODO
 * @Date 2020/5/2 11:51
 * @Created by zengzg
 */
public interface ICodeSend<T extends ISSOMsgSetting> {

    String send(MsgRequestTO msgRequestTO);

}
