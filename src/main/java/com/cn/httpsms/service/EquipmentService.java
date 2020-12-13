package com.cn.httpsms.service;

import com.cn.httpsms.entity.Equipment;

import java.util.List;

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
    public void del_eqmt(String equipmentId);
    public List<Equipment> list_all_equipment();
    public List<Equipment> list_query_equipment(int pageSize,int pageNum,String equipmentName);
    public long list_count_equipment();

}
