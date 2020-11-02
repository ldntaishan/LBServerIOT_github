package com.cn.httpsms.appService.ModeService;

import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.common.SysCode;
import com.cn.httpsms.entity.ProductOpen;
import com.cn.httpsms.service.ProductOpenService;
import com.cn.httpsms.util.StringEQ;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldn on 2019/10/22.
 */
@Controller
@RequestMapping("/OpenService")
public class ProductMode {

    private static Logger logger = Logger.getLogger(ProductMode.class);

    @Autowired
    private ProductOpenService productOpenService;

    // 创建产品
    public JSONObject productopen_reg(String productOpenName,String productOpenDescription,String userOpenId,String productId)
    {
        JSONObject return_json = new JSONObject();
        return_json.put("callbackCode", SysCode.SYS_ERROR_CODE);

        if(StringEQ.checkStringIsNull(productOpenName,userOpenId,productId))
        {
            ProductOpen po=new ProductOpen();
            po.setProductOpenName(productOpenName);
            po.setProductOpenDescription(productOpenDescription);
            po.setUserOpenId(userOpenId);
            po.setProductId(productId);
            productOpenService.insertProductOpen(po);
            return_json.put("callbackCode",SysCode.SUCCESS_CODE);
        }else
        {
            return_json.put("callbackCode",SysCode.user_login_tag_null_code);
        }

        return return_json;

    }


    //todo 获取平台产品模型list 方法
}
