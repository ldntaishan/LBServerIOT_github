package com.cn.httpsms.monitoringRun;

import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.entity.SensorRealTime;
import com.cn.httpsms.service.SensorRealTimeService;
import com.cn.httpsms.service.SensorService;
import com.cn.httpsms.util.TimeEQ;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.List;

public class MonitoringMain {
    private static Logger logger = Logger.getLogger(MonitoringMain.class);

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorRealTimeService sensorRealTimeService;

    public  void loop() {
        logger.info("=======兰博瑞驰 螺栓监控系统 正在运行======");

        List<SensorRealTime> list= sensorRealTimeService.list_all_sensorRealTime();
        for(int i=0;i<list.size();i++)
        {
            SensorRealTime ssrt=list.get(i);
            Sensor ss=sensorService.devNo_sensor(ssrt.getDevNo()).get(0);
            logger.info("---轮询到点位：---"+ss.getDevNo());
            //必须为可用状态才加入判断
            if("enable".equals(ss.getUseState()))
            {
                //3600000 1小时
                //15000 十五秒
                //60000 一分钟
                //300000 五分钟
                //900000 十五分钟
                //上传时间和当前时间比 判断掉线
                if(!"initialize".equals(ss.getMonitoringState()))
                {//非初始化状态
                    if(TimeEQ.dataEQ(ssrt.getUploadTime(),60000))
                    {
                        logger.info("判断出设备在线");
                        double warningValue=ss.getWarningValue();
                        double absoluteValeu=ssrt.getAbsoluteValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String timestr1=sdf.format(ss.getUploadTime());
                        String timestr2=sdf.format(ssrt.getUploadTime());
                        if(absoluteValeu<warningValue)
                        {
                            if(!"normal".equals(ss.getMonitoringState())||!timestr1.equals(timestr2))
                            {
                                logger.info("---normal-----");
                                ss.setMonitoringState("normal");
                                ss.setAbsoluteValue(ssrt.getAbsoluteValue());
                                ss.setNowTimeValue(ssrt.getNowTimeValue());
                                ss.setUploadTime(ssrt.getUploadTime());
                                sensorService.update(ss);
                            }

                        }else
                        {
                            if(!"alert".equals(ss.getMonitoringState())||!timestr1.equals(timestr2))
                            {
                                logger.info("---alert-----");
                                ss.setMonitoringState("alert");
                                ss.setAbsoluteValue(ssrt.getAbsoluteValue());
                                ss.setNowTimeValue(ssrt.getNowTimeValue());
                                ss.setUploadTime(ssrt.getUploadTime());
                                sensorService.update(ss);
                            }
                        }
                    }else
                    {
                        //写入掉线状态
                        if(!"offline".equals(ss.getUseState()))
                        {
                            logger.info("---offline-----");
                            ss.setMonitoringState("offline");
                            sensorService.update(ss);
                        }
                    }
                }else
                {//初始化状态走这里，直接对比报警值后写入
                    double warningValue=ss.getWarningValue();
                    double absoluteValeu=ssrt.getAbsoluteValue();
                    if(absoluteValeu<warningValue)
                    {
                            logger.info("---初始化的normal-----");
                            ss.setMonitoringState("normal");
                            ss.setAbsoluteValue(ssrt.getAbsoluteValue());
                            ss.setNowTimeValue(ssrt.getNowTimeValue());
                            ss.setUploadTime(ssrt.getUploadTime());
                            sensorService.update(ss);
                    }else
                    {
                            logger.info("---初始化的alert-----");
                            ss.setMonitoringState("alert");
                            ss.setAbsoluteValue(ssrt.getAbsoluteValue());
                            ss.setNowTimeValue(ssrt.getNowTimeValue());
                            ss.setUploadTime(ssrt.getUploadTime());
                            sensorService.update(ss);
                    }
                }

            }else
            {
                logger.info("---disable-----");
            }

        }

    }

}
