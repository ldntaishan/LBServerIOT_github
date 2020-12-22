import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.appService.AppController;
import com.cn.httpsms.appService.EquipmentController;
import com.cn.httpsms.appService.ModeService.UserMode;
import com.cn.httpsms.appService.SensorController;
import com.cn.httpsms.entity.Sensor;
import com.cn.httpsms.entity.SensorRealTime;
import com.cn.httpsms.service.SensorRealTimeService;
import com.cn.httpsms.service.SensorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by ldn on 2019/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-config/applicationContext.xml","classpath:spring-config/dispatcher-servlet.xml"})
public class modeTest {

    @Autowired
    private UserMode userMode;

    @Autowired
    private AppController appController;

    @Autowired
    private EquipmentController equipmentController;

    @Autowired
    private SensorController sensorController;

    @Autowired
    private SensorRealTimeService sensorRealTimeService;

    @Autowired
    private SensorService sensorService;

    @Test
    public void test_useropen_reg() throws UnsupportedEncodingException {
        userMode.useropen_reg("13426364664","111");
//        System.out.println(adminController.api_userlogin("13426364664","123456").toJSONString());
    }

    /**
     * 初始化测试信息 用户 设备 传感器
     * String userName,
     *             String userNickName,
     *             String userEmail,
     *             String userTel,
     *             String userRole,
     *             String userPassWord,
     *             String userState,
     *             String securityCode
     */
    @Test
    public void test_init_all_date()
    {
        //初始化设备

        JSONObject json1 = JSONObject.parseObject(equipmentController.creart_equipment("新乡风电场","西南1号风力发电塔","EN2.1-110","1001","1"));
        String equipmentId1=json1.getString("equipmentId");
        System.out.println(equipmentId1);
//        sensorController.creart_sensor("一号点位","M001","5161326711",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("二号点位","M001","5161326712",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("三号点位","M001","5161326713",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("四号点位","M001","5161326714",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("五号点位","M001","5161326715",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");

        JSONObject json2 = JSONObject.parseObject(equipmentController.creart_equipment("新乡风电场","西南2号风力发电塔","EN2.1-110","1002","1"));
        String equipmentId2=json2.getString("equipmentId");
//        sensorController.creart_sensor("一号点位","M001","5161326721",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("二号点位","M001","5161326722",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("三号点位","M001","5161326723",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("四号点位","M001","5161326724",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("五号点位","M001","5161326725",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");

        JSONObject json3 = JSONObject.parseObject(equipmentController.creart_equipment("新乡风电场","西南1号风力发电塔","EN2.1-110","1003","1"));
        String equipmentId3=json3.getString("equipmentId");
//        sensorController.creart_sensor("一号点位","M006","5161326731",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("二号点位","M006","5161326732",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("三号点位","M006","5161326733",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("四号点位","M006","5161326734",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");
//        sensorController.creart_sensor("五号点位","M006","5161326735",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001","1");

    }
    @Test
    public void init_user()
    {
        //初始化用户信息（5个用户）
        appController.userSignin("张明轩","一组巡检员001","zhangmingxuan@163.com","13411110001","1","111","1","");
        appController.userSignin("宋和玉","一组巡检员002","songheyu@163.com","13411110002","2","111","1","");
        appController.userSignin("赵和光","一组巡检员003","zhaoheguang@163.com","13411110003","2","111","1","");
        appController.userSignin("张志业","一组巡检员004","zhangzhiye@163.com","13411110004","2","111","1","");
        appController.userSignin("许晔","一组巡检员005","xuhua@163.com","13411110005","2","111","1","");
        appController.userSignin("贾振海","一组巡检员006","jiazhenhai@163.com","13411110006","2","111","1","");
        appController.userSignin("张闲华","二组巡检员001","zhangxianhua@163.com","13411110007","2","111","1","");
        appController.userSignin("李平文","二组巡检员002","lipingwen@163.com","13411110008","2","111","1","");
        appController.userSignin("姚灵松","二组巡检员003","yaosongling@163.com","13411110009","2","111","1","");
        appController.userSignin("李飞驰","二组巡检员004","lifeichi@163.com","13411110010","1","111","1","");
        appController.userSignin("张新荣","二组巡检员005","zhangxinrong@163.com","13411110011","2","111","1","");
        appController.userSignin("李杉","二组巡检员006","libin@163.com","13411110012","2","111","1","");
        appController.userSignin("赵星雨","三组巡检员001","zhaoxingyu@163.com","13411110013","2","111","1","");
        appController.userSignin("张书文","三组巡检员002","zhangshuwen@163.com","13411110014","2","111","1","");
        appController.userSignin("李冬雪","三组巡检员003","lidongxue@163.com","13411110015","2","111","1","");
        appController.userSignin("张歌","三组巡检员004","zhangge@163.com","13411110016","2","111","1","");
        appController.userSignin("李白山","三组巡检员005","libaishan@163.com","13411110017","2","111","1","");
        appController.userSignin("宋乐水","三组巡检员006","songleshui@163.com","13411110018","2","111","1","");
        appController.userSignin("许书易","四组巡检员001","xushuyi@163.com","13411110019","2","111","1","");
        appController.userSignin("张思义","四组巡检员002","zhangsiyi@163.com","13411110020","2","111","1","");
        appController.userSignin("许鹏","四组巡检员003","xupeng@163.com","13411110021","2","111","1","");
        appController.userSignin("赵正浩","四组巡检员004","zhaozhenghao@163.com","13411110022","2","111","1","");
        appController.userSignin("贾雨石","四组巡检员005","jiayushi@163.com","13411110023","2","111","1","");
        appController.userSignin("张宏伯","五组巡检员001","zhangbohong@163.com","13411110024","2","111","1","");
        appController.userSignin("宋鹏飞","五组巡检员002","songpengfei@163.com","13411110025","2","111","1","");
        appController.userSignin("胡澎湃","五组巡检员003","hupengpai@163.com","13411110026","2","111","1","");
        appController.userSignin("陈丽阳","五组巡检员004","chenliyang@163.com","13411110027","2","111","1","");
        appController.userSignin("贾刚","五组巡检员005","jiagang@163.com","13411110028","2","111","1","");

    }

