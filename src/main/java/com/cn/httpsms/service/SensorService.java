package com.cn.httpsms.service;


import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.Sensor;

import java.util.List;

public interface SensorService extends BaseService<Sensor>{

    public Sensor findById_sensor(String sensorId);
    public void del_ss(String sensorId);
    public List<Sensor> list_all_sensor();
}
