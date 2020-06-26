package com.gang.antsso.to;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Classname DictionaryInfoEntity
 * @Description TODO
 * @Date 2020/6/26 14:50
 * @Created by zengzg
 */
@Data
public class DictionaryInfoTO extends BaseAntSsoTO {

    private String id;
    private String dtCode;
    private String dtName;
    private String dtAlias;
    private String dtValue;
    private byte[] dtAttachment;
    private String dtDesc;
    private Object dtInfo;
    private Byte dtStatus;
    private String dtPermission;
    private String dtType;
    private String dtSort;
    private Timestamp dtCreateDate;
    private String dtCreateUser;
    private String dId;
    private String dCode;

}
