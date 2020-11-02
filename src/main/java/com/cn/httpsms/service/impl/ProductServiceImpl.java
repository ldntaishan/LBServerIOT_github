package com.cn.httpsms.service.impl;

import com.cn.httpsms.entity.Product;
import com.cn.httpsms.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ldn on 2017/10/24.
 */
@Service
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Override
    public void insertProduct(Product pd)
    {
        insert(pd);
    }

    /**
     * 无条件查询前100条数据
     * @return
     */
    @Override
    public List<Product> list_all_product()
    {
        String list_all_product_Sql = "select pd from Product pd order by pd.createdate DESC";
        List<Product> list_Product = getResultList(list_all_product_Sql);
        return list_Product;
    }

}
