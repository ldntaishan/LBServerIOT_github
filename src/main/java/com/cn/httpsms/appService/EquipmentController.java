package com.cn.httpsms.appService;


import com.alibaba.fastjson.JSONArray;
import com.cn.httpsms.common.SysCode;
import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.service.EquipmentService;
import com.cn.httpsms.util.StringEQ;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
* Created by ldn on 2020/11/14.
* 设备控制接口层 类
* =========================================
*
*
*/

@Controller
@RequestMapping("/eqmt")
public class EquipmentController {
    private static Logger logger = Logger.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 新建设备
     * @param organization
     * @param equipmentName
     * @param equipmentType
     * @param equipmentNO
     * @return
     */

    @RequestMapping(value = "/crt_eqmt",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String creart_equipment(
            String organization,
            String equipmentName,
            String equipmentType,
            String equipmentNO,
            String sysState
    )
    {
        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(organization,equipmentName,equipmentType,equipmentNO))
        {
            Equipment eqmt = new Equipment();
            eqmt.setOrganization(organization);
            eqmt.setEquipmentName(equipmentName);
            eqmt.setEquipmentType(equipmentType);
            eqmt.setEquipmentNO(equipmentNO);
            eqmt.setSysState(sysState);
            eqmt.setCreatedate(new Date());
            equipmentService.insert(eqmt);
            return_json.put("callbackCode",SysCode.SUCCESS_CODE);
            return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
            return_json.put("equipmentId",eqmt.getEquipmentId());
        }else{
            return_json.put("callbackCode",SysCode.SYS_PARAMTER_CODE);
            return_json.put("callbackDetails",SysCode.SYS_PARAMTER_DESCRIPTION);
        }
        return return_json.toString();
    }

    /**
     * 根据id删除设备
     * @param equipmentId
     * @return
     * {"callbackCode":"200","callbackDetails":"成功"}
     */
    @RequestMapping(value = "/del_eqmt",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String del_eqmt(String equipmentId) {

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(equipmentId))
        {
            String eqmtSql = "select eqmt from Equipment eqmt where eqmt.equipmentId='" + equipmentId + "'";
            List<Equipment> list = equipmentService.getResultList(eqmtSql);
            if (list.size()!= 0) {
                equipmentService.del_eqmt(equipmentId);
                return_json.put("callbackCode",SysCode.SUCCESS_CODE);
                return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
            } else {
                return_json.put("callbackCode",SysCode.SYS_NULLID_CODE);
                return_json.put("callbackDetails",SysCode.SYS_NULLID_DESCRIPTION);
            }

        }else
        {
            return_json.put("callbackCode",SysCode.SYS_PARAMTER_CODE);
            return_json.put("callbackDetails",SysCode.SYS_PARAMTER_DESCRIPTION);
        }
        return return_json.toString();
    }

