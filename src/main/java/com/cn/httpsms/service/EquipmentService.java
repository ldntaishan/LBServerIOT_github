package com.cn.httpsms.service;

import com.cn.httpsms.entity.Equipment;

/**
 * Created by ldn on 2017/10/24.
 */
public interface EquipmentService extends BaseService<Equipment>{

    /**
     * 根据id字符串查询设备对象
     * @param equipmentId
     * @return
     */
    public Equipment findById_equipment(String equipmentId);

}
