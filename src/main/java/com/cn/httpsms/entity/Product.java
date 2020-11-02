package com.cn.httpsms.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ldn on 2017/10/24.
 * lzw
 * 与电信IOT的产品映射表
 * ----------------------------------
 * 主键
 * 产品名称
 * 产品描述
 * 阿里云产品 ProductKey
 * 创建时间
 * 更新时间
 * ------------------------------------
 */
@Entity
@Table(name = "Product")
public class Product implements Serializable {


    private static final long serialVersionUID = 5281423046092440809L;

    public  Product()
    {
        createdate = new Date();
        changedate = createdate;
    }

    /**
     * 主键
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 厂商ID
     */
    private String productCTCCId;

    /**
     * 所属行业
     */
    private String productIndustryType;

    /**
     * 设备类型
     */
    private String productEquipmentType;

    /**
     * 接入应用层协议类型
     * 截至2019年9月18日：CoAP 或者LWM2M
     */
    private String connectProtocol;

    /**
     * 产品图标ICO url地址
     * 建议200*200
     */
    private String productICOUrl;

    /**
     * 产品简介
     */
    private String productDescription;

    /**
     * 电信IoT所需的 Profile文件
     */
    private String productCTCCProfile;

    /**
     * 电信IoT所需的 编解码插件文件
     */
    private String productCTCCCodefile;

    /**
     * 从属主体（一个id）
     */
    private String parentId;
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
    @Column(name = "productId", nullable = false, insertable = true, updatable = true, length = 32)
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

    @Column(name = "productModel")
    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    @Column(name = "productCTCCId")
    public String getProductCTCCId() {
        return productCTCCId;
    }

    public void setProductCTCCId(String productCTCCId) {
        this.productCTCCId = productCTCCId;
    }

    @Column(name = "productIndustryType")
    public String getProductIndustryType() {
        return productIndustryType;
    }

    public void setProductIndustryType(String productIndustryType) {
        this.productIndustryType = productIndustryType;
    }

    @Column(name = "productEquipmentType")
    public String getProductEquipmentType() {
        return productEquipmentType;
    }

    public void setProductEquipmentType(String productEquipmentType) {
        this.productEquipmentType = productEquipmentType;
    }

    @Column(name = "connectProtocol")
    public String getConnectProtocol() {
        return connectProtocol;
    }

    public void setConnectProtocol(String connectProtocol) {
        this.connectProtocol = connectProtocol;
    }

    @Column(name = "productICOUrl")
    public String getProductICOUrl() {
        return productICOUrl;
    }

    public void setProductICOUrl(String productICOUrl) {
        this.productICOUrl = productICOUrl;
    }

    @Column(name = "productDescription")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Column(name = "productCTCCProfile")
    public String getProductCTCCProfile() {
        return productCTCCProfile;
    }

    public void setProductCTCCProfile(String productCTCCProfile) {
        this.productCTCCProfile = productCTCCProfile;
    }

    @Column(name = "productCTCCCodefile")
    public String getProductCTCCCodefile() {
        return productCTCCCodefile;
    }

    public void setProductCTCCCodefile(String productCTCCCodefile) {
        this.productCTCCCodefile = productCTCCCodefile;
    }

    @Column(name = "parentId")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
