package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname SsoClientEntity
 * @Description TODO
 * @Date 2020/3/7 20:33
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_client", schema = "antsso", catalog = "")
public class SsoClientEntity {


    private String id;
    private String clientId;
    private String clientSecret;
    private String clientName;
    private String clientCode;
    private String clientRedirectUrl;
    private String grantType;
    private String scopes;
    private Integer accesstokenTimeout;
    private Integer refushTimeout;
    private String resourceId;


    public SsoClientEntity() {
    }

    public SsoClientEntity(SsoClientEntity entity) {
        this.id = entity.getId();
        this.clientId = entity.getClientId();
        this.clientSecret = entity.getClientSecret();
        this.clientName = entity.getClientName();
        this.clientCode = entity.getClientCode();
        this.clientRedirectUrl = entity.getClientRedirectUrl();
        this.grantType = entity.getGrantType();
        this.scopes = entity.getScopes();
        this.accesstokenTimeout = entity.getAccesstokenTimeout();
        this.refushTimeout = entity.getRefushTimeout();
        this.resourceId = entity.getResourceId();
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "client_id")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "client_secret")
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Basic
    @Column(name = "client_name")
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Basic
    @Column(name = "client_code")
    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    @Basic
    @Column(name = "client_redirect_url")
    public String getClientRedirectUrl() {
        return clientRedirectUrl;
    }

    public void setClientRedirectUrl(String clientRedirectUrl) {
        this.clientRedirectUrl = clientRedirectUrl;
    }

    @Basic
    @Column(name = "grant_type")
    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Basic
    @Column(name = "scopes")
    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    @Basic
    @Column(name = "accesstoken_timeout")
    public Integer getAccesstokenTimeout() {
        return accesstokenTimeout;
    }

    public void setAccesstokenTimeout(Integer accesstokenTimeout) {
        this.accesstokenTimeout = accesstokenTimeout;
    }

    @Basic
    @Column(name = "refush_timeout")
    public Integer getRefushTimeout() {
        return refushTimeout;
    }

    public void setRefushTimeout(Integer refushTimeout) {
        this.refushTimeout = refushTimeout;
    }

    @Basic
    @Column(name = "resource_id")
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoClientEntity entity = (SsoClientEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(clientId, entity.clientId) &&
                Objects.equals(clientSecret, entity.clientSecret) &&
                Objects.equals(clientName, entity.clientName) &&
                Objects.equals(clientCode, entity.clientCode) &&
                Objects.equals(clientRedirectUrl, entity.clientRedirectUrl) &&
                Objects.equals(grantType, entity.grantType) &&
                Objects.equals(scopes, entity.scopes) &&
                Objects.equals(accesstokenTimeout, entity.accesstokenTimeout) &&
                Objects.equals(refushTimeout, entity.refushTimeout) &&
                Objects.equals(resourceId, entity.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, clientSecret, clientName, clientCode, clientRedirectUrl, grantType, scopes,
                accesstokenTimeout, refushTimeout, resourceId);
    }
}
