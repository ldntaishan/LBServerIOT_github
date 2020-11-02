package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 平台用户产品表
 * Created by ldn on 2019/10/22.
 */
@Entity
@Table(name = "ProductOpen")
public class ProductOpen implements Serializable {

    private static final long serialVersionUID = 8189471102189033133L;

    public ProductOpen()
    {
        createdate = new Date();
        changedate = createdate;
    }
    /**
     * 产品id
     */
    public String productOpenId;

    /**
     * 产品名称
     */
    public String productOpenName;

    /**
     * 产品描述
     */
    public String productOpenDescription;

    /**
     * 关联的平台用户ID
     */
    public String userOpenId;

    /**
     * 关联的平台产品ID
     */
    public String productId;

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
    @Column(name = "productOpenId", nullable = false, insertable = true, updatable = true, length = 32)
    public String getProductOpenId() {
        return productOpenId;
    }

    public void setProductOpenId(String productOpenId) {
        this.productOpenId = productOpenId;
    }
    @Column(name = "userOpenName")
    public String getProductOpenName() {
        return productOpenName;
    }

    public void setProductOpenName(String productOpenName) {
        this.productOpenName = productOpenName;
    }
    @Column(name = "productOpenDescription")
    public String getProductOpenDescription() {
        return productOpenDescription;
    }

    public void setProductOpenDescription(String productOpenDescription) {
        this.productOpenDescription = productOpenDescription;
    }
    @Column(name = "userOpenId")
    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    @Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
