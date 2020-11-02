package com.cn.httpsms.entity;

import java.util.Date;

/**
 * Created by ldn on 2019/10/25.
 */
public class TokenSave {

    public  TokenSave()
    {
        createdate = new Date();
        changedate = createdate;
    }
    /**
     * 本表主键id
     */
    private String tokenSaveId;

    /**
     * 对应平台
     */
    private String toPlatform;

    /**
     * token值
     */
    private String accessToken;

    /**
     * 有效期（秒）
     */
    private int expiresIn;

    /**
     * 获取时间
     */
    private Date getAccessTokenDate;

    /**
     *  预计过期时间
     */
    private Date imeoutAccessTokenDate;

    /**
     * 刷新token值（部分平台申请token时会签发）
     */
    private String refreshToken;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     * 更新时间
     */
    private Date changedate;


    public String getTokenSaveId() {
        return tokenSaveId;
    }

    public void setTokenSaveId(String tokenSaveId) {
        this.tokenSaveId = tokenSaveId;
    }

    public String getToPlatform() {
        return toPlatform;
    }

    public void setToPlatform(String toPlatform) {
        this.toPlatform = toPlatform;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getGetAccessTokenDate() {
        return getAccessTokenDate;
    }

    public void setGetAccessTokenDate(Date getAccessTokenDate) {
        this.getAccessTokenDate = getAccessTokenDate;
    }

    public Date getImeoutAccessTokenDate() {
        return imeoutAccessTokenDate;
    }

    public void setImeoutAccessTokenDate(Date imeoutAccessTokenDate) {
        this.imeoutAccessTokenDate = imeoutAccessTokenDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }
}
