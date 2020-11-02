package com.cn.httpsms.controller;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20170620.PubRequest;
import com.aliyuncs.iot.model.v20170620.PubResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.utils.Base64Helper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * TestController
 *
 * @author liu.songgao
 *         create date: 2015-10-9 14:01
 *         description:TODO
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private static final String accessKey = "LTAI8bUW3SfreR9o";
    private static final String accessSecret = "Atqfkamiam2pyGYXatbeaJhL7ihwvT";

    private static final String productKey="EH9qYWD0Tt2";//产品KEY，相当于通道
    private static final String deviceName="test01";//设备名称
    public static DefaultAcsClient client;//一般用于发送消息到设备
    public static CloudAccount account;//用于接收设备发送的消息

    @RequestMapping("/t1")
    @ResponseBody
    public String t1(String msg,int qos) {

//        if (null==client) {
//
//            try {
//                DefaultProfile.addEndpoint("cn-shanghai", "cn-shanghai", "Iot", "iot.cn-shanghai.aliyuncs.com");
//                IClientProfile profile = DefaultProfile.getProfile("cn-shanghai", accessKey, accessSecret);
//                client = new DefaultAcsClient(profile); //初始化SDK客户端
//
//            } catch (ClientException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//
//
//
//        System.out.println("Hello World!");
////向 IOT 发布 PUB
//        try {
//            PubRequest pub = new PubRequest();
//            pub.setProductKey(productKey);
//            pub.setTopicFullName("/"+productKey+"/"+deviceName+"/"+"get"); //消息发送到的Topic全名.
//            pub.setMessageContent(Base64Helper.encode(msg,"UTF-8")); //hello world Base64 String.
//            pub.setQos(qos); //设置Qos为1的话，设备如果不在线，重新上线会收到离线消息，消息最多在IoT套件中保存7天.！！！！！！！！！！！！！！！！！！！！！！
//            PubResponse response = null;
//            response = client.getAcsResponse(pub);
//            System.out.println(response.getRequestId());
//            System.out.println(response.getSuccess());
//            System.out.println(response.getErrorMessage());
//            System.out.println(response.getMessageId());
//        } catch (ClientException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }



//RRPC 方式 向设备 发送（带回应）

//        try {
//            RRpcRequest rrpcRequest = new RRpcRequest();
//            rrpcRequest.setProductKey(productKey); //设备所属产品的Key
//            rrpcRequest.setDeviceName(deviceName); //设备名称
//            rrpcRequest.setRequestBase64Byte(Base64.encodeBase64String("{\"action\":\\unlock\\}".getBytes("UTF-8"))); //发给设备的数据，要求二进制数据做一次Base64编码
//            rrpcRequest.setTimeout(1000); //超时时间，单位毫秒，如果超过这个时间设备没反应则返回"TIMEOUT"
//            RRpcResponse rrpcResponse = null; //得到设备返回的数据信息
//            rrpcResponse = client.getAcsResponse(rrpcRequest);
//            System.out.println("返回消息Base64编码:"+rrpcResponse.getPayloadBase64Byte()); //得到的数据是设备返回二进制数据然后再经过Base64编码之后的字符串，需要转换一下才能拿到原始的二进制数据
//            System.out.println("返回转码后:"+ Base64Helper.decode(rrpcResponse.getPayloadBase64Byte(),"UTF-8"));//转码操作
//            System.out.println("返回的响应码:"+rrpcResponse.getRrpcCode()); //对应的响应码(UNKNOW/SUCCESS/TIMEOUT/OFFLINE/HALFCONN等)
//        } catch (ClientException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }


        return "zzzzzz";
    }



    @RequestMapping("/t2")
    public String t2() {
        return "frame";
    }


