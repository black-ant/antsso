package com.gang.antsso.to;

import lombok.Data;

/**
 * @Classname SsoAppTypeEntity
 * @Description TODO
 * @Date 2020/1/27 18:01
 * @Created by zengzg
 */
@Data
public class SsoAppTypeTO extends BaseAntSsoTO {

    private String id;
    private String typeCode;
    private String typeClass;
    private String typePolicy;
    private String typeName;
    private String supplierId;
    private String supplierName;
    private String dataType;

}
