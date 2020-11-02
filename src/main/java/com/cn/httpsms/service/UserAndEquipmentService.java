package com.cn.httpsms.service;

import com.cn.httpsms.entity.UserAndEquipment;

import java.util.List;

/**
 * Created by ldn on 2017/10/24.
 */

public interface UserAndEquipmentService extends BaseService<UserAndEquipment>{
    public String delOld_insertNew_UserAndEquipment(String userId,String equipmentId,String userAndEquipmentId);

    public  String insert_UserAndEquipment(String userId,String equipmentId);

    /**
     * 根据id字符串查询设备对象
     * @param equipmentId
     * @return
     */
    public List<UserAndEquipment> list_UserAndEquipment(String equipmentId);

}
