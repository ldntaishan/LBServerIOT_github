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
 * 设备名称
 * 设备类型
 * 设备出厂唯一码
 * 设备密钥（阿里云设备deviceSecret）
 * 阿里云设备名（deviceName）
 * 从属产品ID
 * 从属产品名称（冗余字段）
 * 阿里云从属产品key（productKey）
 * 管理状态（1可运行 2不可运行 3异常运行）
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
     * 设备出厂唯一码(序列码)
     */
    private String equipmentSN;
    /**
     * 设备密钥（阿里云设备deviceSecret）
     */
    private String deviceSecret;
    /**
     * 阿里云设备名（deviceName）
     */
    private String deviceName;
    /**
     * 从属产品ID
     */
    private String productId;
    /**
     * 从属产品名称（冗余字段）
     */
    private String productName;
    /**
     * 阿里云从属产品key（productKey） 冗余字段
     */
    private String productKey;
    /**
     * 管理状态（1可运行 2不可运行 3异常运行）
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
    @Column(name = "equipmentSN")
    public String getEquipmentSN() {
        return equipmentSN;
    }

    public void setEquipmentSN(String equipmentSN) {
        this.equipmentSN = equipmentSN;
    }
    @Column(name = "deviceSecret")
    public String getDeviceSecret() {
        return deviceSecret;
    }

    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }
    @Column(name = "deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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
    @Column(name = "productKey")
    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
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
