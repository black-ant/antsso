package com.gang.antsso.to;

import lombok.Data;

import java.util.Objects;

/**
 * @Classname SsoConfigEntity
 * @Description TODO
 * @Date 2020/1/25 21:48
 * @Created by zengzg
 */
@Data
public class SsoConfigTO extends BaseAntSsoTO {

    private String id;
    private String configBody;
    private String configType;
    private String configName;
    private String configCode;
    private String configStatus;

}
