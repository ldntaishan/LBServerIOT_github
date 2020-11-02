package com.cn.httpsms.service;

import com.cn.httpsms.entity.ProductOpen;

/**
 * Created by ldn on 2019/10/22.
 */

public interface ProductOpenService extends BaseService<ProductOpen>{

    public void insertProductOpen(ProductOpen po);
//    public List<UserOpen> userlogin(String loginTag, String userPassWord);
//    public UserOpen userlogin(String userOpenId);

}
