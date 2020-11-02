package com.cn.httpsms.adminService;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * Created by ldn on 2019/9/26.
 */
public class CommonModule {
    private static Logger logger = Logger.getLogger(CommonModule.class);

    /**
     * 根据用户ID判断其合法性模块
     */
    public JSONObject  eqAdminUser(String userId)
    {
        logger.info("INIT-->C:CommonModule__M:eqAdminUser__根据用户ID判断其合法性模块");
        //todo 编写判断用户合法性代码

        JSONObject return_login_json = new JSONObject();
        return_login_json.put("callbackCode","200");
        return return_login_json;
    }
}