    /**
     * 根据id查询单个设备
     * @param equipmentId
     * @return
     * {
     * 	"Equipment": {
     * 		"organization": "新乡风电场",
     * 		"createdate": 1605355169000,
     * 		"equipmentName": "西南3号风力发电塔",
     * 		"sysState": "1",
     * 		"changedate": 1605355169000,
     * 		"equipmentNO": "1003",
     * 		"equipmentId": "4028098175c69fd90175c69fe55f0000",
     * 		"equipmentType": "EN2.1-110"
     *        },
     * 	"callbackCode": "200",
     * 	"callbackDetails": "成功"
     * }
     */
    @RequestMapping(value = "/f_eqmtobj",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String find_eqmt_obj(String equipmentId) {

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(equipmentId))
        {
            String eqmtSql = "select eqmt from Equipment eqmt where eqmt.equipmentId='" + equipmentId + "'";
            List<Equipment> list = equipmentService.getResultList(eqmtSql);
            if (list.size()!= 0) {
                Equipment eqmt=list.get(0);
                return_json.put("callbackCode",SysCode.SUCCESS_CODE);
                return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);

                logger.info("test msg=========="+eqmt.getEquipmentId());
                com.alibaba.fastjson.JSONObject eqmtJSONobj = new com.alibaba.fastjson.JSONObject();
                eqmtJSONobj.put("equipmentId", eqmt.getEquipmentId());
                eqmtJSONobj.put("organization",eqmt.getOrganization());
                eqmtJSONobj.put("equipmentName", eqmt.getEquipmentName());
                eqmtJSONobj.put("equipmentType",eqmt.getEquipmentType());
                eqmtJSONobj.put("equipmentNO", eqmt.getEquipmentNO());
                eqmtJSONobj.put("sysState", eqmt.getSysState());
                eqmtJSONobj.put("createdate", eqmt.getCreatedate());
                eqmtJSONobj.put("changedate", eqmt.getChangedate());

                return_json.put("Equipment",eqmtJSONobj);
            } else {
                return_json.put("callbackCode",SysCode.SYS_NULLID_CODE);
                return_json.put("callbackDetails",SysCode.SYS_NULLID_DESCRIPTION);
            }

        }else
        {
            return_json.put("callbackCode",SysCode.SYS_PARAMTER_CODE);
            return_json.put("callbackDetails",SysCode.SYS_PARAMTER_DESCRIPTION);
        }
        return return_json.toString();
    }

    /**
     * 查询设备列表
     * @param
     * @return
     * {
     * 	"callbackCode": "200",
     * 	"callbackDetails": "成功",
     * 	"callbackList": [{
     * 		"changedate": 1605358549000,
     * 		"createdate": 1605358549000,
     * 		"equipmentId": "4028098175c6d36e0175c6d37a1c0000",
     * 		"equipmentNO": "1004",
     * 		"equipmentName": "西南4号风力发电塔",
     * 		"equipmentType": "EN2.1-110",
     * 		"organization": "新乡风电场",
     * 		"sysState": "1"
     *        }, {
     * 		"changedate": 1605358529000,
     * 		"createdate": 1605358529000,
     * 		"equipmentId": "4028098175c6d31f0175c6d32a7f0000",
     * 		"equipmentNO": "1002",
     * 		"equipmentName": "西南2号风力发电塔",
     * 		"equipmentType": "EN2.1-110",
     * 		"organization": "新乡风电场",
     * 		"sysState": "1"
     *    }, {
     * 		"changedate": 1605358508000,
     * 		"createdate": 1605358508000,
     * 		"equipmentId": "4028098175c6d2cc0175c6d2d7a10000",
     * 		"equipmentNO": "1001",
     * 		"equipmentName": "西南1号风力发电塔",
     * 		"equipmentType": "EN2.1-110",
     * 		"organization": "新乡风电场",
     * 		"sysState": "1"
     *    }, {
     * 		"changedate": 1605358405000,
     * 		"createdate": 1605358405000,
     * 		"equipmentId": "4028098175c6d13a0175c6d146d20000",
     * 		"equipmentNO": "1003",
     * 		"equipmentName": "西南3号风力发电塔",
     * 		"equipmentType": "EN2.1-110",
     * 		"organization": "新乡风电场",
     * 		"sysState": "1"
     *    }]
     * }
     */
    @RequestMapping(value = "/f_eqmtlist",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String find_eqmt_list(String query) {

        com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(query);
        logger.info("=========获取设备列表========");
        logger.info("=========接受的参数为：========"+json.toJSONString());
        int pageSize=json.getInteger("limit");
        int pageNum=json.getInteger("page");
        String equipmentName=json.getString("equipmentName");

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        //查询设备列表
        List<Equipment> list_equipment=equipmentService.list_query_equipment(pageSize,pageNum,equipmentName);
        //equipmentName有值就count就返回查询条件的size，没有值就count全部数据：此形式是为了配合vue前端页面的逻辑
        long count;
        if(StringEQ.checkStringIsNull(equipmentName))
        {
            count=list_equipment.size();
        }else{
            count=equipmentService.list_count_equipment();
        }

        if(list_equipment.size()!=0)
        {
            com.alibaba.fastjson.JSONArray jsonarray_equipment=new JSONArray();
            for(int i=0;i<list_equipment.size();i++)
            {
                jsonarray_equipment.add(list_equipment.get(i));
            }
            return_json.put("callbackCode",SysCode.SUCCESS_CODE);
            return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
            return_json.put("callbackList",jsonarray_equipment);
            return_json.put("total",count);

        }else
        {
            return_json.put("callbackCode",SysCode.SYS_NULLLIST_CODE);
            return_json.put("callbackDetails",SysCode.SYS_NULLLIST_DESCRIPTION);
            return_json.put("callbackList","");

        }
        return return_json.toString();
    }

    public String list_equipment_index()
    {
        //todo 风塔名称 点位总数 报警数 停用数 掉线数 正常数
        return "";
    }

}
