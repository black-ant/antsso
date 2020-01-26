package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname SsoRoleEntity
 * @Description TODO
 * @Date 2020/1/25 21:48
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_role", schema = "antsso", catalog = "")
public class SsoRoleEntity extends AbstractEntity {
    private String id;
    private String roleName;
    private String roleCode;
    private String roleType;
    private Byte roleStatus;
    private String roleInfo;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_code")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "role_type")
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Basic
    @Column(name = "role_status")
    public Byte getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Byte roleStatus) {
        this.roleStatus = roleStatus;
    }

    @Basic
    @Column(name = "role_info")
    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoRoleEntity that = (SsoRoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleCode, that.roleCode) &&
                Objects.equals(roleType, that.roleType) &&
                Objects.equals(roleStatus, that.roleStatus) &&
                Objects.equals(roleInfo, that.roleInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, roleCode, roleType, roleStatus, roleInfo);
    }
}