    @Test
    public void init_equipment()
    {
        equipmentController.init_creart_equipment("赵庄灵山风电场","1号风力发电塔","EN2.1-110","1001","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","2号风力发电塔","EN2.1-110","1002","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","3号风力发电塔","EN2.1-110","1003","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","4号风力发电塔","EN2.1-110","1004","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","5号风力发电塔","EN2.1-110","1005","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","6号风力发电塔","EN2.1-110","1006","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","7号风力发电塔","EN2.1-110","1007","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","8号风力发电塔","EN2.1-110","1008","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","9号风力发电塔","EN2.1-110","1009","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","10号风力发电塔","EN2.1-110","1010","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","11号风力发电塔","EN2.1-110","1011","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","12号风力发电塔","EN2.1-110","1012","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","13号风力发电塔","EN2.1-110","1013","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","14号风力发电塔","EN2.1-110","1014","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","15号风力发电塔","EN2.1-110","1015","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","16号风力发电塔","EN2.1-110","1016","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","17号风力发电塔","EN2.1-110","1017","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","18号风力发电塔","EN2.1-110","1018","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","19号风力发电塔","EN2.1-110","1019","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","20号风力发电塔","EN2.1-110","1020","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","21号风力发电塔","EN2.1-110","1021","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","22号风力发电塔","EN2.1-110","1022","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","23号风力发电塔","EN2.1-110","1023","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","24号风力发电塔","EN2.1-110","1024","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","25号风力发电塔","EN2.1-110","1025","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","26号风力发电塔","EN2.1-110","1026","1");
        equipmentController.init_creart_equipment("赵庄灵山风电场","27号风力发电塔","EN2.1-110","1027","1");
    }

