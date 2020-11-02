package com.cn.httpsms.adminService;

import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.entity.UserBase;
import com.cn.httpsms.service.UserBaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.cn.httpsms.util.HttpServletRequestToString.httpTool;

/**
 * 运营管理系统API
 *
 * Created by ldn on 2019/9/18.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private UserBaseService userBaseService;


    /**
     * 用户登陆
     * @param
     * @param
     * @return
     * http://192.168.1.4:8080/admin/api_userlogin.do?loginTag=13426364664&userPassWord=123456
     */
    @RequestMapping(value = "/api_userlogin",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    private JSONObject receive(HttpServletRequest request, HttpServletResponse response){

        JSONObject json = JSONObject.parseObject(httpTool(request));
        //类型
        String loginTag = json.getString("loginTag");
        //设备id
        String userPassWord = json.getString("userPassWord");
        logger.info("================="+loginTag);
        logger.info("================="+userPassWord);

        JSONObject return_login_json = new JSONObject();
        return_login_json.put("callbackCode","999");
        return_login_json.put("userId","");
        return_login_json.put("userNickName","");
        return_login_json.put("token","gj201909191736");
        if(loginTag!=null&&userPassWord!=null)
        {
            if(!loginTag.equals("")&&!userPassWord.equals(""))
            {
                List<UserBase> list=userBaseService.userlogin(loginTag,userPassWord);

                if(list.size()==1)
                {
                    UserBase ub=list.get(0);
                    return_login_json.put("callbackCode","200");
                    return_login_json.put("userId",ub.getUserId());
                    return_login_json.put("userNickName",ub.getUserNickName());
                }else if(list.size()==0)
                {
                    return_login_json.put("callbackCode","301");

                }else if(list.size()>1)
                {
                    return_login_json.put("callbackCode","501");
                    //todo 查询到两个以上的用户，数据逻辑异常，需要处理
                }else
                {
                    return_login_json.put("callbackCode","991");
                }
            }else
            {
                return_login_json.put("callbackCode","299");
            }
        }else
        {
            return_login_json.put("callbackCode","298");
        }

        return return_login_json;
    }

    @RequestMapping(value = "/tta",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin
    public void  t1( HttpServletRequest request) {

//        String username= request.getParameter("username");
//        Integer age = Integer.parseInt(request.getParameter("age"));
//        String[] interests = request.getParameterValues("interests");
//        logger.info("=========t1========"+username);
//        String [] hobby=request.getParameterValues("hobby");
//        for(String temp:hobby){
//            System.out.println(temp);
//        }
//
//        Enumeration<String> es=request.getParameterNames();
//        while(es.hasMoreElements()){
//            es.nextElement();
//        }

        Map<String, String[]> map =request.getParameterMap();
        for(String key:map.keySet()){
            System.out.println(key);
            for(String str:map.get(key)){
                System.out.println(str);
            }
        }
//        JSONObject return_login_json = new JSONObject();
//        return_login_json.put("callbackCode","999");
//        return_login_json.put("userId","");
//        return_login_json.put("userNickName","");
//        return return_login_json;
    }

    /**
     * 初始化超级管理员方法
     * 注意：此方法内部使用，没有做用户重复判断，小心使用哦
     * @return
     * http://192.168.1.4:8080/admin/init_admin_user.do
     */
    @RequestMapping(value = "/init_admin_user",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public JSONObject  init_admin_user()
    {
        JSONObject return_login_json = new JSONObject();
        return_login_json.put("callbackCode","200");
        UserBase ub=new UserBase();
        ub.setUserTel("admin");
        ub.setUserPassWord("123456");
        ub.setUserName("GJ_admin");
        ub.setUserEmail("admin@163.com");
        ub.setUserNickName("呱唧超级管理员");
        ub.setUserRole("admin");
        ub.setUserState("1");
        userBaseService.insertUserBase(ub);

        return return_login_json;
    }


    //    @RequestMapping(value = "/api_userlogin",method = {RequestMethod.POST,RequestMethod.GET})
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject api_userlogin(HttpServletRequest request)throws ServletException, IOException {
//        String loginTag= request.getParameter("loginTag");
//        String userPassWord= request.getParameter("userPassWord");
//
//        logger.info("================="+loginTag);
//        logger.info("================="+userPassWord);
//        JSONObject return_login_json = new JSONObject();
//        return_login_json.put("callbackCode","999");
//        return_login_json.put("userId","");
//        return_login_json.put("userNickName","");
//        if(loginTag!=null&&userPassWord!=null)
//        {
//            if(!loginTag.equals("")&&!userPassWord.equals(""))
//            {
//                List<UserBase> list=userBaseService.userlogin(loginTag,userPassWord);
//
//                if(list.size()==1)
//                {
//                    UserBase ub=list.get(0);
//                    return_login_json.put("callbackCode","200");
//                    return_login_json.put("userId",ub.getUserId());
//                    return_login_json.put("userNickName",ub.getUserNickName());
//                }else if(list.size()==0)
//                {
//                    return_login_json.put("callbackCode","301");
//
//                }else if(list.size()>1)
//                {
//                    return_login_json.put("callbackCode","501");
//                    //todo 查询到两个以上的用户，数据逻辑异常，需要处理
//                }else
//                {
//                    return_login_json.put("callbackCode","991");
//                }
//            }else
//            {
//                return_login_json.put("callbackCode","299");
//            }
//        }else
//        {
//            return_login_json.put("callbackCode","298");
//        }
//        return return_login_json;
//    }




}
