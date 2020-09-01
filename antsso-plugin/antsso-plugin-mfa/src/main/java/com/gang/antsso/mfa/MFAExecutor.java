package com.gang.antsso.mfa;

import com.gang.antsso.auth.api.logic.IMFAService;
import com.gang.antsso.auth.api.to.MFARequest;
import com.gang.antsso.auth.api.to.MFAResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname MFAExecutor
 * @Description TODO
 * @Date 2020/7/27 11:40
 * @Created by zengzg
 */
public class MFAExecutor implements IMFAService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public MFAResponse mfaExecute(MFARequest request) {
        logger.info("------> this is in MFA Policy <-------");
        return null;
    }
}
