package com.cn.httpsms.service.impl;

import com.cn.httpsms.entity.ProductOpen;
import com.cn.httpsms.service.ProductOpenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ldn on 2019/10/22.
 */
@Service
@Transactional
public class ProductOpenServiceImpl extends BaseServiceImpl<ProductOpen> implements ProductOpenService {

    public void insertProductOpen(ProductOpen po)
    {
        insert(po);
    }
}