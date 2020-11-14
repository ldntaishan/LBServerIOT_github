package com.cn.httpsms.appService.ModeService;


import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.common.SysCode;
import com.cn.httpsms.entity.ProductOpen;
import com.cn.httpsms.entity.UserBase;
import com.cn.httpsms.entity.UserOpen;
import com.cn.httpsms.service.UserBaseService;
import com.cn.httpsms.service.UserOpenService;
import com.cn.httpsms.util.StringEQ;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ldn on 2019/10/16.
 */
@Controller
@RequestMapping("/OpenService")
public class UserMode {
    private static Logger logger = Logger.getLogger(UserMode.class);

    @Autowired
    private UserOpenService userOpenService;

    @Autowired
    private UserBaseService userBaseService;

    // 用户注册
    public void useropen_reg(String userOpenTel,String userOpenPassWord)
    {
        UserOpen uo=new UserOpen();
        uo.setUserOpenTel(userOpenTel);
        uo.setUserOpenPassWord(userOpenPassWord);
        userOpenService.insertUserOpen(uo);
    }

    //用户登陆
    public JSONObject useropen_login(String loginTag,String userPassWord)
    {

        JSONObject return_login_json = new JSONObject();
        return_login_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        return_login_json.put("userId","");
        return_login_json.put("userNickName","");
//        return_login_json.put("token","gj201909191736");
        if(StringEQ.checkStringIsNull(loginTag,userPassWord))
        {
                List<UserOpen> list_tel=userOpenService.userlogin_use_tel(loginTag,userPassWord);
                List<UserOpen> list_emal=userOpenService.userlogin_use_email(loginTag,userPassWord);

                if(list_tel.size()==1)
                {
                    UserOpen uo=list_tel.get(0);
                    return_login_json.put("callbackCode",SysCode.SUCCESS_CODE);
                    return_login_json.put("userId",uo.getUserOpenId());
                    return_login_json.put("userNickName",uo.getUserOpenNickName());
                }else if(list_emal.size()==1)
                {
                    UserOpen uo=list_emal.get(0);
                    return_login_json.put("callbackCode",SysCode.SUCCESS_CODE);
                    return_login_json.put("userId",uo.getUserOpenId());
                    return_login_json.put("userNickName",uo.getUserOpenNickName());

                }else if(list_tel.size()>1||list_emal.size()>1)
                {
                    return_login_json.put("callbackCode",SysCode.user_not_single_error);
                    //todo 查询到两个以上的用户，数据逻辑异常，需要处理
                }else
                {
                    return_login_json.put("callbackCode",SysCode.user_not_exist_code);
                }
        }else
        {
            return_login_json.put("callbackCode",SysCode.user_login_tag_null_code);
        }

        return return_login_json;
    }

    /**用户信息查询
     *
     * @param userOpenId
     * @return
     */
    public JSONObject useropen_se(String userOpenId)
    {
        JSONObject return_json = new JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);
        if(StringEQ.checkStringIsNull(userOpenId))
        {
            UserOpen userOpen=userOpenService.find(userOpenId);
            return_json.put("callbackCode", SysCode.SUCCESS_CODE);
            return_json.put("userOpen",userOpen);

        }else{
            return_json.put("callbackCode", SysCode.parameter_null_code);
        }
        return return_json;
    }
    //todo 用户信息修改

    //todo 用户合法性验证




}
