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
 * 本表主键ID
 * 所属场站
 * 设备名称
 * 设备型号
 * 设备编号（系统自用）
 * 系统状态
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
     * 本表主键ID
     */
    private String equipmentId;
    /**
     * 机构名称（所属风场）
     */
    private String organization;
    /**
     * 设备名称
     */
    private String equipmentName;
    /**
     * 设备型号
     */
    private String equipmentType;
    /**
     * 设备编号
     */
    private String equipmentNO;
    /**
     * 系统状态
     */
    private String sysState;

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

    @Column(name = "organization")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(name = "sysState")
    public String getSysState() {
        return sysState;
    }

    public void setSysState(String sysState) {
        this.sysState = sysState;
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
