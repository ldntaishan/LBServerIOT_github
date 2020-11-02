package com.cn.httpsms.appService;


//import com.cn.httpsms.EquipmentService.EquipmentMessageSend;
//import com.cn.httpsms.MemorandumService.MemorandumSendPubService;
import com.cn.httpsms.entity.*;
import com.cn.httpsms.service.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by ldn on 2017/10/24.
 *
 * =========================================
 * 用户注册  接口方法
 *
 */
@Controller
@RequestMapping("/app")
public class AppController {
    private static Logger logger = Logger.getLogger(AppController.class);


//    @Autowired
//    private UserBaseService userBaseService;
//    @Autowired
//    private UserAndEquipmentService userAndEquipmentService;
//    @Autowired
//    private EquipmentService equipmentService;
//
//    @Autowired
//    private CityBaseService cityBaseService;
//    @Autowired
//    private UserWeatherSetService userWeatherSetService;
//
//    @Autowired
//    UserMemorandumSetService userMemorandumSetService;
//
//    @Autowired
//    MemorandumSendPubService memorandumSendPubService;
//
//    @Autowired
//    private XtUploadService xtUploadService;
//
//
//
//    @Autowired
//    private EquipmentMessageSend equipmentMessageSend;



    @RequestMapping("/t1")
    @ResponseBody
    public String t1(String msg) throws UnsupportedEncodingException {
        logger.info("================="+msg);
        logger.info("================="+new String(msg.getBytes("iso-8859-1"),"utf-8"));
        return "apptest"+msg;
        }

//    /**
//     * 判断用户是否存方法
//     * 入参：userTel //用户的手机号
//     * 返回：
//     * RequestCode：0 可注册 1 已注册 2 空参数 默认 999 一些系统程序异常
//     * RequestMessage：“返回的文字说明”
//     */
//    @RequestMapping("/eqUserExist")
//    @ResponseBody
//    public String eqUserExist(String userTel,String RequestId) {
//        //调用记录访问行为 模块 后续完善 RequestId
//
//        JSONObject fanhuiJSONobj = new JSONObject();
//        if (!userTel.isEmpty()) {
//            String userSql = "select ub from UserBase ub where ub.userTel='" + userTel + "'";
//            List<UserBase> list = userBaseService.getResultList(userSql);
//            if (list.size() == 0) {
//                fanhuiJSONobj.put("RequestCode", 0);
//                fanhuiJSONobj.put("RequestMessage", "可注册");
//            } else {
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "此用户已经注册");
//            }
//        }
//        else{
//            fanhuiJSONobj.put("RequestCode", 2);
//            fanhuiJSONobj.put("RequestMessage", "空参数");
//        }
//        return fanhuiJSONobj.toString();
//    }
//
//    /**
//     * 手机号注册时获取验证码接口
//     * @return
//     */
//    @RequestMapping("/UserGetTelSecurityCode")
//    @ResponseBody
//    public String UserGetTelSecurityCode(String userTel,String RequestId)
//    {
//        //调用记录访问行为 模块 后续完善 RequestId
//        //调用三方接口 发送短信认证码 返回赋值
//        return "123456";
//    }
//
//    /**
//     * 用户注册接口
//     *
//     * @return
//     */
//    @RequestMapping("/UserSignin")
//    @ResponseBody
//    public String UserSignin(String userTel,String userPassWord,String securityCode,String RequestId)
//    {
//        //调用记录访问行为 模块 后续完善 RequestId
//
//        //数据校验
//        //判断是否为空
//        //判断是否为电话号码
//        //判断userPassWord的 min max长度合规
//        //数据校验的工作以由阿里云API网关完成，下面直接完成业务
//
//        JSONObject fanhuiJSONobj = new JSONObject();
//        fanhuiJSONobj.put("RequestCode", 999);
//        fanhuiJSONobj.put("RequestMessage", "注册失败，系统出错啦");
//        if(!userTel.isEmpty()&&!userPassWord.isEmpty()) {
//            JSONObject eqUserExistJSONobj = new JSONObject(eqUserExist(userTel, "localRequst"));
//            if (eqUserExistJSONobj.getInt("RequestCode") == 0) {
//
//                if (securityCode.equals("123456")) {
//                    UserBase ub = new UserBase();
//                    ub.setUserPassWord(userPassWord);
//                    ub.setUserTel(userTel);
////        ub.setUserName(userName);
////        ub.setUserEmail(userEmail);
////        ub.setUserNickName(userNickName);
//                    ub.setUserState("1");
////                    ub.setUserLoginState("0");
//                    ub.setChangedate(new Date());
//                    userBaseService.insert(ub);
//                    fanhuiJSONobj.put("RequestCode", 0);
//                    fanhuiJSONobj.put("RequestMessage", "注册成功");
//                } else {
//                    fanhuiJSONobj.put("RequestCode", 3);
//                    fanhuiJSONobj.put("RequestMessage", "无效验证码");
//                }
//            } else {
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "此用户已经注册");
//            }
//        }else{
//            fanhuiJSONobj.put("RequestCode", 2);
//            fanhuiJSONobj.put("RequestMessage", "空参数");
//        }
//        return fanhuiJSONobj.toString();
//    }
//    /**
//     * 用户手机号登陆
//     * @param userTel
//     * @param userPassWord
//     * @return
//     * id
//     * 绑定的设备
//     * 设备名称
//     * 设备型号
//
//    {
//        "RequestCode": 0,
//        "RequestMessage": "登陆成功",
//        "userBase":
//        {
//            "userId": "hgjghjgfhjghj",
//            "userTel": "13426364664",
//            "userName": "lzw_ssnt"
//        },
//        "UserAndEquipment": [
//        {
//            "userAndEquipmentId":"sdfsdgfsdgdsgfasdfas",
//            "Equipment":
//            {
//                "equipmentId": "fdsadfdsdfsdfsd",
//                "equipmentName": "shebei1",
//                "equipmentType": "1",
//                "equipmentSN": "100023",
//            },
//            "cityBase":
//            {
//                "cityBaseId": "ghfghfghsdfgsdfgs",
//                "cityName": "北京"
//            }
//        }.]
//
//    }
//     *
//     */
//    @RequestMapping("/loginTel")
//    @ResponseBody
//    public String loginTel(String userTel,String userPassWord,String RequestId)
//    {
//        //调用记录访问行为 模块 后续完善 RequestId
//
//        JSONObject fanhuiJSONobj = new JSONObject();
//        fanhuiJSONobj.put("RequestCode", 999);
//        fanhuiJSONobj.put("RequestMessage", "登陆失败，系统出错啦");
//        //数据校验
//        //判断是否为空
//        //判断是否为电话号码
//        //判断userPassWord的 min max长度合规
//        //数据校验的工作以由阿里云API网关完成，下面直接完成业务
//        if(!userTel.isEmpty()&&!userPassWord.isEmpty()) {
//            String userSql = "select ub from UserBase ub where ub.userTel='" + userTel + "' and ub.userPassWord='" + userPassWord + "'";
//            List<UserBase> list = userBaseService.getResultList(userSql);
//            if(list.size()!=0)
//            {
//                UserBase ub=list.get(0);
//                ub.setLastLoginTime(new Date());
//                //更新用户最后一次登陆时间 无论返回何种结果，都会更新，代表了用户最后的访问时间
//                userBaseService.updateUserBase(ub);
//
//                fanhuiJSONobj.put("RequestCode", 0);
//                fanhuiJSONobj.put("RequestMessage", "登陆成功");
//
//                JSONObject userJSONobj = new JSONObject();
//                userJSONobj.put("userId", ub.getUserId());
//                userJSONobj.put("userPassWord",ub.getUserPassWord());
//                userJSONobj.put("userTel", ub.getUserTel());
//                userJSONobj.put("userNickName", ub.getUserNickName());
//                userJSONobj.put("userEmail", ub.getUserEmail());
//                userJSONobj.put("userName", ub.getUserName());
//                userJSONobj.put("userState", ub.getUserState());
//
//                fanhuiJSONobj.put("UserBase",userJSONobj);
//
//                //查询用户绑定设备表
//                String userAndEquipmentSql = "select uae from UserAndEquipment uae where uae.userId='" + ub.getUserId() + "'";
//                List<UserAndEquipment> listuae = userAndEquipmentService.getResultList(userAndEquipmentSql);
//                JSONArray listjson=new JSONArray();
//                if(listuae.size()!=0) {
//
//                    for (int i=0;i<listuae.size();i++) {
//                        UserAndEquipment uae = listuae.get(i);
//                        JSONObject userAndEquipmentJSONobj = new JSONObject();
//                        userAndEquipmentJSONobj.put("userAndEquipmentId",uae.getUserAndEquipmentId());
//                        //todo uae.getEquipmentId().isEmpty()这种判断为空 好像不对，有待查证
//                        if (!uae.getEquipmentId().isEmpty()) {
//                            //获取设备详情信息
//                            Equipment em = equipmentService.find(uae.getEquipmentId());
//
//                            JSONObject equipmentJSONobj = new JSONObject();
//                            equipmentJSONobj.put("equipmentId", em.getEquipmentId());
//                            equipmentJSONobj.put("equipmentName", em.getEquipmentName());
//                            equipmentJSONobj.put("equipmentType", em.getEquipmentType());
//                            equipmentJSONobj.put("equipmentSN", em.getEquipmentSN());
//                            userAndEquipmentJSONobj.put("Equipment",equipmentJSONobj);
//                        }
//                        //todo uae.getEquipmentId().isEmpty()这种判断为空 好像不对，有待查证
//                        if (!uae.getCityBaseId().isEmpty()) {
//                            //获取城市详情信息
//                            CityBase cb = cityBaseService.find(uae.getCityBaseId());
//                            JSONObject citytJSONobj = new JSONObject();
//                            citytJSONobj.put("cityBaseId", cb.getCityBaseId());
//                            citytJSONobj.put("cityName", cb.getCityName());
//                            userAndEquipmentJSONobj.put("CityBase",citytJSONobj);
//                        }
//                        List<UserMemorandumSet> listums=userMemorandumSetService.list_UserMemorandumSet(uae.getUserAndEquipmentId());
//                        if (listums.size()!=0)
//                        {
//                            //有记录 更新内容与状态
//                            UserMemorandumSet userMemorandumSet=listums.get(0);
//                            //备忘录
//                            JSONObject userMemorandumSetJSON =new JSONObject();
//                            userMemorandumSetJSON.put("memorandumSetId",userMemorandumSet.getUserMemorandumSetId());
//                            userMemorandumSetJSON.put("contentStr",userMemorandumSet.getContentStr());
//                            userMemorandumSetJSON.put("content_control_YN",userMemorandumSet.getContent_control_YN());
//                            userAndEquipmentJSONobj.put("UserMemorandumSet", userMemorandumSetJSON);
//
//                        }
//                        listjson.put(userAndEquipmentJSONobj);
//                    }
//                }
//                fanhuiJSONobj.put("UserAndEquipment",listjson);
//            }else{
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "用户名或密码错误");
//            }
//        }else{
//            fanhuiJSONobj.put("RequestCode", 2);
//            fanhuiJSONobj.put("RequestMessage", "用户名或密码为空");
//        }
//        return fanhuiJSONobj.toString();
//    }
//
////    /**
////     * 验证用户登陆是否有效
////     * @return
////     */
////    @RequestMapping("/userLoginYZ")
////    @ResponseBody
////    public String userLoginYZ(String userId)
////    {
////        JSONObject fanhuiJSONobj = new JSONObject();
////        if(!userId.isEmpty()) {
////            UserBase ub=userBaseService.find(userId);
////            if(!ub.getUserId().isEmpty())
////            {
////                if(ub.getUserLoginState().equals("0"))
////                {
////                    fanhuiJSONobj.put("RequestCode", 0);
////                    fanhuiJSONobj.put("RequestMessage", "有效登陆");
////                }else
////                {
////                    fanhuiJSONobj.put("RequestCode", 1);
////                    fanhuiJSONobj.put("RequestMessage", "无效登陆");
////                }
////
////            }
////            else{
////                fanhuiJSONobj.put("RequestCode", 2);
////                fanhuiJSONobj.put("RequestMessage", "查无此户");
////            }
////        }else{
////            fanhuiJSONobj.put("RequestCode", 3);
////            fanhuiJSONobj.put("RequestMessage", "参数为空");
////        }
////        return fanhuiJSONobj.toString();
////    }
//
//
//    /**
//     * 用户和设备绑定接口
//     * @return
//     *
//     *
//    {
//    "RequestCode": 0,
//    "RequestMessage": "绑定成功",
//    "UserAndEquipment": [
//    {
//    "userAndEquipmentId":"2c91e1c95f966741015fa41660130011",
//    "Equipment":
//    {
//    "equipmentId": "2c91e1c95f966741015fa41660130006",
//    "equipmentName": "线上测试设备02",
//    "equipmentType": "ST002",
//    "equipmentSN": "201711101200",
//    }
//    }]
//    }
//     */
//    @RequestMapping("/UserAndEquipmentObj")
//    @ResponseBody
//    public String UserAndEquipmentObj(String userId,String equipmentId,String RequestId)
//    {
//        JSONObject fanhuiJSONobj = new JSONObject();
//        if(!userId.isEmpty()&&!equipmentId.isEmpty())
//        {
//            UserBase ub=userBaseService.find(userId);
//            Equipment em=equipmentService.find(equipmentId);
//            if(null!=ub&&null!=em)
//            {
//                String userAndEquipmentSql = "select uae from UserAndEquipment uae where uae.equipmentId='" + em.getEquipmentId() + "'";
//                List<UserAndEquipment> listuae = userAndEquipmentService.getResultList(userAndEquipmentSql);
//                if(listuae.size()!=0)
//                {
//                UserAndEquipment userAndEquipment=listuae.get(0);
//                    if(!ub.getUserId().equals(userAndEquipment.getUserId())){ //判断是否是同一个用户
//
//                        try {
//                            //删除原openID下的定制的天气预报业务 和 备忘录业务
//                            //此两个删除方法中有逻辑判断，如果查到对象就删，如果查不到不做动作，保证了不异常
//                            userWeatherSetService.delUserWeatherSet(userAndEquipment.getUserAndEquipmentId());
//                            userMemorandumSetService.delUserMemorandumSet(userAndEquipment.getUserAndEquipmentId());
//
//                            //删除原用户和设备的绑定关系并新写入现用户和设备关系。 openid 只能保证设备和用户的绑定时ID的唯一性。多人相互顶绑设备将重新或得openid
//                            String userAndEquipmentId_new =userAndEquipmentService.delOld_insertNew_UserAndEquipment(ub.getUserId(),em.getEquipmentId(),userAndEquipment.getUserAndEquipmentId());
//                            if(!"999".equals(userAndEquipmentId_new))
//                            {
//                                fanhuiJSONobj.put("RequestCode", 0);
//                                fanhuiJSONobj.put("RequestMessage", "绑定成功");
//                                JSONArray listjson=new JSONArray();
//                                //设置 用户绑定设备下的一个设备
//                                JSONObject userAndEquipmentJSONobj = new JSONObject();
//                                userAndEquipmentJSONobj.put("userAndEquipmentId",userAndEquipmentId_new);
//                                JSONObject equipmentJSONobj = new JSONObject();
//                                equipmentJSONobj.put("equipmentId", em.getEquipmentId());
//                                equipmentJSONobj.put("equipmentName", em.getEquipmentName());
//                                equipmentJSONobj.put("equipmentType", em.getEquipmentType());
//                                equipmentJSONobj.put("equipmentSN", em.getEquipmentSN());
//                                userAndEquipmentJSONobj.put("Equipment",equipmentJSONobj);
//                                listjson.put(userAndEquipmentJSONobj);
//
//                                fanhuiJSONobj.put("UserAndEquipment",listjson);
//                                //绑定完成立即向设备推送消息
//                                equipmentMessageSend.sendOperationMessage(em.getEquipmentId());
//                            }
//                            else{
//                                fanhuiJSONobj.put("RequestCode", 5);
//                                fanhuiJSONobj.put("RequestMessage", "顶绑设备失败");
//                            }
//                        }catch (Exception e)
//                        {
//                            e.printStackTrace();
//                            fanhuiJSONobj.put("RequestCode", 6);
//                            fanhuiJSONobj.put("RequestMessage", "顶绑设备综合过程异常");
//                        }
//                    }
//                    else
//                    {
//                        fanhuiJSONobj.put("RequestCode", 4);
//                        fanhuiJSONobj.put("RequestMessage", "此用户已经绑定了本设备");
//                    }
//                }
//                else
//                {
//                    //此设备从来没有被绑定过，新绑定
//                    String userAndEquipmentId_new=userAndEquipmentService.insert_UserAndEquipment(ub.getUserId(),em.getEquipmentId());
//                    if(!"999".equals(userAndEquipmentId_new))
//                    {
//                        fanhuiJSONobj.put("RequestCode", 0);
//                        fanhuiJSONobj.put("RequestMessage", "绑定成功");
//
//                        JSONArray listjson=new JSONArray();
//                        //设置 用户绑定设备下的一个设备
//                        JSONObject userAndEquipmentJSONobj = new JSONObject();
//                        userAndEquipmentJSONobj.put("userAndEquipmentId",userAndEquipmentId_new);
//                        JSONObject equipmentJSONobj = new JSONObject();
//                        equipmentJSONobj.put("equipmentId", em.getEquipmentId());
//                        equipmentJSONobj.put("equipmentName", em.getEquipmentName());
//                        equipmentJSONobj.put("equipmentType", em.getEquipmentType());
//                        equipmentJSONobj.put("equipmentSN", em.getEquipmentSN());
//                        userAndEquipmentJSONobj.put("Equipment",equipmentJSONobj);
//                        listjson.put(userAndEquipmentJSONobj);
//
//                        fanhuiJSONobj.put("UserAndEquipment",listjson);
//                        //绑定完成立即向设备推送消息
//                        equipmentMessageSend.sendOperationMessage(em.getEquipmentId());
//                    }
//                    else{
//                        fanhuiJSONobj.put("RequestCode", 7);
//                        fanhuiJSONobj.put("RequestMessage", "用户绑定设备过程异常");
//                    }
//                }
//
//            }else
//            {
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "用户或设备不存在");
//            }
//
//        }else
//        {
//            fanhuiJSONobj.put("RequestCode", 2);
//            fanhuiJSONobj.put("RequestMessage", "参数为空");
//        }
//        return fanhuiJSONobj.toString();
//    }
//
//    /**
//     * 城市搜索
//     * @param citySEIndexString
//     * @return
//     */
//    @RequestMapping("/seCity")
//    @ResponseBody
//    public String seCity(String citySEIndexString,String RequestId)
//    {
//        JSONArray ja=new JSONArray();
//        String CityBaseSql = "select c from CityBase c where c.citySEIndexString='" + citySEIndexString + "'";
////        ja = cityBaseService.getResultList(CityBaseSql);
//        return "";
//    }
//
//    /**
//     * 用户设置城市
//     * @return
//     */
//    @RequestMapping("/setCity")
//    @ResponseBody
//    public String setCity(String userId,String cityBaseId,String userAndEquipmentId,String RequestId)
//    {
//        JSONObject fanhuiJSONobj = new JSONObject();
//        logger.info("$$$$$$$$$$$$$$$$$userId$$$$$$$$$$$$$$$$"+userId);
//        logger.info("$$$$$$$$$$$$$$$$$cityBaseId$$$$$$$$$$$$$$$$"+cityBaseId);
//        logger.info("$$$$$$$$$$$$$$$$$$userAndEquipmentId$$$$$$$$$$$$$$$"+userAndEquipmentId);
//        logger.info("$$$$$$$$$$$$$$$$$RequestId$$$$$$$$$$$$$$$$"+RequestId);
//
//        String cityBaseSql = "select cityBase from CityBase cityBase where cityBase.cityAreaId='" + cityBaseId + "'";
//        List<CityBase> cityBaseList = cityBaseService.getResultList(cityBaseSql);
//        if(cityBaseList.size()!=0)
//        {
//            CityBase cb=cityBaseList.get(0);
//            UserAndEquipment ue=userAndEquipmentService.find(userAndEquipmentId);
//            if(null!=ue)
//            {
//                ue.setCityBaseId(cb.getCityBaseId());
//                userAndEquipmentService.update(ue);
//
//                //定制天气信息
//                JSONObject userWeatherSetObj_json=userWeatherSetObjPrivate(ue.getUserAndEquipmentId());
//                if(0!=userWeatherSetObj_json.length())
//                {
//                    if(0==userWeatherSetObj_json.getInt("RequestCode")||1==userWeatherSetObj_json.getInt("RequestCode"))
//                    {
//                        fanhuiJSONobj.put("RequestCode", 0);
//                        fanhuiJSONobj.put("RequestMessage", "设置成功");
//
//                        JSONObject cityBaseJSON =new JSONObject();
//                        cityBaseJSON.put("cityBaseId",cb.getCityBaseId());
//                        cityBaseJSON.put("cityName",cb.getCityName());
//                        fanhuiJSONobj.put("CityBase", cityBaseJSON);
//                    }
//                    else{
//                        fanhuiJSONobj.put("RequestCode",4);
//                        fanhuiJSONobj.put("RequestMessage", "定制天气信息失败");
//                    }
//                }
//                else{
//                    fanhuiJSONobj.put("RequestCode", 3);
//                    fanhuiJSONobj.put("RequestMessage", "定制天气信息失败,返回信息为空");//城市设置成功但是天气信息定制失败
//                }
//            }else{
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "未绑定设备");
//            }
//        }
//        else
//        {
//            fanhuiJSONobj.put("RequestCode", 5);
//            fanhuiJSONobj.put("RequestMessage", "城市不存");
//        }
////
//
//        return fanhuiJSONobj.toString();
//    }
//
//
//    /**
//     * 用户定制天气信息 内部调用
//     * @return
//     */
//
//    public JSONObject userWeatherSetObjPrivate(String userAndEquipmentId)
//    {
//        JSONObject fanhuiJSONobj = new JSONObject();
//
//            UserAndEquipment ue=userAndEquipmentService.find(userAndEquipmentId);
//
////            UserBase ub=userBaseService.find(ue.getUserId());
//            Equipment ep=equipmentService.find(ue.getEquipmentId());
//            CityBase cb=cityBaseService.find(ue.getCityBaseId());
//
//            String userWeatherSetSql = "select uw from UserWeatherSet uw where uw.userAndEquipmentId='" + ue.getUserAndEquipmentId() + "'";
//            List<UserWeatherSet> userWeatherSet_list = userWeatherSetService.getResultList(userWeatherSetSql);
//            if(userWeatherSet_list.size()!=0)
//            {
//                UserWeatherSet userWeatherSet=userWeatherSet_list.get(0);
////                userWeatherSet.setUserAndEquipmentId(ue.getUserAndEquipmentId());
////                userWeatherSet.setEquipmentId(ep.getEquipmentId());
////                userWeatherSet.setProductName(ep.getProductName());
////                userWeatherSet.setAliyunIotProductKey(ep.getProductKey());
////                userWeatherSet.setEquipmentName(ep.getEquipmentName());
////                userWeatherSet.setAliyunIotDeviceName(ep.getDeviceName());
//                userWeatherSet.setPostcode(cb.getPostcode());
//                userWeatherSet.setTelAreaCode(cb.getTelAreaCode());
//                userWeatherSet.setCityName(cb.getCityName());
////                userWeatherSet.setPubRegulation("1");
//                userWeatherSet.setNowPubMessage("1");//设置为 1 会按照系统推送规则下向用户推送消息
//                userWeatherSet.setChangedate(new Date());
////                userWeatherSet.setLastPubTime(new Date());
//                userWeatherSetService.updateUserWeatherSet(userWeatherSet);
//                fanhuiJSONobj.put("RequestCode", 0);
//                fanhuiJSONobj.put("RequestMessage", "更新定制成功");
//                //更新定制后，为用户推送一次天气
//
//
//            }else
//            {
//                UserWeatherSet userWeatherSet=new UserWeatherSet();
//                userWeatherSet.setUserAndEquipmentId(ue.getUserAndEquipmentId());
//                userWeatherSet.setEquipmentId(ep.getEquipmentId());
//                userWeatherSet.setProductName(ep.getProductName());
//                userWeatherSet.setAliyunIotProductKey(ep.getProductKey());
//                userWeatherSet.setEquipmentName(ep.getEquipmentName());
//                userWeatherSet.setAliyunIotDeviceName(ep.getDeviceName());
//                userWeatherSet.setPostcode(cb.getPostcode());
//                userWeatherSet.setTelAreaCode(cb.getTelAreaCode());
//                userWeatherSet.setCityName(cb.getCityName());
//                userWeatherSet.setPubRegulation("1");
//                userWeatherSet.setNowPubMessage("1");//设置为 1 会按照系统推送规则下向用户推送消息
//                userWeatherSet.setLastPubTime(new Date());
//                userWeatherSetService.updateUserWeatherSet(userWeatherSet);
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "新定制成功");
//                //更新定制后，为用户推送一次天气
//
//            }
//
//
//        return fanhuiJSONobj;
//    }
//
//    /**
//     * 用户定制备忘录业务--创建/更新备忘录内容
//     * @return
//     */
//    @RequestMapping("/setMemorandum")
//    @ResponseBody
//    public String setMemorandum(String userId,String userAndEquipmentId,String contentStr,String content_control_YN, String RequestId)
//    {
//        logger.info("========调用定制备忘录接口=========");
//        logger.info("userId:"+userId);
//        logger.info("userAndEquipmentId:"+userAndEquipmentId);
//        logger.info("RequestId:"+RequestId);
//        logger.info("contentStr:"+contentStr);
//        logger.info("===================================");
//        JSONObject fanhuiJSONobj = new JSONObject();
//
//        UserAndEquipment userAndEquipment=userAndEquipmentService.find(userAndEquipmentId);
//        if(null!=userAndEquipment)
//        {
//            Equipment equipment=equipmentService.find(userAndEquipment.getEquipmentId());
//            //查询备忘录定制表 是否有记录
//            List<UserMemorandumSet> list=userMemorandumSetService.list_UserMemorandumSet(userAndEquipment.getUserAndEquipmentId());
//            if (list.size()!=0)
//            {
//                //有记录 更新内容与状态
//                UserMemorandumSet userMemorandumSet=list.get(0);
//
////                userMemorandumSet.setUserAndEquipmentId(userAndEquipment.getUserAndEquipmentId());
////                userMemorandumSet.setProductId(equipment.getProductId());
////                userMemorandumSet.setEquipmentId(equipment.getEquipmentId());
////                userMemorandumSet.setProductName(equipment.getProductName());
////                userMemorandumSet.setEquipmentName(equipment.getEquipmentName());
////                userMemorandumSet.setAliyunIotProductKey(equipment.getProductKey());
////                userMemorandumSet.setAliyunIotDeviceName(equipment.getDeviceName());
//                if(contentStr==null)
//                {
//                    contentStr="";
//                }
//                userMemorandumSet.setContentStr(contentStr);
////                userMemorandumSet.setActivePubTime("00:00-23:59");
//                userMemorandumSet.setContent_control_YN(content_control_YN);
////                userMemorandumSet.setLastPubTime(new Date());
////                userMemorandumSet.setLastSubTime(new Date());
//                userMemorandumSet.setNowPubMessage("0");//设置为 1 会按照系统推送规则下向用户推送消息
//                userMemorandumSet.setChangedate(new Date());
//                userMemorandumSetService.updateUserMemorandumSet(userMemorandumSet);
//
//                //直接发送IOT
//                memorandumSendPubService.send_UserMemorandumMessage_toUser(userMemorandumSet);
//
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "更新成功");
//
//                JSONObject userMemorandumSetJSON =new JSONObject();
//                userMemorandumSetJSON.put("memorandumSetId",userMemorandumSet.getUserMemorandumSetId());
//                userMemorandumSetJSON.put("contentStr",userMemorandumSet.getContentStr());
//                userMemorandumSetJSON.put("content_control_YN",userMemorandumSet.getContent_control_YN());
//                fanhuiJSONobj.put("UserMemorandumSet", userMemorandumSetJSON);
//
//            }
//            else{
//                //无记录 新增加入定制轮询
//                UserMemorandumSet userMemorandumSet=new UserMemorandumSet();
//
//                userMemorandumSet.setUserAndEquipmentId(userAndEquipment.getUserAndEquipmentId());
//                userMemorandumSet.setProductId(equipment.getProductId());
//                userMemorandumSet.setEquipmentId(equipment.getEquipmentId());
//                userMemorandumSet.setProductName(equipment.getProductName());
//                userMemorandumSet.setEquipmentName(equipment.getEquipmentName());
//                userMemorandumSet.setAliyunIotProductKey(equipment.getProductKey());
//                userMemorandumSet.setAliyunIotDeviceName(equipment.getDeviceName());
//                if(contentStr==null)
//                {
//                    contentStr="";
//                }
//                userMemorandumSet.setContentStr(contentStr);
//                userMemorandumSet.setActivePubTime("00:00-23:59");
//                userMemorandumSet.setContent_control_YN(content_control_YN);
//                userMemorandumSet.setLastPubTime(new Date());
//                userMemorandumSet.setLastSubTime(new Date());
//                userMemorandumSet.setNowPubMessage("0");//设置为 1 会按照系统推送规则下向用户推送消息
//                userMemorandumSetService.insertUserMemorandumSet(userMemorandumSet);
//
//                //直接发送IOT
//                memorandumSendPubService.send_UserMemorandumMessage_toUser(userMemorandumSet);
//
//                fanhuiJSONobj.put("RequestCode", 0);
//                fanhuiJSONobj.put("RequestMessage", "新建成功");
//
//                JSONObject userMemorandumSetJSON =new JSONObject();
//                userMemorandumSetJSON.put("memorandumSetId",userMemorandumSet.getUserMemorandumSetId());
//                userMemorandumSetJSON.put("contentStr",userMemorandumSet.getContentStr());
//                userMemorandumSetJSON.put("content_control_YN",userMemorandumSet.getContent_control_YN());
//                fanhuiJSONobj.put("UserMemorandumSet", userMemorandumSetJSON);
//            }
//
//        }else{
//            fanhuiJSONobj.put("RequestCode", 2);
//            fanhuiJSONobj.put("RequestMessage", "未绑定设备");
//        }
//        return fanhuiJSONobj.toString();
//    }
//
//    /**
//     * 用户备忘录业务--开启/关闭
//     * @return
//     */
//    @RequestMapping("/setMemorandum_control_YN")
//    @ResponseBody
//    public JSONObject setMemorandum_control_YN(String userId,String userAndEquipmentId,String content_control_YN, String RequestId)
//    {
//        logger.info("========调用定制备忘录接口=========");
//        logger.info("userId:"+userId);
//        logger.info("userAndEquipmentId:"+userAndEquipmentId);
//        logger.info("RequestId:"+RequestId);
//        logger.info("contentStr:"+content_control_YN);
//        logger.info("===================================");
//        JSONObject fanhuiJSONobj = new JSONObject();
//
//        UserAndEquipment userAndEquipment=userAndEquipmentService.find(userAndEquipmentId);
//        if(null!=userAndEquipment)
//        {
//            //查询备忘录定制表 是否有记录
//            List<UserMemorandumSet> list=userMemorandumSetService.list_UserMemorandumSet(userAndEquipment.getUserAndEquipmentId());
//            if (list.size()!=0)
//            {
//                UserMemorandumSet userMemorandumSet=list.get(0);
//
//                userMemorandumSet.setContent_control_YN(content_control_YN);
//                userMemorandumSet.setChangedate(new Date());
////                userMemorandumSet.setNowPubMessage("0");//设置为 1 会按照系统推送规则下向用户推送消息
//                userMemorandumSetService.updateUserMemorandumSet(userMemorandumSet);
//
//                //直接发送IOT
//                memorandumSendPubService.send_UserMemorandumMessage_toUser(userMemorandumSet);
//
//                fanhuiJSONobj.put("RequestCode", 1);
//                fanhuiJSONobj.put("RequestMessage", "更新成功");
//
//                JSONObject userMemorandumSetJSON =new JSONObject();
//                userMemorandumSetJSON.put("memorandumSetId",userMemorandumSet.getUserMemorandumSetId());
//                userMemorandumSetJSON.put("contentStr",userMemorandumSet.getContentStr());
//                userMemorandumSetJSON.put("content_control_YN",userMemorandumSet.getContent_control_YN());
//                fanhuiJSONobj.put("UserMemorandumSet", userMemorandumSetJSON);
//            }else{
//                fanhuiJSONobj.put("RequestCode", 3);
//                fanhuiJSONobj.put("RequestMessage", "未定制业务");
//            }
//        }
//        else{
//            fanhuiJSONobj.put("RequestCode", 2);
//            fanhuiJSONobj.put("RequestMessage", "未绑定设备");
//        }
//
//        return fanhuiJSONobj;
//    }
//
//
//    /**
//     * 血糖仪数据测试功能
//     * @return
//     */
//    @RequestMapping("/list_xtData")
//    @ResponseBody
//    public String  list_xtData()
//    {
//        JSONObject fanhuiJSONobj = new JSONObject();
//        List list=xtUploadService.se_all_XtUpload();
//System.out.println("================="+list.size());
//        fanhuiJSONobj.put("list_xtData", list);
//        System.out.println("================="+fanhuiJSONobj.toString());
//        return fanhuiJSONobj.toString();
//    }


}
