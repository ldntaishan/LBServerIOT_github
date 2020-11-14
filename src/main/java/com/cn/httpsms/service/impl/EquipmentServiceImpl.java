package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.UserBase;
import com.cn.httpsms.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void del_eqmt(String equipmentId)
    {
        deleteById(equipmentId);
    }

    /**
     * 根据创建时间查询全部
     * //无条件查询前100条数据
     * @return
     */
    @Override
    public List<Equipment> list_all_equipment()
    {
        String list_all_equipment_Sql = "select eqmt from Equipment eqmt order by eqmt.createdate DESC";
        List<Equipment> list_equipment = getResultList(list_all_equipment_Sql);
        return list_equipment;
    }

}