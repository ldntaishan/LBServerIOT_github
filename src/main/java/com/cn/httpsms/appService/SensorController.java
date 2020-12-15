package com.cn.httpsms.appService;


import com.alibaba.fastjson.JSONArray;
import com.cn.httpsms.common.SysCode;
import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.service.EquipmentService;
import com.cn.httpsms.service.SensorService;
import com.cn.httpsms.util.StringEQ;
import org.apache.log4j.Logger;
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
     * @param allWarningId
     * @return
     */
    @RequestMapping("/crt_ss")
    @ResponseBody
    public String creart_sensor(
            String sensorDescription,
            String sensorType,
            String devNo,
            String equipmentId,
            String warningValue,
            String allWarningId
    )
    {
        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(sensorDescription,sensorType,devNo,equipmentId,warningValue,allWarningId))
        {
            Sensor ss = new Sensor();
            ss.setSensorDescription(sensorDescription);
            ss.setSensorType(sensorType);
            ss.setDevNo(devNo);
            ss.setEquipmentId(equipmentId);
            ss.setWarningValue(warningValue);
            ss.setAllWarningId(allWarningId);
            ss.setSysState("1");
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
                String eqmtSql = "select eqmt from Equipment eqmt where eqmt.equipmentId='" + list_sensor.get(i).getEquipmentId() + "'";
                List<Equipment> list = equipmentService.getResultList(eqmtSql);
                Equipment eqmt=list.get(0);
                list_sensor.get(i).setEquipmentName(eqmt.getEquipmentName());

                jsonarray_sensor.add(list_sensor.get(i));
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
