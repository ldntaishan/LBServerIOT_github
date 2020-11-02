package com.cn.httpsms.adminService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.entity.Product;
import com.cn.httpsms.service.ProductService;
import com.cn.httpsms.service.UserBaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.cn.httpsms.util.HttpServletRequestToString.httpTool;

/**
 * 产品管理
 * Created by ldn on 2019/9/18.
 */

@Controller
@RequestMapping("/product")
public class ProductController {
    private static Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    ProductService productService;

//    @Autowired
//    CommonModule commonModule;

    /**
     * 创建平台产品
     *  http://192.168.1.4:8080/product/insertNewProduct
     * return：产品obj
     *
     产品名称
     产品型号
     厂商ID
     所属行业
     设备类型
     接入应用层协议类型
     产品图标ICO url地址
     产品简介
     电信IoT所需的 Profile文件
     电信IoT所需的 编解码插件文件
     从属主体（一个id）
     */
    @RequestMapping(value = "/insertNewProduct",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    private JSONObject insertNewProduct(HttpServletRequest request)
    {

        JSONObject json = JSONObject.parseObject(httpTool(request));
        logger.info("================="+json.toString());

        String userId=json.getString("userId");
        String productName=json.getString("productName");
        String productModel=json.getString("productModel");
        String productCTCCId=json.getString("productCTCCId");
        String productIndustryType=json.getString("productIndustryType");
        String productEquipmentType=json.getString("productEquipmentType");
        String connectProtocol=json.getString("connectProtocol");
        String productICOUrl=json.getString("productICOUrl");
        String productDescription=json.getString("productDescription");
        String productCTCCProfile=json.getString("productCTCCProfile");
        String productCTCCCodefile=json.getString("productCTCCCodefile");
        String parentId=json.getString("parentId");

        JSONObject return_login_json = new JSONObject();
        return_login_json.put("callbackCode","991");
        return_login_json.put("callbackDetails","系统错误");
        return_login_json.put("productId","");
        return_login_json.put("productName","");
//        //判断用户合法性
//        if ((new JSONObject(commonModule.eqAdminUser(userId))).getString("callbackCode").equals("200")) {
            Product pd=new Product();
            pd.setProductName(productName);
            pd.setProductModel(productModel);
            pd.setProductCTCCId(productCTCCId);
            pd.setProductIndustryType(productIndustryType);
            pd.setProductEquipmentType(productEquipmentType);
            pd.setConnectProtocol(connectProtocol);
            pd.setProductICOUrl(productICOUrl);
            pd.setProductDescription(productDescription);
            pd.setProductCTCCProfile(productCTCCProfile);
            pd.setProductCTCCCodefile(productCTCCCodefile);
            pd.setParentId(parentId);

            productService.insertProduct(pd);
            return_login_json.put("callbackCode","200");
            return_login_json.put("callbackDetails","创建产品成功");
            return_login_json.put("productId",pd.getParentId());
            return_login_json.put("productName",pd.getProductName());
//        }else{
//            return_login_json.put("callbackCode","301");
//            return_login_json.put("callbackDetails","用户验证为：非法-不存在");
//            return_login_json.put("productId","");
//            return_login_json.put("productName","");
//
//        }




        return return_login_json;
    }

    /**
     * 查询全部平台产品list
     * return：list列表
     * http://192.168.1.4:8080/product/listProduct
     */
    @RequestMapping(value = "/listProduct",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    private JSONObject listProduct(HttpServletRequest request) {

//        JSONObject json = JSONObject.parseObject(httpTool(request));
//        logger.info("================="+json.toString());

        logger.info("=========获取平台产列表========");
        JSONObject return_json = new JSONObject();
        return_json.put("callbackCode","991");
        return_json.put("callbackDetails","系统错误");

        //查询产品
        List<Product> list_product=productService.list_all_product();


        if(list_product.size()!=0)
        {
            JSONArray jsonarray_product=new JSONArray();
            for(int i=0;i<list_product.size();i++)
            {
//                JSONObject jsonObject_product=new JSONObject();
//                jsonObject_product.put("",list_product.get(i));
//                jsonObject_product.put("","");
//                jsonObject_product.put("","");
//                jsonObject_product.put("","");
                jsonarray_product.add(list_product.get(i));
            }
            return_json.put("callbackCode","200");
            return_json.put("callbackDetails","正常");
            return_json.put("callbackList",jsonarray_product);

        }else
        {
            return_json.put("callbackCode","201");
            return_json.put("callbackDetails","数据不存在");
            return_json.put("callbackList","");

        }
        return return_json;
    }

    /**
     * 根据 产品ID  查询单一产品详细
     * return：产品obj
     */

}
