package com.gang.antsso.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Classname DictionaryTypeEntity
 * @Description TODO
 * @Date 2020/6/26 14:50
 * @Created by zengzg
 */
@Data
@JsonInclude
public class DictionaryTypeTO extends BaseAntSsoTO {

    private String id;
    private String dName;
    private String dCode;
    private String dType;
    private String dDesc;
    private String dSort;
    private Byte dStatus;
    private String dParent;

}
