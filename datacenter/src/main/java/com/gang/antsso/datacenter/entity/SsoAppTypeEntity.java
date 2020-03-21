package com.gang.antsso.datacenter.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname SsoAppTypeEntity
 * @Description TODO
 * @Date 2020/1/27 18:01
 * @Created by zengzg
 */
@Entity
@Table(name = "sso_app_type", schema = "antsso", catalog = "")
public class SsoAppTypeEntity extends AbstractEntity {
    private String id;
    private String typeCode;
    private String typeClass;
    private String typePolicy;
    private String typeName;
    private String supplierId;
    private String supplierName;
    private String dataType;

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_code")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Basic
    @Column(name = "type_class")
    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    @Basic
    @Column(name = "type_policy")
    public String getTypePolicy() {
        return typePolicy;
    }

    public void setTypePolicy(String typePolicy) {
        this.typePolicy = typePolicy;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "supplier_id")
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "data_type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsoAppTypeEntity that = (SsoAppTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(typeCode, that.typeCode) &&
                Objects.equals(typeClass, that.typeClass) &&
                Objects.equals(typePolicy, that.typePolicy) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(dataType, that.dataType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeCode, typeClass, typePolicy, typeName, supplierId, supplierName, dataType);
    }
}
