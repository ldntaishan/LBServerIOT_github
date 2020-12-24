package com.cn.httpsms.appService;


import com.alibaba.fastjson.JSONArray;
import com.cn.httpsms.common.HttpUtils;
import com.cn.httpsms.common.SysCode;
import com.cn.httpsms.entity.Equipment;
import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.entity.SensorRealTime;
import com.cn.httpsms.service.EquipmentService;
import com.cn.httpsms.service.SensorRealTimeService;
import com.cn.httpsms.service.SensorService;
import com.cn.httpsms.util.StringEQ;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SensorRealTimeService sensorRealTimeService;


    /**
     * http://localhost:8080/LBServerIOT_war_exploded/ss/updatetime?v1=0&&v2=12.3
     * @param v1
     * @param v2
     * @return
     */
    @RequestMapping(value = "/updatetime",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String test_run_updatetime(String v1,String v2)  {

        List<SensorRealTime> list=sensorRealTimeService.list_all_sensorRealTime();
        for (int i=0;i<list.size();i++)
        {
            SensorRealTime ssrt=list.get(i);

            ssrt.setAbsoluteValue(Double.parseDouble(v1));
            ssrt.setNowTimeValue(Double.parseDouble(v2));
            ssrt.setUploadTime(new Date());
            sensorRealTimeService.update(ssrt);

        }
        return "更新成功";
    }

    /**
     * http://localhost:8080/LBServerIOT_war_exploded/ss/update_devNo?devNo=5161326731&&v1=0&&v2=12.3
     * @param v1
     * @param v2
     * @return
     */
    @RequestMapping(value = "/update_devNo",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String test_run_updatetime_devNO(String devNo,String v1,String v2)  {

        List<SensorRealTime> list=sensorRealTimeService.devNo_sensorRealTime(devNo);

            SensorRealTime ssrt=list.get(0);
            ssrt.setAbsoluteValue(Double.parseDouble(v1));
            ssrt.setNowTimeValue(Double.parseDouble(v2));
            ssrt.setUploadTime(new Date());
            sensorRealTimeService.update(ssrt);

        return "更新成功";
    }

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
            ss.setWarningValue(Double.parseDouble(warningValue));
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
     * 更新编辑设备
     * @param sensorType
     * @param devNo
     * @param equipmentId
     * @param warningValue
     * @return
     */
    @RequestMapping(value = "/update_ss",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String update_sensor(
            String equipmentId,
            String sensorDescription,
            String sensorType,
            String devNo,
            String warningValue,
            String sysState,
            String sensorId
    )
    {
        logger.info("=====编辑更新传感器=========");
        logger.info(equipmentId);
        logger.info(sensorDescription);
        logger.info(sensorType);
        logger.info(devNo);
        logger.info(warningValue);
        logger.info(sysState);
        logger.info(sensorId);

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        if(StringEQ.checkStringIsNull(equipmentId,sensorDescription,sensorType,devNo,warningValue,sysState,sensorId))
        {

            Sensor ss  = sensorService.findById_sensor(sensorId);
            ss.setEquipmentId(equipmentId);
            ss.setSensorDescription(sensorDescription);
            ss.setSensorType(sensorType);
            ss.setDevNo(devNo);
            ss.setWarningValue(Double.parseDouble(warningValue));
            ss.setSysState(sysState);
            sensorService.update_sensor(ss);
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
                //根据ID查风塔
                Equipment ep=equipmentService.findById_equipment(list_sensor.get(i).getEquipmentId());

                sensorJSONobj.put("sensorId",list_sensor.get(i).getSensorId());
                sensorJSONobj.put("sensorDescription",list_sensor.get(i).getSensorDescription());
                sensorJSONobj.put("sensorType",list_sensor.get(i).getSensorType());
                sensorJSONobj.put("devNo",list_sensor.get(i).getDevNo());
                sensorJSONobj.put("equipmentId",list_sensor.get(i).getEquipmentId());
                sensorJSONobj.put("warningValue",list_sensor.get(i).getWarningValue());
                sensorJSONobj.put("nowTimeValue",list_sensor.get(i).getNowTimeValue());
                sensorJSONobj.put("absoluteValue",list_sensor.get(i).getAbsoluteValue());
                sensorJSONobj.put("uploadTime",list_sensor.get(i).getUploadTime());
                sensorJSONobj.put("sysState",list_sensor.get(i).getSysState());
                sensorJSONobj.put("createdate",list_sensor.get(i).getCreatedate());
                sensorJSONobj.put("changedate",list_sensor.get(i).getChangedate());
                sensorJSONobj.put("equipmentName",ep.getEquipmentName());
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
     * 查询传感器监控列表
     * @param
     * @return
     *
     */
    @RequestMapping(value = "/list_monitoring",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String listMonitoring(String query) {

        com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(query);
        logger.info("=========获取实时监控列表========");
        logger.info("=========接受的参数为：========"+json.toJSONString());
        int pageSize=json.getInteger("limit");
        int pageNum=json.getInteger("page");
        String useState=json.getString("useState");
        String monitoringState=json.getString("monitoringState");

        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        //查询传感器列表
        List<Sensor> list_sensor=sensorService.list_monitoring_sensor(pageSize,pageNum,useState,monitoringState);
        long count=sensorService.list_count_monitoring_sensor(useState,monitoringState);
        if(list_sensor.size()!=0)
        {
            com.alibaba.fastjson.JSONArray jsonarray_sensor=new JSONArray();
            for(int i=0;i<list_sensor.size();i++)
            {
                //根据ID查风塔
                Equipment ep=equipmentService.findById_equipment(list_sensor.get(i).getEquipmentId());
                com.alibaba.fastjson.JSONObject sensorJSONobj = new com.alibaba.fastjson.JSONObject();
                sensorJSONobj.put("sensorId",list_sensor.get(i).getSensorId());
                sensorJSONobj.put("equipmentName",ep.getEquipmentName());
                sensorJSONobj.put("sensorDescription",list_sensor.get(i).getSensorDescription());
                sensorJSONobj.put("sensorType",list_sensor.get(i).getSensorType());
                sensorJSONobj.put("warningValue",list_sensor.get(i).getWarningValue());
                sensorJSONobj.put("absoluteValue",list_sensor.get(i).getAbsoluteValue());
                sensorJSONobj.put("uploadTime",list_sensor.get(i).getUploadTime());
                sensorJSONobj.put("useState",list_sensor.get(i).getUseState());
                sensorJSONobj.put("monitoringState",list_sensor.get(i).getMonitoringState());
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

    /**
     * 更新工作状态
     * @param sensorId
     * @param useState
     * @return
     *
     */
    @RequestMapping(value = "/update_useState",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String update_useState(String sensorId,String useState)
    {
        logger.info("=========获取实时监控列表========");
        logger.info("sensorId"+sensorId);
        logger.info("useState"+useState);
        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);
        if(StringEQ.checkStringIsNull(sensorId)&&StringEQ.checkStringIsNull(useState))
        {
            Sensor ss=sensorService.findById_sensor(sensorId);
            ss.setUseState(useState);
            sensorService.update_sensor(ss);
            return_json.put("callbackCode", SysCode.SUCCESS_CODE);
            return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
        }else
        {
            return_json.put("callbackCode", SysCode.SYS_PARAMTER_CODE);
            return_json.put("callbackDetails",SysCode.SYS_PARAMTER_DESCRIPTION);
        }
        return return_json.toString();

    }

    /**
     * http://localhost:8080/LBServerIOT_github_war_exploded/ss/index_sensor_number
     * 首页 获取各个统计数 方法
     * @return
     * {"allTotal":26,"disableTotal":11,"callbackCode":"200","alertTotal":4,"callbackDetails":"成功","offlineTotal":3,"normalTotal":9}
     */
    @RequestMapping(value = "/index_sensor_number",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String index_sensor_number()
    {
        logger.info("=========首页数据统计========");
        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        //点位总数
        long allTotal=sensorService.all_total();
        //报警数
        long alertTotal=sensorService.alert_total();
        //停用数
        long disableTotal=sensorService.disable_total();
        //掉线数
        long offlineTotal=sensorService.offline_total();
        //正常数
        long normalTotal=sensorService.normal_total();

        logger.info("点位总数:"+allTotal);
        logger.info("报警数:"+alertTotal);
        logger.info("停用数:"+disableTotal);
        logger.info("掉线数:"+offlineTotal);
        logger.info("正常数:"+normalTotal);

        return_json.put("callbackCode",SysCode.SUCCESS_CODE);
        return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
        return_json.put("allTotal",allTotal);
        return_json.put("alertTotal",alertTotal);
        return_json.put("disableTotal",disableTotal);
        return_json.put("offlineTotal",offlineTotal);
        return_json.put("normalTotal",normalTotal);
        return return_json.toString();
    }

    @RequestMapping(value = "/sensor_reset",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public String sensor_reset(String sensorId) throws Exception {

        logger.info("=========传感器重置！！========");
        logger.info("sensorId"+sensorId);
        com.alibaba.fastjson.JSONObject return_json = new com.alibaba.fastjson.JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_json.put("callbackDetails",SysCode.SYS_ERROR_DESCRIPTION);

        Sensor ss=sensorService.findById_sensor(sensorId);

        //todo 访问传感器重置接口
        //提交方式： http post提交
        //地址：http:// + <ServerIp:port> + /iotInterface/ resetAbsolute
        //参数：devNo 设备编码
        //请求的json范例：{"devNo":"5161326715"}
        //返回范例：
        //成功：{"success":0, "failureNum":null,"failureMessage":null}
        //失败：{"success":1, "failureNum":"1001","failureMessage":"设备掉线"}
        //{"success":1, "failureNum":"1002","failureMessage":"重置失败"}

//        String host = "https://http://39.106.55.120:8080";
//        String path = "/iotInterface/ resetAbsolute";
//        String method = "GET";
//
////        Map<String, String> headers = new HashMap<String, String>();
////        headers.put("Authorization", "APPCODE " + appcode);
//
//        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("devNo", ss.getDevNo());
//
//
//        HttpResponse response = HttpUtils.doGet(host, path, method, null, querys);
//        logger.info(response.getEntity().toString());
//        String re= EntityUtils.toString(response.getEntity());
        Double temp_absoluteValue=0.0;
        ss.setMonitoringState("initialize");
        ss.setAbsoluteValue(temp_absoluteValue);
        ss.setUploadTime(null);
        sensorService.update_sensor(ss);

        return_json.put("callbackCode", SysCode.SUCCESS_CODE);
        return_json.put("callbackDetails",SysCode.SUCCESS_DESCRIPTION);
        return_json.put("absoluteValue",ss.getAbsoluteValue());
        return_json.put("monitoringState",ss.getMonitoringState());
        return_json.put("uploadTime",ss.getUploadTime());

        return return_json.toString();
    }
}
