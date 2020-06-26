package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname SsoGroupEntity
 * @Description TODO
 * @Date 2020/3/22 11:29
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_group", schema = "antsso", catalog = "")
public class SsoGroupEntity extends AbstractAntSsoEntity {

    private String id;
    private String groupName;
    private String groupRole;
    private String groupCode;
    private String groupDesc;
    private String groupStatus;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_role")
    public String getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(String groupRole) {
        this.groupRole = groupRole;
    }

    @Basic
    @Column(name = "group_code")
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Basic
    @Column(name = "group_desc")
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Basic
    @Column(name = "group_status")
    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoGroupEntity that = (SsoGroupEntity) o;
        return id == that.id &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(groupRole, that.groupRole) &&
                Objects.equals(groupCode, that.groupCode) &&
                Objects.equals(groupDesc, that.groupDesc) &&
                Objects.equals(groupStatus, that.groupStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, groupRole, groupCode, groupDesc, groupStatus);
    }
}
