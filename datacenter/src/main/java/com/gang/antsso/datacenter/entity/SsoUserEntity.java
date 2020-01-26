package com.gang.antsso.datacenter.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname SsoUserEntity
 * @Description TODO
 * @Date 2020/1/25 21:48
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_user", schema = "antsso", catalog = "")
@Data
public class SsoUserEntity extends AbstractEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "user_name")
    private String userName;

    @Basic
    @Column(name = "user_info")
    private String userInfo;


    @Basic
    @Column(name = "user_password")
    private String userPassword;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoUserEntity that = (SsoUserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userInfo, that.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userInfo);
    }
}
