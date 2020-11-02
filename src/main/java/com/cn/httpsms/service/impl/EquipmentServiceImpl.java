package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ldn on 2017/10/24.
 */
@Service
@Transactional
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment> implements EquipmentService {

    /**
     * 根据id字符串查询设备对象
     * @param equipmentId
     * @return
     */
    @Override
    public Equipment findById_equipment(String equipmentId){
        return find(equipmentId);
    }

}