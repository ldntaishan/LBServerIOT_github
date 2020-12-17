package com.cn.httpsms.appService;


import com.alibaba.fastjson.JSONArray;
import com.cn.httpsms.common.SysCode;
import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.service.EquipmentService;
import com.cn.httpsms.service.SensorService;
import com.cn.httpsms.util.StringEQ;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ldn on 2020/11/14.
 * 传感器控制接口层 类
 * =========================================
 *
 *
 */

@Controller
@RequestMapping("/ss")
public class SensorController {
    private static Logger logger = Logger.getLogger(SensorController.class);

    @Autowired
    private SensorService sensorService;

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 新建设备
     * @param sensorType
     * @param devNo
     * @param equipmentId
     * @param warningValue
     * @return
     */
    @RequestMapping(value = "/crt_ss",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String creart_sensor(
            String equipmentId,
            String sensorDescription,
            String sensorType,
            String devNo,
            String warningValue,
            String sysState
    )
    {
        logger.info("=====创建传感器=========");
        logger.info(equipmentId);
        logger.info(sensorDescription);
        logger.info(sensorType);
        logger.info(devNo);
        logger.info(warningValue);
        logger.info(sysState);

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(equipmentId,sensorDescription,sensorType,devNo,warningValue,sysState))
        {
            Sensor ss = new Sensor();
            ss.setEquipmentId(equipmentId);
            ss.setSensorDescription(sensorDescription);
            ss.setSensorType(sensorType);
            ss.setDevNo(devNo);
            ss.setWarningValue(warningValue);
            ss.setSysState(sysState);
            sensorService.insert(ss);
            return_json.put("callbackCode",SysCode.SUCCESS_CODE);
            return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
        }else{
            return_json.put("callbackCode",SysCode.SYS_PARAMTER_CODE);
            return_json.put("callbackDetails",SysCode.SYS_PARAMTER_DESCRIPTION);
        }
        return return_json.toString();
    }

