package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.service.SensorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SensorServiceImpl extends BaseServiceImpl<Sensor> implements SensorService {

    @Override
    public void insertProduct(Sensor ss)
    {

//        insert(pd);
    }


}
