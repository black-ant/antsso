package com.gang.antsso.to;

import lombok.Data;


/**
 * @Classname UserAppRefEntity
 * @Description TODO
 * @Date 2020/1/27 18:01
 * @Created by zengzg
 */
@Data
public class UserAppRefTO extends BaseAntSsoTO {
    private String id;
    private String userId;
    private String appId;
    private String appRefId;

}
