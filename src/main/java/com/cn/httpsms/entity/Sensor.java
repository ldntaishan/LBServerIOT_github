package com.cn.httpsms.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2020/11/05.
 *
 * 本表主键ID
 * 型号
 * 设备编码（硬件的唯一编号）
 * 所属风塔ID
 * 定制松动阈值
 * 统一松动阈值
 * 实时值
 * 绝对值：通过此逻辑判断 正常 异常
 * 上传时间：判断 在线 掉线 （可作为最新记录上传时间&&可作为最后在线时间）
 * 系统状态：停用、启用
 * 创建时间
 * 修改时间
 */
@Entity
@Table(name = "Sensor")
public class Sensor implements Serializable {

    private static final long serialVersionUID = 5733354379809287508L;

    public  Sensor()
    {
        createdate = new Date();
        changedate = createdate;
    }

    /**
     * 主键
     */
    private String sensorId;

    /**
     * 传感器描述
     */
    private String sensorDescription;

    /**
     * 型号
     */
    private String sensorType;

    /**
     * 设备编码（硬件的唯一编号）
     */
    private String devNo;

    /**
     * 所属设备ID（风塔id）
     */
    private String equipmentId;

    /**
     * 定制松动阈值
     */
    private String warningValue;

    /**
     * 统一松动阈值
     */
    private String allWarningId;

    /**
     * 实时值
     */
    private String nowTimeValue;

    /**
     * 绝对值：通过此逻辑判断 正常 异常
     */
    private String absoluteValue;

    /**
     * 上传时间：判断 在线 掉线 （可作为最新记录上传时间&&可作为最后在线时间）
     */
    private Date uploadTime;

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
    @Column(name = "sensorId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    @Column(name = "sensorDescription")
    public String getSensorDescription() {
        return sensorDescription;
    }

    public void setSensorDescription(String sensorDescription) {
        this.sensorDescription = sensorDescription;
    }

    @Column(name = "sensorType")
    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    @Column(name = "devNo")
    public String getDevNo() {
        return devNo;
    }

    public void setDevNo(String devNo) {
        this.devNo = devNo;
    }

    @Column(name = "equipmentId")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Column(name = "warningValue")
    public String getWarningValue() {
        return warningValue;
    }

    public void setWarningValue(String warningValue) {
        this.warningValue = warningValue;
    }

    @Column(name = "allWarningId")
    public String getAllWarningId() {
        return allWarningId;
    }

    public void setAllWarningId(String allWarningId) {
        this.allWarningId = allWarningId;
    }

    @Column(name = "nowTimeValue")
    public String getNowTimeValue() {
        return nowTimeValue;
    }

    public void setNowTimeValue(String nowTimeValue) {
        this.nowTimeValue = nowTimeValue;
    }

    @Column(name = "absoluteValue")
    public String getAbsoluteValue() {
        return absoluteValue;
    }

    public void setAbsoluteValue(String absoluteValue) {
        this.absoluteValue = absoluteValue;
    }

    @Column(name = "UPLOAD_TIME")
    @Type(type = "java.util.Date")
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
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

    private String equipmentName;

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
