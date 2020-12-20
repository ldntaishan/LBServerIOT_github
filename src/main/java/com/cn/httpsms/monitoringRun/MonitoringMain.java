package com.cn.httpsms.monitoringRun;

import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.entity.SensorRealTime;
import com.cn.httpsms.service.SensorRealTimeService;
import com.cn.httpsms.service.SensorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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

            //todo 上传时间和当前时间比 判断掉线

            //todo 绝对值 absoluteValue 和 报警阈值 warningValue比 判断是否松动

            //


        }

    }
}
