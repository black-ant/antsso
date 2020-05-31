package com.gang.antsso.password;

import com.gang.antsso.auth.api.logic.IPasswordServicec;
import org.springframework.stereotype.Component;

/**
 * @Classname CommonPasswordService
 * @Description TODO
 * @Date 2020/2/23 17:56
 * @Created by zengzg
 */
@Component
public class CommonPasswordService implements IPasswordServicec {

    /**
     * @param key
     */
    public String getPassword(String key) {
        return "123456";
    }
}
