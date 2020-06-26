/* Copyright (c) 2016 Jon Chambers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE. */

package com.gang.antsso.opt.logic;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;

/**
 * <p>Generates time-based one-time passwords (TOTP) as specified in
 * <a href="https://tools.ietf.org/html/rfc6238">RFC&nbsp;6238</a>.</p>
 *
 * <p>{@code TimeBasedOneTimePasswordGenerator} instances are thread-safe and may be shared between threads.</p>
 *
 * @author <a href="https://github.com/jchambers">Jon Chambers</a>
 */
public class OtpGeneratorLogic extends BaseGeneratorLogic {

    private final Duration timeStep;

    /**
     * The default time-step for a time-based one-time password generator (30 seconds).
     */
    public static final Duration DEFAULT_TIME_STEP = Duration.ofSeconds(30);

    /**
     * A string identifier for the HMAC-SHA1 algorithm (required by HOTP and allowed by TOTP). HMAC-SHA1 is the default
     * algorithm for TOTP.
     */
    public static final String TOTP_ALGORITHM_HMAC_SHA1 = "HmacSHA1";

    /**
     * A string identifier for the HMAC-SHA256 algorithm (allowed by TOTP).
     */
    public static final String TOTP_ALGORITHM_HMAC_SHA256 = "HmacSHA256";

    /**
     * A string identifier for the HMAC-SHA512 algorithm (allowed by TOTP).
     */
    public static final String TOTP_ALGORITHM_HMAC_SHA512 = "HmacSHA512";

    public OtpGeneratorLogic() throws NoSuchAlgorithmException {
        this(DEFAULT_TIME_STEP);
    }

    public OtpGeneratorLogic(final Duration timeStep) throws NoSuchAlgorithmException {
        this(timeStep, BaseGeneratorLogic.DEFAULT_PASSWORD_LENGTH);
    }

    public OtpGeneratorLogic(final Duration timeStep, final int passwordLength) throws NoSuchAlgorithmException {
        this(timeStep, passwordLength, TOTP_ALGORITHM_HMAC_SHA1);
    }

    public OtpGeneratorLogic(final Duration timeStep, final int passwordLength,
                             final String algorithm) throws NoSuchAlgorithmException {
        super(passwordLength, algorithm);

        this.timeStep = timeStep;
    }

    public int generateOneTimePassword(final Key key, final Instant timestamp) throws InvalidKeyException {
        return this.generateOneTimePassword(key, timestamp.toEpochMilli() / this.timeStep.toMillis());
    }

    public Duration getTimeStep() {
        return this.timeStep;
    }
}
