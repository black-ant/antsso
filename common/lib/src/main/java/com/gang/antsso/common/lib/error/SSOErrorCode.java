package com.gang.antsso.common.lib.error;

import lombok.Data;

/**
 * @Classname SSOErrorCode
 * @Description TODO
 * @Date 2019/11/21 21:45
 * @Created by zengzg
 */
public enum SSOErrorCode {

    INVALID_AUTH("SSO0001", "invalid_auth", "认证错误", "");

    SSOErrorCode(String code, String errorName, String description, String solution) {
        this.code = code;
        this.errorName = errorName;
        this.description = description;
        this.solution = solution;
    }

    private String code;

    private String errorName;

    private String description;

    private String solution;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
