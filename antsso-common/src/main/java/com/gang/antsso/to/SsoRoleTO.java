package com.gang.antsso.to;

import lombok.Data;

import java.util.Objects;

/**
 * @Classname SsoRoleEntity
 * @Description TODO
 * @Date 2020/1/25 21:48
 * @Created by zengzg
 */
@Data
public class SsoRoleTO extends BaseAntSsoTO {

    private String id;
    private String roleName;
    private String roleCode;
    private String roleType;
    private Byte roleStatus;
    private String roleInfo;

}