    @Test
    public void init_sensor()
    {
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西1号点位","M64","5161326731","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西2号点位","M64","5161326732","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西3号点位","M64","5161326733","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西4号点位","M64","5161326734","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西5号点位","M64","5161326735","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西6号点位","M64","5161326736","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西7号点位","M64","5161326737","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西8号点位","M64","5161326738","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西9号点位","M64","5161326739","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西10号点位","M64","5161326740","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","基础环西11号点位","M64","5161326741","0.5","1");

        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西1号点位","M48","5161326742","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西2号点位","M48","5161326743","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西3号点位","M48","5161326744","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西4号点位","M48","5161326745","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西5号点位","M48","5161326746","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西6号点位","M48","5161326747","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西7号点位","M48","5161326748","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西8号点位","M48","5161326749","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西9号点位","M48","5161326750","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西10号点位","M48","5161326751","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07a6c0000","一二连接环西11号点位","M48","5161326752","0.5","1");
//---------------------------------------------------------------
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西1号点位","M64","5161326753","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西2号点位","M64","5161326754","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西3号点位","M64","5161326755","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西4号点位","M64","5161326756","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西5号点位","M64","5161326757","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西6号点位","M64","5161326758","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西7号点位","M64","5161326759","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西8号点位","M64","5161326760","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西9号点位","M64","5161326761","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西10号点位","M64","5161326762","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","基础环西11号点位","M64","5161326763","0.5","1");

        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西1号点位","M48","5161326764","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西2号点位","M48","5161326765","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西3号点位","M48","5161326766","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西4号点位","M48","5161326767","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西5号点位","M48","5161326768","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西6号点位","M48","5161326769","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西7号点位","M48","5161326770","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西8号点位","M48","5161326771","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西9号点位","M48","5161326772","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西10号点位","M48","5161326773","0.5","1");
        sensorController.creart_sensor("40281f817689f05c017689f07b1b0001","一二连接环西11号点位","M48","5161326774","0.5","1");


    }
    /**
     * 用户注册 测试方法
     * @throws UnsupportedEncodingException
     * return
     * 范例-成功：{"RequestCode":0,"RequestMessage":"注册成功"}
     *
     */
    @Test
    public void test_userBase_reg() throws UnsupportedEncodingException {
        appController.userSignin("贾刚","五组巡检员005","jiagang@163.com","13411110028","2","111","1","");

    }

    /**
     * 用手机号登陆 测试方法
     * @throws UnsupportedEncodingException
     * =====================
     * 访问地址：
     * http://39.106.55.120:8080/app/loginTel?userTel=13900001111&&userPassWord=111
     * =====================
     * 访问参数：
     * userTel 用户登陆标识
     * userPassWord 登陆密码
     * =====================
     * 返回范例（登陆成功）：
     * {
     * 	"RequestCode": 0,
     * 	"UserBase": {
     * 		"userPassWord": "111",
     * 		"userState": "1",
     * 		"userTel": "13900001111",
     * 		"userRole": "2",
     * 		"userId": "4028098175cb65970175cb65c41f0000"
     *        },
     * 	"RequestMessage": "登陆成功"
     * }
     */
    @Test
    public void test_loginTel() throws UnsupportedEncodingException {
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        System.out.println(appController.loginTel("13426364664","111"));
    }

    /**
     * 获取用户列表 测试方法
     * 访问参数：无
     * @throws UnsupportedEncodingException
     * http://39.106.55.120:8080/app/seAllUserList
     * 返回：
     * {
     * 	"callbackCode": "200",
     * 	"callbackDetails": "正常",
     * 	"callbackList": [{
     * 		"changedate": 1605435246000,
     * 		"createdate": 1605435246000,
     * 		"lastLoginTime": 1605436752000,
     * 		"userId": "4028098175cb65970175cb65c41f0000",
     * 		"userPassWord": "111",
     * 		"userRole": "2",
     * 		"userState": "1",
     * 		"userTel": "13900001111"
     *        }, {
     * 		"changedate": 1605435246000,
     * 		"createdate": 1605435246000,
     * 		"userId": "4028098175cb65970175cb65c4ff0001",
     * 		"userPassWord": "111",
     * 		"userRole": "2",
     * 		"userState": "1",
     * 		"userTel": "13900001112"
     *    }, {
     * 		"changedate": 1605435246000,
     * 		"createdate": 1605435246000,
     * 		"userId": "4028098175cb65970175cb65c5a80002",
     * 		"userPassWord": "111",
     * 		"userRole": "2",
     * 		"userState": "1",
     * 		"userTel": "13900001113"
     *    }, {
     * 		"changedate": 1605435246000,
     * 		"createdate": 1605435246000,
     * 		"userId": "4028098175cb65970175cb65c6560003",
     * 		"userPassWord": "111",
     * 		"userRole": "2",
     * 		"userState": "1",
     * 		"userTel": "13900001114"
     *    }, {
     * 		"changedate": 1605435246000,
     * 		"createdate": 1605435246000,
     * 		"userId": "4028098175cb65970175cb65c7240004",
     * 		"userPassWord": "111",
     * 		"userRole": "2",
     * 		"userState": "1",
     * 		"userTel": "13900001115"
     *    }]
     * }
     *
     */
    @Test
    public void test_seAllUserList() throws UnsupportedEncodingException {
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        System.out.println(appController.seAllUserList("{\"page\":1,\"limit\":1000}"));
    }

