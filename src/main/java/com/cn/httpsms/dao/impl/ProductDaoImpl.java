package com.cn.httpsms.dao.impl;


import com.cn.httpsms.dao.ProductDao;
import com.cn.httpsms.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by ldn on 2017/10/24.
 */

@Repository
public class ProductDaoImpl extends JpaBaseDaoImpl<Product> implements ProductDao {
}
