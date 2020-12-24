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
    public void update_sensor(Sensor ss)
    {
        update(ss);
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
    public List<Sensor> list_monitoring_sensor(int pageSize,int pageNum,String useState,String monitoringState)
    {
        String seSql;
        if(StringEQ.checkStringIsNull(useState)&&StringEQ.checkStringIsNull(monitoringState))
        {
            seSql = "select ss from Sensor ss where ss.useState = '"+useState+"' and ss.monitoringState = '"+monitoringState+"' order by ss.createdate DESC";
        }else if(StringEQ.checkStringIsNull(useState))
        {
            seSql = "select ss from Sensor ss where ss.useState = '"+useState+"' order by ss.createdate DESC";
        }else if(StringEQ.checkStringIsNull(monitoringState))
        {
            seSql = "select ss from Sensor ss where ss.monitoringState = '"+monitoringState+"' order by ss.createdate DESC";
        }else
        {
            seSql = "select ss from Sensor ss  order by ss.createdate DESC";
        }

        List<Sensor> list = getResultList(seSql,pageSize,pageNum);
        return list;
    }

    @Override
    public long list_count_monitoring_sensor(String useState,String monitoringState)
    {
        String cSql ;
        if(StringEQ.checkStringIsNull(useState)&&StringEQ.checkStringIsNull(monitoringState))
        {
            cSql = "select count(*) from Sensor ss where ss.useState = '"+useState+"' and ss.monitoringState = '"+monitoringState+"'";
        }else if(StringEQ.checkStringIsNull(useState))
        {
            cSql = "select count(*) from Sensor ss where ss.useState = '"+useState+"'";
        }else if(StringEQ.checkStringIsNull(monitoringState))
        {
            cSql = "select count(*) from Sensor ss where ss.monitoringState = '"+monitoringState+"'";
        }else
        {
            cSql = "select count(*) from Sensor ss";
        }
        long count =getCountByHql(cSql);
        return count;
    }
    @Override
    public long list_count_sensor()
    {
        String cSql = "select count(*) from Sensor ss";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 点位总数
     * @return
     */
    @Override
    public long all_total()
    {
        String cSql = "select count(*) from Sensor ss where ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 点位总数-设备下
     * @return
     */
    @Override
    public long all_total(String equipmentId)
    {
        String cSql = "select count(*) from Sensor ss where ss.equipmentId='"+equipmentId+"' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 报警数
     * @return
     */
    @Override
    public long alert_total()
    {
        String cSql = "select count(*) from Sensor ss where ss.monitoringState='alert' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 报警数-设备下
     * @return
     */
    @Override
    public long alert_total(String equipmentId)
    {
        String cSql = "select count(*) from Sensor ss where ss.equipmentId='"+equipmentId+"' and ss.monitoringState='alert' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 停用数
     * @return
     */
    @Override
    public long disable_total()
    {
        String cSql = "select count(*) from Sensor ss where ss.useState='disable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 停用数-设备下
     * @return
     */
    @Override
    public long disable_total(String equipmentId)
    {
        String cSql = "select count(*) from Sensor ss where ss.equipmentId='"+equipmentId+"' and ss.useState='disable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 掉线数
     * @return
     */
    @Override
    public long offline_total()
    {
        String cSql = "select count(*) from Sensor ss where ss.monitoringState='offline' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 掉线数-设备下
     * @return
     */
    @Override
    public long offline_total(String equipmentId)
    {
        String cSql = "select count(*) from Sensor ss where ss.equipmentId='"+equipmentId+"' and ss.monitoringState='offline' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 正常数
     * @return
     */
    @Override
    public long normal_total()
    {
        String cSql = "select count(*) from Sensor ss where ss.monitoringState='normal' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    /**
     * 正常数-设备下
     * @return
     */
    @Override
    public long normal_total(String equipmentId)
    {
        String cSql = "select count(*) from Sensor ss where ss.equipmentId='"+equipmentId+"' and ss.monitoringState='normal' and ss.useState='enable'";
        long count =getCountByHql(cSql);
        return count;
    }

    @Override
    public List<Sensor> list_enable_sensor()
    {
        String seSql= "select ss from Sensor ss where ss.useState='enable'";


        List<Sensor> list = getResultList(seSql);
        return list;
    }

    @Override
    public List<Sensor> devNo_sensor(String devNo)
    {
        String sql = "select ss from Sensor ss where ss.devNo='"+devNo+"'";
        List<Sensor> list_snesor = getResultList(sql);
        return list_snesor;
    }


}
