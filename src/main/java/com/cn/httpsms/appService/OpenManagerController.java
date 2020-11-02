package com.cn.httpsms.appService;

import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.appService.ModeService.ProductMode;
import com.cn.httpsms.appService.ModeService.UserMode;
import com.cn.httpsms.service.UserOpenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import  com.cn.httpsms.common.SysCode;
import static com.cn.httpsms.util.HttpServletRequestToString.httpTool;

/**
 * Created by ldn on 2019/10/14.
 */

@Controller
@RequestMapping("/OpenService")
public class OpenManagerController {
    private static Logger logger = Logger.getLogger(OpenManagerController.class);

    @Autowired
    private UserOpenService userOpenService;

    @Autowired
    private UserMode userMode;

    @Autowired
    private ProductMode productMode;



    /** 用户注册
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/api_useropen_reg",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public JSONObject api_useropen_reg(HttpServletRequest request, HttpServletResponse response)
    {
        JSONObject json = JSONObject.parseObject(httpTool(request));

        String loginTag = json.getString("loginTag");//登陆id
        String userOpenPassWord = json.getString("userPassWord");//用户密码
        logger.info("================="+loginTag);
        logger.info("================="+userOpenPassWord);

        JSONObject return_login_json = new JSONObject();
        return_login_json.put("callbackCode","200");

        //调用平台用户注册的基础逻辑方法
        userMode.useropen_reg(loginTag,userOpenPassWord);

        return return_login_json;
    }


    /**
     * 用户登陆
     * @param
     * @param
     * @return
     * http://192.168.1.4:8080/admin/api_useropen_login
     */
    @RequestMapping(value = "/api_useropen_login",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    private JSONObject api_useropen_login(HttpServletRequest request, HttpServletResponse response){

        JSONObject json = JSONObject.parseObject(httpTool(request));
        //类型
        String loginTag = json.getString("loginTag");
        //设备id
        String userPassWord = json.getString("userPassWord");
        logger.info("================="+loginTag);
        logger.info("================="+userPassWord);

        return userMode.useropen_login(loginTag,userPassWord);
    }

    /**
     * 用户信息查询
     * @param
     * @param
     * @return
     * http://192.168.1.4:8080/admin/api_useropen_se
     */
    @RequestMapping(value = "/api_useropen_se",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    private JSONObject api_useropen_se(HttpServletRequest request, HttpServletResponse response){

        JSONObject json = JSONObject.parseObject(httpTool(request));
        //开放平台的用户ID
        String userOpenId = json.getString("userOpenId");
        logger.info("================="+userOpenId);
        return userMode.useropen_se(userOpenId);
    }


    /**
     * 创建用户专属产品
     * @param request
     * @param response
     * @return
     * /OpenService/api_productopen_reg
     * {"productOpenName":"呱唧温度计","productOpenDescription":"可以实时产看监测温度的5G物联网温度计","userOpenId":"40281f816dd429c4016dd429ce590000","productId":"40281f816daf8ab6016daf9761450001"}
     */
    @RequestMapping(value = "/api_productopen_reg",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    private JSONObject api_productopen_reg(HttpServletRequest request, HttpServletResponse response){

        JSONObject json = JSONObject.parseObject(httpTool(request));

        String productOpenName = json.getString("productOpenName");//产品名称
        String productOpenDescription = json.getString("productOpenDescription");//产品描述
        String userOpenId = json.getString("userOpenId");//开放平台用户ID
        String productId = json.getString("productId");//开放平台产品ID

        logger.info("================="+productOpenName);
        logger.info("================="+productOpenDescription);
        logger.info("================="+userOpenId);
        logger.info("================="+productId);

        return productMode.productopen_reg(productOpenName,productOpenDescription,userOpenId,productId);
    }

    /**
     * 获取平台产品列表（用户自定义的产品）
     *
     * /OpenService/api_productopen_list
     * {"callbackCode":"200","productOpenlist":[{"productOpenName":"呱唧温度大棚温度计","productOpenDescription":"一个物联网时代的智能温度计"},{"productOpenName":"呱唧室内温度计","productOpenDescription":"可以很好的监控室内温度"},{"productOpenName":"血糖仪","productOpenDescription":"让你活到99"}]}
     */

    //todo 根据用户ID 查询其下产品list

    //todo 根据产品ID查询产品信息

    //todo 根据产品ID修改产品信息

    //todo 根据产品ID删除产品



    //todo 根据用户ID和产品ID 新建添加设备

    //todo 根据用户ID和产品ID 查询设备list

    //todo 根据设备ID查询设备详情

    //todo 根据设备ID修改设备信息

    //todo 根据ID删除设备

    //todo 根据产品ID 批量设置设备属性

    //todo 根据设备ID 设置设备属性


}
