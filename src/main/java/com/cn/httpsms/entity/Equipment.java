package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2017/10/24.
 * lzw
 * 设备表
 * --------------------------------------
 * 主键
 * 设备名称（风塔名称）
 * 设备类型
 * 设备编号
 * 从属产品ID
 * 从属产品名称（冗余字段）
 * 管理状态（1可运行 2不可运行 ）
 * 创建时间
 * 更新时间
 * --------------------------------------
 */
@Entity
@Table(name = "Equipment")
public class Equipment implements Serializable {


    private static final long serialVersionUID = 1123194599241676519L;

    public  Equipment()
    {
        createdate = new Date();
        changedate = createdate;
    }

    /**
     * 主键
     */
    private String equipmentId;
    /**
     * 设备名称
     */
    private String equipmentName;
    /**
     * 设备类型
     */
    private String equipmentType;
    /**
     * 设备编号
     */
    private String equipmentNO;

    /**
     * 从属产品ID
     */
    private String productId;
    /**
     * 从属产品名称（冗余字段）
     */
    private String productName;

    /**
     * 管理状态（1可运行 2不可运行）
     */
    private String equipmentState;
    /**
     * 创建时间
     */
    private Date createdate;
    /**
     * 更新时间
     */
    private Date changedate;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(name = "equipmentId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Column(name = "equipmentName")
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
    @Column(name = "equipmentType")
    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Column(name = "equipmentNO")
    public String getEquipmentNO() {
        return equipmentNO;
    }

    public void setEquipmentNO(String equipmentNO) {
        this.equipmentNO = equipmentNO;
    }
    @Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "equipmentState")
    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }



    @Column(name = "CREATE_DATE")
    @Type(type = "java.util.Date")
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Column(name = "CHANGE_DATE")
    @Type(type = "java.util.Date")
    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }
}
