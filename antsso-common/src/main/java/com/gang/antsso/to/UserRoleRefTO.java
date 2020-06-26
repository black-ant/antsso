package com.gang.antsso.to;

import lombok.Data;

import java.util.Date;


/**
 * @Classname UserRoleRefEntity
 * @Description TODO
 * @Date 2020/1/25 22:27
 * @Created by zengzg
 */
@Data
public class UserRoleRefTO extends BaseAntSsoTO {

    private String id;
    private String userId;
    private String roleId;
    private Byte status;
    private String type;
    private String createId;
    private Date createDate;
    private String updateId;
    private Date updateDate;

}
