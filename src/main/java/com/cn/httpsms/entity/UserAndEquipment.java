package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2017/10/24.
 * lzw
 * 用户-设备绑定关系表
 * ----------------------------------
 * 主键
 * 用户表ID
 * 设备表ID
 * 设置城市ID
 * 创建时间
 * 更新时间
 * ----------------------------------
 */
@Entity
@Table(name = "UserAndEquipment")
public class UserAndEquipment implements Serializable {

    private static final long serialVersionUID = 8471575094283888416L;

    public  UserAndEquipment()
    {
        createdate = new Date();
        changedate = createdate;
    }

    /**
     * 主键
     */
    private String userAndEquipmentId;
    /**
     * 用户表ID
     */
    private String userId;
    /**
     * 设备表ID
     */
    private String equipmentId;
    /**
     * 设置城市ID
     */
    private String cityBaseId;

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
    @Column(name = "userAndEquipmentId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getUserAndEquipmentId() {
        return userAndEquipmentId;
    }

    public void setUserAndEquipmentId(String userAndEquipmentId) {
        this.userAndEquipmentId = userAndEquipmentId;
    }

    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "equipmentId")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Column(name = "cityBaseId")
    public String getCityBaseId() {
        return cityBaseId;
    }

    public void setCityBaseId(String cityBaseId) {
        this.cityBaseId = cityBaseId;
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