// SUB 订阅 MNS上的队列消息
//    @RequestMapping("/message")
//    @ResponseBody
//    public String message() {
////        HttpSession session, HttpServletRequest request, HttpServletResponse response
//        try {
//            account = new CloudAccount(
//                    accessKey,
//                    accessSecret,
//                    "https://1806007866898682.mns.cn-shanghai.aliyuncs.com/");
//            MNSClient client = account.getMNSClient();
//            CloudQueue queue = client.getQueueRef("aliyun-iot-hOrED1w5YeX"); //参数请输入IoT自动创建的队列名称，例如上面截图中的aliyun-iot-3AbL0062osF
//            while (true) {
//                // 获取消息
//                Message popMsg = queue.popMessage(10); //长轮询等待时间为10秒
//                if (popMsg != null) {
//
//                    try {System.out.println("PopMessage Body: "
//                            + popMsg.getMessageBodyAsRawString()); //获取原始消息
//                        String msg = Base64Helper.decode(popMsg.getMessageBodyAsRawString(),"UTF-8");
//                        System.out.println("json="+msg);
//                        JSONObject popJSON =new JSONObject(msg);
//                        String payload = Base64Helper.decode(popJSON.getString("payload"),"UTF-8");//收到的结果 转码后的结果 待处理
//                        System.out.println("payload="+payload);
//                        queue.deleteMessage(popMsg.getReceiptHandle()); //从队列中删除消息
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//
//
//                } else {
//                    System.out.println("Continuing");
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "error"+e.getMessage();
//        }



//    }

    /**
     * 获取天气预报
     * @return
     * getJSONArray()
    getJSONObject()
     */
//    @RequestMapping("/UserWeatherAPI")
//    @ResponseBody
//    public  String getUserWeatherInfoTest()
//    {
////        String host = "https://ali-weather.showapi.com";
////        String path = "/phone-post-code-weeather";
////        String method = "GET";
////        String appcode = "1a76bdade5c44799a1a2020d6cf4d3a2";
////        Map<String, String> headers = new HashMap<String, String>();
////        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
////        headers.put("Authorization", "APPCODE " + appcode);
////        Map<String, String> querys = new HashMap<String, String>();
////        querys.put("need3HourForcast", "0");
////        querys.put("needAlarm", "0");
////        querys.put("needHourData", "0");
////        querys.put("needIndex", "0");
////        querys.put("needMoreDay", "0");
////        querys.put("phone_code", "0312");
////        querys.put("post_code", "200000");
//
//        String host = "https://ali-weather.showapi.com";
//        String path = "/area-to-weather";
//        String method = "GET";
//        String appcode = "1a76bdade5c44799a1a2020d6cf4d3a2";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("area", "保定");
////        querys.put("areaid", "101291401");
//        querys.put("need3HourForcast", "0");
//        querys.put("needAlarm", "0");
//        querys.put("needHourData", "0");
//        querys.put("needIndex", "0");
//        querys.put("needMoreDay", "0");
//
//        String re="success";
//        try {
//            /**
//             * 重要提示如下:
//             * HttpUtils请从
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//             * 下载
//             *
//             * 相应的依赖请参照
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//             */
//            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
////            logger.info(EntityUtils.toString(response.getEntity()));
////            System.out.println(response.toString());
//            re=EntityUtils.toString(response.getEntity());
//            //获取response的body
//            //System.out.println(EntityUtils.toString(response.getEntity()));
//            JSONObject areaTSeather=new JSONObject(re);
//            JSONObject showapi_res_body =areaTSeather.getJSONObject("showapi_res_body");
//            JSONObject f1 =showapi_res_body.getJSONObject("f1");
//            String night_air_temperature =f1.getString("night_air_temperature");//晚上天气温度(摄氏度)
//            String day_air_temperature =f1.getString("day_air_temperature");//白天天气温度(摄氏度)
//            logger.info("晚上天气温度(摄氏度)"+night_air_temperature);
//            logger.info("白天天气温度(摄氏度)"+day_air_temperature);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return re;
//    }

//    //    获取用户已绑定设备信息列表接口
//    public String UserLogin()
//    {
//        return "";
//    }
//    //    通过 ip 邮编 城市名字段设置用户城市接口
//    public String UserLogin()
//    {
//        return "";
//    }
//    //    控制信息镜子关闭屏幕接口
//    public String UserLogin()
//    {
//        return "";
//    }
//    //    设置我的新闻类型接口
//    public String UserLogin()
//    {
//        return "";
//    }
//    //    设置我的提示接口
//    public String UserLogin()
//    {
//        return "";
//    }

}
