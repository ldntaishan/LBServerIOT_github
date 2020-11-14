package com.cn.httpsms.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2020/11/05.
 *
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
