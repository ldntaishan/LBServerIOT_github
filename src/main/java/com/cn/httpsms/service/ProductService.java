package com.cn.httpsms.service;

import com.cn.httpsms.entity.Product;

import java.util.List;

/**
 * Created by ldn on 2017/10/24.
 */
public interface ProductService extends BaseService<Product>{
    public void insertProduct(Product pd);
    public List<Product> list_all_product();

}
