package com.cn.httpsms.service;


import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.Sensor;

import java.util.List;

public interface SensorService extends BaseService<Sensor>{

    public Sensor findById_sensor(String sensorId);
    public void update_sensor(Sensor ss);
    public void del_ss(String sensorId);
    public List<Sensor> list_all_sensor();
    public List<Sensor> list_query_sensor(int pageSize,int pageNum,String equipmentName);
    public List<Sensor> list_monitoring_sensor(int pageSize,int pageNum,String useState,String monitoringState);
    public long list_count_sensor();
    public long list_count_monitoring_sensor(String useState,String monitoringState);

    public long all_total();
    public long alert_total();
    public long disable_total();
    public long offline_total();
    public long normal_total();
}
