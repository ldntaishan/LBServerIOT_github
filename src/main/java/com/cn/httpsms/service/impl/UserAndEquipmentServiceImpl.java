package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.UserAndEquipment;
import com.cn.httpsms.service.UserAndEquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ldn on 2017/10/24.
 */
@Service
@Transactional
public class UserAndEquipmentServiceImpl extends BaseServiceImpl<UserAndEquipment> implements UserAndEquipmentService {

    @Override
    public String delOld_insertNew_UserAndEquipment(String userId,String equipmentId,String userAndEquipmentId)
    {
        String fanhui="999";
        try {

            //删除原记录
            delete(find(userAndEquipmentId));

            //新写入用户与设备的绑定关系
            UserAndEquipment userAndEquipment=new UserAndEquipment();
            userAndEquipment.setUserId(userId);
            userAndEquipment.setEquipmentId(equipmentId);
            userAndEquipment.setCityBaseId("");
            insert(userAndEquipment);
            fanhui=userAndEquipment.getUserAndEquipmentId();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
        return fanhui;
    }
    @Override
    public  String insert_UserAndEquipment(String userId,String equipmentId)
    {
        String fanhui="999";
        try {

            //新写入用户与设备的绑定关系
            UserAndEquipment userAndEquipment=new UserAndEquipment();
            userAndEquipment.setUserId(userId);
            userAndEquipment.setEquipmentId(equipmentId);
            userAndEquipment.setCityBaseId("");
            insert(userAndEquipment);
            fanhui=userAndEquipment.getUserAndEquipmentId();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
        return fanhui;
    }

    /**
     * 根据设备id查询用户和设备的绑定关系对象的集合list
     * @param equipmentId
     * @return
     */
    @Override
    public List<UserAndEquipment> list_UserAndEquipment(String equipmentId)
    {
        String userAndEquipmentSql = "select uae from UserAndEquipment uae where uae.equipmentId='" + equipmentId + "'";
        List<UserAndEquipment> list_UserAndEquipment = getResultList(userAndEquipmentSql);
        return list_UserAndEquipment;
    }

}