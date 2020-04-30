package com.gang.antsso.opt;

import com.gang.antsso.opt.logic.OtpGeneratorLogic;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * @Classname MainLogic
 * @Description TODO
 * @Date 2020/1/28 17:46
 * @Created by zengzg
 */
@Component
public class OtpMainLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public String getOptInfo(String primaryKey, String config) {

        OtpGeneratorLogic hotp;
        Key key = null;

        try {
            hotp = new OtpGeneratorLogic();

            final KeyGenerator keyGenerator = KeyGenerator.getInstance(hotp.getAlgorithm());

            keyGenerator.init(512);

            key = keyGenerator.generateKey();


            for (int i = 0; i < 10; i++) {
                Instant now = Instant.now();
                Instant later = now.plus(hotp.getTimeStep());
                logger.info("------> Current password : {} <-------", hotp.generateOneTimePassword(key, now));
                logger.info("------> Future password : {} <-------", hotp.generateOneTimePassword(key, later));
                try {
                    Thread.sleep(35000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return key.getAlgorithm();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;

    }
}
