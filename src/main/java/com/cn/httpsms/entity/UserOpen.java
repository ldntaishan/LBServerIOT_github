package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2019/10/14.
 * 平台开放用户基本表
 *
 */
@Entity
@Table(name = "UserOpen")
public class UserOpen implements Serializable {

    private static final long serialVersionUID = 6053467444066576748L;

    public UserOpen()
    {
        createdate = new Date();
        changedate = createdate;
    }

    /**
     * 主键
     */
    private String userOpenId;

    /**
     * 用户名
     */
    private String userOpenName;

    /**
     * 用户昵称
     */
    private String userOpenNickName;

    /**
     * 用户邮箱
     */
    private String userOpenEmail;
    /**
     * 用户手机号
     */
    private String userOpenTel;
    /**
     * 用户登陆密码
     */
    private String userOpenPassWord;

    /**
     * 用户最后上线时间
     */
    private Date lastLoginTime;

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
    @Column(name = "userOpenId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    @Column(name = "userOpenName")
    public String getUserOpenName() {
        return userOpenName;
    }

    public void setUserOpenName(String userOpenName) {
        this.userOpenName = userOpenName;
    }

    @Column(name = "userOpenNickName")
    public String getUserOpenNickName() {
        return userOpenNickName;
    }

    public void setUserOpenNickName(String userOpenNickName) {
        this.userOpenNickName = userOpenNickName;
    }

    @Column(name = "userOpenEmail")
    public String getUserOpenEmail() {
        return userOpenEmail;
    }

    public void setUserOpenEmail(String userOpenEmail) {
        this.userOpenEmail = userOpenEmail;
    }

    @Column(name = "userOpenTel")
    public String getUserOpenTel() {
        return userOpenTel;
    }

    public void setUserOpenTel(String userOpenTel) {
        this.userOpenTel = userOpenTel;
    }

    @Column(name = "userOpenPassWord")
    public String getUserOpenPassWord() {
        return userOpenPassWord;
    }

    public void setUserOpenPassWord(String userOpenPassWord) {
        this.userOpenPassWord = userOpenPassWord;
    }

    @Column(name = "lastLoginTime")
    @Type(type = "java.util.Date")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Column(name = "createdate")
    @Type(type = "java.util.Date")
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Column(name = "changedate")
    @Type(type = "java.util.Date")
    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }
}
