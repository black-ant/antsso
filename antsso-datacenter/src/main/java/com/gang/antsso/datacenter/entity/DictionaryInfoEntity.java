package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @Classname DictionaryInfoEntity
 * @Description TODO
 * @Date 2020/6/26 14:50
 * @Created by zengzg
 */
@Entity
@Table(name = "dictionary_info", schema = "antsso", catalog = "")
public class DictionaryInfoEntity extends AbstractAntSsoEntity {

    private String id;
    private String dtCode;
    private String dtName;
    private String dtAlias;
    private String dtValue;
    private byte[] dtAttachment;
    private String dtDesc;
    //    private String dtInfo;
    private Boolean dtStatus;
    private String dtPermission;
    private String dtType;
    private String dtSort;
    private Date dtCreateDate;
    private String dtCreateUser;
    private String dId;
    private String dCode;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dt_code", nullable = true, length = 255)
    public String getDtCode() {
        return dtCode;
    }

    public void setDtCode(String dtCode) {
        this.dtCode = dtCode;
    }

    @Basic
    @Column(name = "dt_name", nullable = true, length = 255)
    public String getDtName() {
        return dtName;
    }

    public void setDtName(String dtName) {
        this.dtName = dtName;
    }

    @Basic
    @Column(name = "dt_alias", nullable = true, length = 255)
    public String getDtAlias() {
        return dtAlias;
    }

    public void setDtAlias(String dtAlias) {
        this.dtAlias = dtAlias;
    }

    @Basic
    @Column(name = "dt_value", nullable = true, length = -1)
    public String getDtValue() {
        return dtValue;
    }

    public void setDtValue(String dtValue) {
        this.dtValue = dtValue;
    }

    @Basic
    @Column(name = "dt_attachment", nullable = true)
    public byte[] getDtAttachment() {
        return dtAttachment;
    }

    public void setDtAttachment(byte[] dtAttachment) {
        this.dtAttachment = dtAttachment;
    }

    @Basic
    @Column(name = "dt_desc", nullable = true, length = 255)
    public String getDtDesc() {
        return dtDesc;
    }

    public void setDtDesc(String dtDesc) {
        this.dtDesc = dtDesc;
    }

    //    @Basic
    //    @Column(name = "dt_info", nullable = true)
    //    public Object getDtInfo() {
    //        return dtInfo;
    //    }
    //
    //    public void setDtInfo(String dtInfo) {
    //        this.dtInfo = dtInfo;
    //    }

    @Basic
    @Column(name = "dt_status", nullable = true)
    public Boolean getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(Boolean dtStatus) {
        this.dtStatus = dtStatus;
    }

    @Basic
    @Column(name = "dt_permission", nullable = true, length = 255)
    public String getDtPermission() {
        return dtPermission;
    }

    public void setDtPermission(String dtPermission) {
        this.dtPermission = dtPermission;
    }

    @Basic
    @Column(name = "dt_type", nullable = true, length = 255)
    public String getDtType() {
        return dtType;
    }

    public void setDtType(String dtType) {
        this.dtType = dtType;
    }

    @Basic
    @Column(name = "dt_sort", nullable = true, length = 255)
    public String getDtSort() {
        return dtSort;
    }

    public void setDtSort(String dtSort) {
        this.dtSort = dtSort;
    }

    @Basic
    @Column(name = "dt_create_date", nullable = true)
    public Date getDtCreateDate() {
        return dtCreateDate;
    }

    public void setDtCreateDate(Date dtCreateDate) {
        this.dtCreateDate = dtCreateDate;
    }

    @Basic
    @Column(name = "dt_create_user", nullable = true, length = 255)
    public String getDtCreateUser() {
        return dtCreateUser;
    }

    public void setDtCreateUser(String dtCreateUser) {
        this.dtCreateUser = dtCreateUser;
    }

    @Basic
    @Column(name = "D_ID", nullable = true, length = 255)
    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    @Basic
    @Column(name = "D_CODE", nullable = true, length = 255)
    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryInfoEntity that = (DictionaryInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dtCode, that.dtCode) &&
                Objects.equals(dtName, that.dtName) &&
                Objects.equals(dtAlias, that.dtAlias) &&
                Objects.equals(dtValue, that.dtValue) &&
                Arrays.equals(dtAttachment, that.dtAttachment) &&
                Objects.equals(dtDesc, that.dtDesc) &&
                //                Objects.equals(dtInfo, that.dtInfo) &&
                Objects.equals(dtStatus, that.dtStatus) &&
                Objects.equals(dtPermission, that.dtPermission) &&
                Objects.equals(dtType, that.dtType) &&
                Objects.equals(dtSort, that.dtSort) &&
                Objects.equals(dtCreateDate, that.dtCreateDate) &&
                Objects.equals(dtCreateUser, that.dtCreateUser) &&
                Objects.equals(dId, that.dId) &&
                Objects.equals(dCode, that.dCode);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, dtCode, dtName, dtAlias, dtValue, dtDesc, dtStatus, dtPermission, dtType, dtSort, dtCreateDate, dtCreateUser,
                dId, dCode);
        result = 31 * result + Arrays.hashCode(dtAttachment);
        return result;
    }
}
