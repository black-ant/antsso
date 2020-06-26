package com.gang.antsso.to;

import lombok.Data;

import java.util.Date;

/**
 * @Classname SsoAppSettingEntity
 * @Description TODO
 * @Date 2020/1/27 18:01
 * @Created by zengzg
 */
@Data
public class SsoAppSettingTO extends BaseAntSsoTO {

    private String id;

    private String settingBody;

    private String settingName;

    private String settingType;

    private String settingTypeCode;

    private String settingControl;

    private String settingPolicy;

    private Date createDate;


}