    /**
     * 根据id删除用户 测试方法
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test_del_userBase() throws UnsupportedEncodingException {
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        System.out.println(appController.del_userBase("4028098175c61a140175c61a20360000"));
    }
//=========================以下设备测试方法============================================================

    /**
     * 新建设备 测试方法
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test_creart_equipment() throws UnsupportedEncodingException {
        System.out.println(equipmentController.creart_equipment
                ("新乡风电场",
                 "西南4号风力发电塔",
                 "EN2.1-110",
                 "1004",
                        "1"));
    }

    @Test
    public void test_del_eqmt() throws UnsupportedEncodingException {
        System.out.println(equipmentController.del_eqmt("4028098175c691c80175c691d4f70000"));
    }

    @Test
    public void test_find_eqmt_obj() throws UnsupportedEncodingException {
        System.out.println(equipmentController.find_eqmt_obj("4028098175c69fd90175c69fe55f0000"));
    }

    @Test
    public void test_find_eqmt_list() throws UnsupportedEncodingException {
//        System.out.println(equipmentController.find_eqmt_list());
    }

    //=========================以下传感器测试方法============================================================

    /**
     * 新建传感器 测试方法
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test_creart_sensor() throws UnsupportedEncodingException {
//        System.out.println(sensorController.creart_sensor
//                ("六号点位",
//                        "M001",
//                        "5161326716",
//                        "4028098175c6d2cc0175c6d2d7a10000",
//                        "0.1",
//                        "4028098175c6d2cc0175c6d2d7a10001","1"));
    }

    @Test
    public void test_del_sensor() throws UnsupportedEncodingException {
        System.out.println(sensorController.del_sensor("4028098175c7f9110175c7f91d470000"));
    }

    @Test
    public void test_find_sensor_obj() throws UnsupportedEncodingException {
        System.out.println(sensorController.find_ss_obj("4028098175c7f89a0175c7f8a5e40000"));
    }

    @Test
    public void test_find_sensor_list() throws UnsupportedEncodingException {
//        System.out.println(sensorController.find_ss_list());
    }



    //镜像实时监测表 数据，主要用户没有螺栓上传数据
    @Test
    public void test_run() throws UnsupportedEncodingException {

        List<Sensor> list=sensorService.list_all_sensor();
        for (int i=0;i<list.size();i++)
        {
            SensorRealTime ssrt=new SensorRealTime();
            ssrt.setDevNo(list.get(i).getDevNo());
            ssrt.setAbsoluteValue(0);
            ssrt.setNowTimeValue(2.3);
            ssrt.setUploadTime(new Date());
            sensorRealTimeService.update(ssrt);

        }
    }

    @Test
    public void test_run_updatetime() throws UnsupportedEncodingException {

        List<SensorRealTime> list=sensorRealTimeService.list_all_sensorRealTime();
        for (int i=0;i<list.size();i++)
        {
            SensorRealTime ssrt=list.get(i);

            ssrt.setAbsoluteValue(0);
            ssrt.setNowTimeValue(2.3);
            ssrt.setUploadTime(new Date());
            sensorRealTimeService.update(ssrt);

        }
    }



}
