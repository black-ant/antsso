package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname UserAppRefEntity
 * @Description TODO
 * @Date 2020/1/27 18:01
 * @Created by zengzg
 */
@Entity
@Table(name = "user_app_ref", schema = "antsso", catalog = "")
public class UserAppRefEntity extends AbstractEntity {
    private String id;
    private String userId;
    private String appId;
    private String appRefId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "app_id")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "app_ref_id")
    public String getAppRefId() {
        return appRefId;
    }

    public void setAppRefId(String appRefId) {
        this.appRefId = appRefId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAppRefEntity that = (UserAppRefEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(appId, that.appId) &&
                Objects.equals(appRefId, that.appRefId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, appId, appRefId);
    }
}