    /**
     * 根据id删除传感器
     * @param sensorId
     * @return
     * {"callbackCode":"200","callbackDetails":"成功"}
     */
    @RequestMapping(value = "/del_ss",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String del_sensor(String sensorId) {

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(sensorId))
        {
            String ssSql = "select ss from Sensor ss where ss.sensorId='" + sensorId + "'";
            List<Sensor> list = sensorService.getResultList(ssSql);
            if (list.size()!= 0) {
                sensorService.del_ss(sensorId);
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
     * 根据id查询单个传感器
     * @param sensorId
     * @return
     *
     */
    @RequestMapping(value = "/f_ssobj",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String find_ss_obj(String sensorId) {

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(sensorId))
        {
            String ssSql = "select ss from Sensor ss where ss.sensorId='" + sensorId + "'";
            List<Sensor> list = sensorService.getResultList(ssSql);
            if (list.size()!= 0) {
                Sensor ss=list.get(0);
                return_json.put("callbackCode",SysCode.SUCCESS_CODE);
                return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
                return_json.put("Sonser",ss);
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
     * 查询传感器列表
     * @param
     * @return
     *
     */
    @RequestMapping(value = "/f_sslist",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String find_ss_list(String query) {

        com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(query);
        logger.info("=========获取传感器列表========");
        logger.info("=========接受的参数为：========"+json.toJSONString());
        int pageSize=json.getInteger("limit");
        int pageNum=json.getInteger("page");
        String equipmentName=json.getString("equipmentName");


        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        //查询传感器列表
        List<Sensor> list_sensor=sensorService.list_query_sensor(pageSize,pageNum,equipmentName);

        //userName有值就count就返回查询条件的size，没有值就count全部数据：此形式是为了配合vue前端页面的逻辑
        long count;
        if(StringEQ.checkStringIsNull(equipmentName))
        {
            count=list_sensor.size();
        }else{
            count=sensorService.list_count_sensor();
        }

        if(list_sensor.size()!=0)
        {
            com.alibaba.fastjson.JSONArray jsonarray_sensor=new JSONArray();
            for(int i=0;i<list_sensor.size();i++)
            {
                com.alibaba.fastjson.JSONObject sensorJSONobj = new com.alibaba.fastjson.JSONObject();
                sensorJSONobj.put("sensorId",list_sensor.get(i).getSensorId());
                sensorJSONobj.put("sensorDescription",list_sensor.get(i).getSensorDescription());
                sensorJSONobj.put("sensorType",list_sensor.get(i).getSensorType());
                sensorJSONobj.put("devNo",list_sensor.get(i).getDevNo());
                sensorJSONobj.put("equipmentId",list_sensor.get(i).getEquipmentId());
                sensorJSONobj.put("warningValue",list_sensor.get(i).getWarningValue());
                sensorJSONobj.put("allWarningId",list_sensor.get(i).getAllWarningId());
                sensorJSONobj.put("nowTimeValue",list_sensor.get(i).getNowTimeValue());
                sensorJSONobj.put("absoluteValue",list_sensor.get(i).getAbsoluteValue());
                sensorJSONobj.put("uploadTime",list_sensor.get(i).getUploadTime());
                sensorJSONobj.put("sysState",list_sensor.get(i).getSysState());
                sensorJSONobj.put("createdate",list_sensor.get(i).getCreatedate());
                sensorJSONobj.put("changedate",list_sensor.get(i).getChangedate());

                String eqmtSql = "select eqmt from Equipment eqmt where eqmt.equipmentId='" + list_sensor.get(i).getEquipmentId() + "'";
                List<Equipment> list = equipmentService.getResultList(eqmtSql);
                Equipment eqmt=list.get(0);
                sensorJSONobj.put("equipmentName",list.get(0).getEquipmentName());
                jsonarray_sensor.add(sensorJSONobj);
            }

            return_json.put("callbackCode",SysCode.SUCCESS_CODE);
            return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
            return_json.put("callbackList",jsonarray_sensor);
            return_json.put("total",count);

        }else
        {
            return_json.put("callbackCode",SysCode.SYS_NULLLIST_CODE);
            return_json.put("callbackDetails",SysCode.SYS_NULLLIST_DESCRIPTION);
            return_json.put("callbackList","");
        }
        logger.info(return_json.toString());
        return return_json.toString();
    }


    /**
     * 查询传感器列表
     * @param
     * @return
     *
     */
    @RequestMapping(value = "/f_sslisttest",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String find_ss_list_test(String query) {

        com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(query);
        logger.info("=========获取传感器列表========");
        logger.info("=========接受的参数为：========"+json.toJSONString());
        int pageSize=json.getInteger("limit");
        int pageNum=json.getInteger("page");
        String equipmentName=json.getString("equipmentName");


        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        //查询传感器列表
        List<Sensor> list_sensor=sensorService.list_query_sensor(pageSize,pageNum,equipmentName);

        //userName有值就count就返回查询条件的size，没有值就count全部数据：此形式是为了配合vue前端页面的逻辑
        long count;
        if(StringEQ.checkStringIsNull(equipmentName))
        {
            count=list_sensor.size();
        }else{
            count=sensorService.list_count_sensor();
        }

        if(list_sensor.size()!=0)
        {
            com.alibaba.fastjson.JSONArray jsonarray_sensor=new JSONArray();
            for(int i=0;i<list_sensor.size();i++)
            {
                com.alibaba.fastjson.JSONObject sensorJSONobj = new com.alibaba.fastjson.JSONObject();
                sensorJSONobj.put("sensorId",list_sensor.get(i).getSensorId());
                sensorJSONobj.put("sensorDescription",list_sensor.get(i).getSensorDescription());
                sensorJSONobj.put("sensorType",list_sensor.get(i).getSensorType());
                sensorJSONobj.put("devNo",list_sensor.get(i).getDevNo());
                sensorJSONobj.put("equipmentId",list_sensor.get(i).getEquipmentId());
                sensorJSONobj.put("warningValue",list_sensor.get(i).getWarningValue());
                sensorJSONobj.put("allWarningId",list_sensor.get(i).getAllWarningId());
                sensorJSONobj.put("nowTimeValue",list_sensor.get(i).getNowTimeValue());
                sensorJSONobj.put("absoluteValue",list_sensor.get(i).getAbsoluteValue());
                sensorJSONobj.put("uploadTime",list_sensor.get(i).getUploadTime());
                sensorJSONobj.put("sysState",list_sensor.get(i).getSysState());
                sensorJSONobj.put("createdate",list_sensor.get(i).getCreatedate());
                sensorJSONobj.put("changedate",list_sensor.get(i).getChangedate());

                String eqmtSql = "select eqmt from Equipment eqmt where eqmt.equipmentId='" + list_sensor.get(i).getEquipmentId() + "'";
                List<Equipment> list = equipmentService.getResultList(eqmtSql);
                Equipment eqmt=list.get(0);
                sensorJSONobj.put("equipmentName",list.get(0).getEquipmentName());
                jsonarray_sensor.add(sensorJSONobj);
            }
            return_json.put("callbackCode",SysCode.SUCCESS_CODE);
            return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
            return_json.put("callbackList",jsonarray_sensor);
            return_json.put("total",count);

        }else
        {
            return_json.put("callbackCode",SysCode.SYS_NULLLIST_CODE);
            return_json.put("callbackDetails",SysCode.SYS_NULLLIST_DESCRIPTION);
            return_json.put("callbackList","");
        }
        return return_json.toString();
    }
}
