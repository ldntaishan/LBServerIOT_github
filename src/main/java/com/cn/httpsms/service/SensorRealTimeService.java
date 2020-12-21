package com.cn.httpsms.service;


import com.cn.httpsms.entity.SensorRealTime;

import java.util.List;

public interface SensorRealTimeService extends BaseService<SensorRealTime>{

//    public SensorRealTime findById_sensorRealTime(String sensorId);
//    public void update_sensor(Sensor ss);
//    public void del_ss(String sensorId);
//    public List<Sensor> list_all_sensor();
//    public List<Sensor> list_query_sensor(int pageSize,int pageNum,String equipmentName);
//    public List<Sensor> list_monitoring_sensor(int pageSize,int pageNum,String useState,String monitoringState);
//    public long list_count_sensor();
//    public long list_count_monitoring_sensor(String useState,String monitoringState);
//
//    public long all_total();
//    public long alert_total();
//    public long disable_total();
//    public long offline_total();
//    public long normal_total();
      public List<SensorRealTime> list_all_sensorRealTime();
      public List<SensorRealTime> devNo_sensorRealTime(String devNo);
}