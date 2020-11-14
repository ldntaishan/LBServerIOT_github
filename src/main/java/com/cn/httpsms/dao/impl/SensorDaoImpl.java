package com.cn.httpsms.dao.impl;


import com.cn.httpsms.dao.SensorDao;
import com.cn.httpsms.entity.Sensor;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDaoImpl extends JpaBaseDaoImpl<Sensor> implements SensorDao {
}
