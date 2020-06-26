package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname SsoConfigEntity
 * @Description TODO
 * @Date 2020/1/25 21:48
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_config", schema = "antsso", catalog = "")
public class SsoConfigEntity extends AbstractAntSsoEntity {
    private String id;
    private String configBody;
    private String configType;
    private String configName;
    private String configCode;
    private String configStatus;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "config_body")
    public String getConfigBody() {
        return configBody;
    }

    public void setConfigBody(String configBody) {
        this.configBody = configBody;
    }

    @Basic
    @Column(name = "config_type")
    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    @Basic
    @Column(name = "config_name")
    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @Basic
    @Column(name = "config_code")
    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    @Basic
    @Column(name = "config_status")
    public String getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(String configStatus) {
        this.configStatus = configStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoConfigEntity that = (SsoConfigEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(configBody, that.configBody) &&
                Objects.equals(configType, that.configType) &&
                Objects.equals(configName, that.configName) &&
                Objects.equals(configCode, that.configCode) &&
                Objects.equals(configStatus, that.configStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, configBody, configType, configName, configCode, configStatus);
    }
}
