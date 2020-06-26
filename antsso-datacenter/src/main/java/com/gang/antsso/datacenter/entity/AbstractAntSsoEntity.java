package com.gang.antsso.datacenter.entity;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Classname AbstractAntSsoEntity
 * @Description TODO
 * @Date 2020/1/25 22:00
 * @Created by zengzg
 */
public abstract class AbstractAntSsoEntity {

    public abstract String getId();

    public abstract void setId(String id);
}
