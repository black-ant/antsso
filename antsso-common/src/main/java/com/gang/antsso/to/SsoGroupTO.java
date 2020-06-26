package com.gang.antsso.to;

import lombok.Data;

/**
 * @Classname SsoGroupEntity
 * @Description TODO
 * @Date 2020/3/22 11:29
 * @Created by zengzg
 */
@Data
public class SsoGroupTO extends BaseAntSsoTO {

    private String id;
    private String groupName;
    private String groupRole;
    private String groupCode;
    private String groupDesc;
    private String groupStatus;

}
