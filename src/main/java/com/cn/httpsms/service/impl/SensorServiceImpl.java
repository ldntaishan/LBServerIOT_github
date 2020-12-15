package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.service.SensorService;
import com.cn.httpsms.util.StringEQ;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SensorServiceImpl extends BaseServiceImpl<Sensor> implements SensorService {

    /**
     * 根据id字符串查询传感器对象
     * @param sensorId
     * @return
     */
    @Override
    public Sensor findById_sensor(String sensorId){
        return find(sensorId);
    }

    @Override
    public void del_ss(String sensorId)
    {
        deleteById(sensorId);
    }

    /**
     * 根据创建时间查询全部
     * //无条件查询前100条数据
     * @return
     */
    @Override
    public List<Sensor> list_all_sensor()
    {
        String list_all_sensor_Sql = "select ss from Sensor ss order by ss.createdate DESC";
        List<Sensor> list_snesor = getResultList(list_all_sensor_Sql);
        return list_snesor;
    }

    @Override
    public List<Sensor> list_query_sensor(int pageSize,int pageNum,String equipmentName)
    {
        String seSql;
        if(StringEQ.checkStringIsNull(equipmentName))
        {
            seSql = "select ss from Sensor ss where ss.equipmentName like '%"+equipmentName+"%' order by pd.createdate DESC";
        }else
        {
            seSql = "select ss from Sensor ss  order by ss.createdate DESC";
        }

        List<Sensor> list = getResultList(seSql,pageSize,pageNum);
        return list;
    }

    @Override
    public long list_count_sensor()
    {
        String cSql = "select count(*) from Sensor ss";
        long count =getCountByHql(cSql);
        return count;
    }


}
