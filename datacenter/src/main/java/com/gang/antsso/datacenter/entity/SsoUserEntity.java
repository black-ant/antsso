package com.gang.antsso.datacenter.entity;

import com.gang.antsso.auth.api.to.UserInfo;
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
    @Column(name = "user_mobile")
    private String userMobile;

    @Basic
    @Column(name = "user_email")
    private String userEmail;

    @Basic
    @Column(name = "user_info")
    private String userInfo;

    @Basic
    @Column(name = "user_password")
    private String userPassword;

    public void buildEntity(UserInfo userInfo) {
        userInfo.setUserid(this.getId());
        userInfo.setUsername(this.getUserName());
    }

}
