package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2020/12/20.
 *
 * 本表主键ID
 * 设备编码（硬件的唯一编号）
 * 实时值
 * 绝对值：通过此逻辑判断 正常 异常
 * 上传时间：判断 在线 掉线 （可作为最新记录上传时间&&可作为最后在线时间）
 */
@Entity
@Table(name = "SensorRealTime")
public class SensorRealTime implements Serializable {

    private static final long serialVersionUID = 4763740374613425283L;

    public  SensorRealTime()
    {

    }

    /**
     * 主键
     */
    private String sensorRealTimeId;

    /**
     * 设备编码（硬件的唯一编号）
     */
    private String devNo;
    /**
     * 实时值
     */
    private double nowTimeValue;

    /**
     * 绝对值：通过此逻辑判断 正常 异常
     */
    private double absoluteValue;

    /**
     * 上传时间：判断 在线 掉线 （可作为最新记录上传时间&&可作为最后在线时间）
     */
    private Date uploadTime;


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(name = "sensorRealTimeId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getSensorRealTimeId() {
        return sensorRealTimeId;
    }

    public void setSensorRealTimeId(String sensorRealTimeId) {
        this.sensorRealTimeId = sensorRealTimeId;
    }

    @Column(name = "devNo")
    public String getDevNo() {
        return devNo;
    }

    public void setDevNo(String devNo) {
        this.devNo = devNo;
    }

    @Column(name = "nowTimeValue")
    public double getNowTimeValue() {
        return nowTimeValue;
    }

    public void setNowTimeValue(double nowTimeValue) {
        this.nowTimeValue = nowTimeValue;
    }

    @Column(name = "absoluteValue")
    public double getAbsoluteValue() {
        return absoluteValue;
    }

    public void setAbsoluteValue(double absoluteValue) {
        this.absoluteValue = absoluteValue;
    }

    @Column(name = "uploadTime")
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
