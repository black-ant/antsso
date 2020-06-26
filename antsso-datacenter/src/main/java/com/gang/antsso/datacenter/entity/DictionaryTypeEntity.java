package com.gang.antsso.datacenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname DictionaryTypeEntity
 * @Description TODO
 * @Date 2020/6/26 14:50
 * @Created by zengzg
 */
@Entity
@Table(name = "dictionary_type", schema = "antsso", catalog = "")
public class DictionaryTypeEntity extends AbstractAntSsoEntity {
    private String id;
    private String dName;
    private String dCode;
    private String dType;
    private String dDesc;
    private String dSort;
    private Byte dStatus;
    private String dParent;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "d_name", nullable = true, length = 255)
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Basic
    @Column(name = "d_code", nullable = true, length = 255)
    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    @Basic
    @Column(name = "d_type", nullable = true, length = 255)
    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    @Basic
    @Column(name = "d_desc", nullable = true, length = 255)
    public String getdDesc() {
        return dDesc;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    @Basic
    @Column(name = "d_sort", nullable = true, length = 255)
    public String getdSort() {
        return dSort;
    }

    public void setdSort(String dSort) {
        this.dSort = dSort;
    }

    @Basic
    @Column(name = "d_status", nullable = true)
    public Byte getdStatus() {
        return dStatus;
    }

    public void setdStatus(Byte dStatus) {
        this.dStatus = dStatus;
    }

    @Basic
    @Column(name = "d_parent", nullable = true, length = 255)
    public String getdParent() {
        return dParent;
    }

    public void setdParent(String dParent) {
        this.dParent = dParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryTypeEntity that = (DictionaryTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dName, that.dName) &&
                Objects.equals(dCode, that.dCode) &&
                Objects.equals(dType, that.dType) &&
                Objects.equals(dDesc, that.dDesc) &&
                Objects.equals(dSort, that.dSort) &&
                Objects.equals(dStatus, that.dStatus) &&
                Objects.equals(dParent, that.dParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dName, dCode, dType, dDesc, dSort, dStatus, dParent);
    }
}
