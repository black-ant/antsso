package com.gang.antsso.exception;

import com.gang.common.lib.exception.AntExceptionUtils;
import com.gang.common.lib.to.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Classname SsoExceptionAdvice
 * @Description TODO
 * @Date 2020/5/3 23:00
 * @Created by zengzg
 */
@ControllerAdvice
public class SsoExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public ResponseError toResponse(Exception ex) {
        logger.error("E----> error :{} -- content :{}", ex.getClass(), ex.getMessage());
        ex.printStackTrace();
        return AntExceptionUtils.buildErrorTO(ex);
    }
}
