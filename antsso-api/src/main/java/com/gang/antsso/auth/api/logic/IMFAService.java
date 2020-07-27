package com.gang.antsso.auth.api.logic;

import com.gang.antsso.auth.api.to.MFARequest;
import com.gang.antsso.auth.api.to.MFAResponse;

/**
 * @Classname IMFAService
 * @Description TODO
 * @Date 2020/7/27 11:32
 * @Created by zengzg
 */
public interface IMFAService {

    MFAResponse mfaExecute(MFARequest request);

}
