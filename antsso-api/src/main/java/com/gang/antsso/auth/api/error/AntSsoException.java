package com.gang.antsso.auth.api.error;

import com.gang.common.lib.exception.CommonException;

/**
 * @Classname SsoException
 * @Description TODO
 * @Date 2020/1/10 14:36
 * @Created by zengzg
 */
public class AntSsoException extends CommonException {

    public AntSsoException() {
        super();
    }

    public AntSsoException(String message) {
        super(message);
    }

    public AntSsoException(String message, String code) {
        super(message, code);
    }
}
