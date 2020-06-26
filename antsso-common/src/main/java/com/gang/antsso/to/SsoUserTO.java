package com.gang.antsso.to;

import lombok.Data;


/**
 * @Classname SsoUserEntity
 * @Description TODO
 * @Date 2020/1/25 21:48
 * @Created by zengzg
 */
@Data
public class SsoUserTO extends BaseAntSsoTO {

    private String id;

    private String userName;

    private String userMobile;

    private String userEmail;

    private String userInfo;

    private String userPassword;


}
