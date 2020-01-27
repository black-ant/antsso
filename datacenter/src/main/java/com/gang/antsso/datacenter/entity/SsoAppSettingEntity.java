package com.gang.antsso.datacenter.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Classname SsoAppSettingEntity
 * @Description TODO
 * @Date 2020/1/27 18:01
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_app_setting", schema = "antsso", catalog = "")
@Data
public class SsoAppSettingEntity extends AbstractEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "setting_body")
    private String settingBody;
    @Basic
    @Column(name = "setting_name")
    private String settingName;
    @Basic
    @Column(name = "setting_type")
    private String settingType;
    @Basic
    @Column(name = "setting_type_code")
    private String settingTypeCode;

    @Basic
    @Column(name = "setting_control")
    private String settingControl;

    @Basic
    @Column(name = "setting_policy")
    private String settingPolicy;

    @Basic
    @Column(name = "create_date")
    private Timestamp createDate;

    public SsoAppSettingEntity() {
    }

    public SsoAppSettingEntity(String id, String settingBody, String settingName, String settingType) {
        this.id = id;
        this.settingBody = settingBody;
        this.settingName = settingName;
        this.settingType = settingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoAppSettingEntity that = (SsoAppSettingEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(settingBody, that.settingBody) &&
                Objects.equals(settingName, that.settingName) &&
                Objects.equals(settingType, that.settingType) &&
                Objects.equals(settingTypeCode, that.settingTypeCode) &&
                Objects.equals(settingControl, that.settingControl) &&
                Objects.equals(settingPolicy, that.settingPolicy) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, settingBody, settingName, settingType, settingTypeCode, settingControl, settingPolicy
                , createDate);
    }
}
