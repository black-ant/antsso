package com.gang.antsso.to;

import lombok.Data;


/**
 * @Classname SsoClientEntity
 * @Description TODO
 * @Date 2020/3/7 20:33
 * @Created by zengzg
 */
@Data
public class SsoClientTO extends BaseAntSsoTO {

    private String id;
    private String clientId;
    private String clientSecret;
    private String clientName;
    private String clientCode;
    private String clientRedirectUrl;
    private String grantType;
    private String scopes;
    private Integer accesstokenTimeout;
    private Integer refushTimeout;
    private String resourceId;


}
