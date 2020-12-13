package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2017/10/24.
 * lzw
 * 用户基本信息表
 * ------------------------------
 * 主键
 * 用户名
 * 用户昵称
 * 用户邮箱
 * 用户手机号
 * 用户登陆密码
 * 用户状态
 * 用户最后上线时间
 * 创建时间
 * 更新时间
 * --------------------------------
 */
@Entity
@Table(name = "UserBase")
public class UserBase implements Serializable {
    private static final long serialVersionUID = -427857356602849594L;

    public  UserBase()
    {
        createdate = new Date();
        changedate = createdate;
    }

    /**
     * 主键
     */
    private String userId;
    /**
     * 用户名
     */

    private String userName;
    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 用户角色
     *
     */
    private String userRole;

    /**
     * 用户登陆密码
     */
    private String userPassWord;

    /**
     * 用户状态
     * 1 为 在用
     * 2 为 停用
     */
    private String userState;
    /**
     * 用户最后上线时间
     */
    private Date lastLoginTime;
//    /**
//     * 登陆是否有效
//     * 0有效 1无效
//     */
//    private  String userLoginState;
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
    @Column(name = "userId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "userNickName")
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Column(name = "userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "userTel")
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Column(name = "userPassWord")
    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    @Column(name = "userState")
    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }



    @Column(name = "lastLoginTime")
    @Type(type = "java.util.Date")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

//    @Column(name = "userLoginState")
//    public String getUserLoginState() {
//        return userLoginState;
//    }
//
//    public void setUserLoginState(String userLoginState) {
//        this.userLoginState = userLoginState;
//    }


    @Column(name = "userRole")
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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
