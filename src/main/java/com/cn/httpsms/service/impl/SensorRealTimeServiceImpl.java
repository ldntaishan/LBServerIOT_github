package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.SensorRealTime;
import com.cn.httpsms.service.SensorRealTimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SensorRealTimeServiceImpl extends BaseServiceImpl<SensorRealTime> implements SensorRealTimeService {

//    @Override
//    public Sensor findById_sensor(String sensorId){
//        return find(sensorId);
//    }
//
//    @Override
//    public void update_sensor(Sensor ss)
//    {
//        update(ss);
//    }
//
//    @Override
//    public void del_ss(String sensorId)
//    {
//        deleteById(sensorId);
//    }

    @Override
    public List<SensorRealTime> list_all_sensorRealTime()
    {
        String seSql= "select ssrt from SensorRealTime ssrt";

        List<SensorRealTime> list = getResultList(seSql);
        return list;
    }

    @Override
    public List<SensorRealTime> devNo_sensorRealTime(String devNo)
    {
        String sql = "select ssrt from SensorRealTime ssrt where ssrt.devNo='"+devNo+"'";
        List<SensorRealTime> list = getResultList(sql);
        return list;
    }
}
