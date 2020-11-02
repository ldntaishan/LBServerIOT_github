package com.cn.httpsms.common;

/**
 * Created by ldn on 2019/10/14.
 */
public class SysCode {
    //系统通用编码
    public static String  SUCCESS_CODE="200";//通用交互成功标识
    public static String  SUCCESS_DESCRIPTION="成功";

    public static String  SYS_ERROR_CODE="999";//系统综合错误标识
    public static String  SYS_ERROR_DESCRIPTION="系统错误";

    //用户系统码
    public static String  user_not_exist_code="10001";//用户不存在
    public static String  user_not_exist_description="用户不存在";

    public static String  user_password_error="10002";//用户密码不正确
    public static String  user_password_description="用户密码不正确";

    public static String  user_not_single_error="10003";//查询到多个用户
    public static String  user_not_single_description="查到多个用户而异常";

    public static String  user_se_error="10099";//查询用户信息异常
    public static String  user_se_description="查询用户异常";

    /**
     * 用户登陆标识为空
     */
    public static String  user_login_tag_null_code="10004";
    public static String  user_login_tag_null_description="用户登陆标识为空";

    /**
     * 参数为空或""
     */
    public static String parameter_null_code="10005";




}
