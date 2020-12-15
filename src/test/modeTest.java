import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.appService.AppController;
import com.cn.httpsms.appService.EquipmentController;
import com.cn.httpsms.appService.ModeService.UserMode;
import com.cn.httpsms.appService.SensorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.UnsupportedEncodingException;

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
        //初始化用户信息（5个用户）
        appController.userSignin("张一","张一南山采茶","zhag1@163.com","13411110001","1","111","1","");
        appController.userSignin("张二","张二南山采茶","zhag2@163.com","13411110002","2","111","1","");
        appController.userSignin("张三","张三南山采茶","zhagnsan3@163.com","13411110003","2","111","1","");
        appController.userSignin("张四","张四南山采茶","zhagnsan4@163.com","13411110004","2","111","1","");
        appController.userSignin("张五","张五南山采茶","zhagnsan5@163.com","13411110005","2","111","1","");
        appController.userSignin("张六","张六南山采茶","zhagnsan6@163.com","13411110006","2","111","1","");
        appController.userSignin("张七","张七南山采茶","zhagnsan7@163.com","13411110007","2","111","1","");
        appController.userSignin("张八","张八南山采茶","zhagnsan8@163.com","13411110008","2","111","1","");
        appController.userSignin("张九","张九南山采茶","zhagnsan9@163.com","13411110009","2","111","1","");
        appController.userSignin("李一","李一南山采茶","lzhagnsan@163.com","13411110010","1","111","1","");
        appController.userSignin("李二","李二南山采茶","lzhagnsan@163.com","13411110011","2","111","1","");
        appController.userSignin("李三","李三南山采茶","lzhagnsan@163.com","13411110012","2","111","1","");
        appController.userSignin("李四","李四南山采茶","lzhagnsan@163.com","13411110013","2","111","1","");
        appController.userSignin("李五","李五南山采茶","lzhagnsan@163.com","13411110014","2","111","1","");
        appController.userSignin("李六","李六南山采茶","lzhagnsan@163.com","13411110015","2","111","1","");
        appController.userSignin("李七","李七南山采茶","lzhagnsan@163.com","13411110016","2","111","1","");
        appController.userSignin("李八","李八南山采茶","lzhagnsan@163.com","13411110017","2","111","1","");
        appController.userSignin("李九","李九南山采茶","lzhagnsan@163.com","13411110018","2","111","1","");
        appController.userSignin("王一","王一南山采茶","wzhagnsan@163.com","13411110019","2","111","1","");
        appController.userSignin("王二","王二南山采茶","wzhagnsan@163.com","13411110020","2","111","1","");
        appController.userSignin("王三","王三南山采茶","wzhagnsan@163.com","13411110021","2","111","1","");
        appController.userSignin("王四","王四南山采茶","wzhagnsan@163.com","13411110022","2","111","1","");
        appController.userSignin("王五","王五南山采茶","wzhagnsan@163.com","13411110023","2","111","1","");
        appController.userSignin("王六","王六南山采茶","wzhagnsan@163.com","13411110024","2","111","1","");
        appController.userSignin("王七","王七南山采茶","wzhagnsan@163.com","13411110025","2","111","1","");
        appController.userSignin("王九","王九南山采茶","wzhagnsan@163.com","13411110026","2","111","1","");
        appController.userSignin("赵一","赵一南山采茶","wzhagnsan@163.com","13411110027","2","111","1","");
        appController.userSignin("赵二","赵二南山采茶","wzhagnsan@163.com","13411110028","2","111","1","");

        //初始化设备

        JSONObject json1 = JSONObject.parseObject(equipmentController.creart_equipment("新乡风电场","西南1号风力发电塔","EN2.1-110","1001","1"));
        String equipmentId1=json1.getString("equipmentId");
        System.out.println(equipmentId1);
        sensorController.creart_sensor("一号点位","M001","5161326711",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("二号点位","M001","5161326712",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("三号点位","M001","5161326713",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("四号点位","M001","5161326714",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("五号点位","M001","5161326715",equipmentId1,"0.1","4028098175c6d2cc0175c6d2d7a10001");

        JSONObject json2 = JSONObject.parseObject(equipmentController.creart_equipment("新乡风电场","西南2号风力发电塔","EN2.1-110","1002","1"));
        String equipmentId2=json2.getString("equipmentId");
        sensorController.creart_sensor("一号点位","M001","5161326721",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("二号点位","M001","5161326722",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("三号点位","M001","5161326723",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("四号点位","M001","5161326724",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("五号点位","M001","5161326725",equipmentId2,"0.1","4028098175c6d2cc0175c6d2d7a10001");

        JSONObject json3 = JSONObject.parseObject(equipmentController.creart_equipment("新乡风电场","西南1号风力发电塔","EN2.1-110","1003","1"));
        String equipmentId3=json3.getString("equipmentId");
        sensorController.creart_sensor("一号点位","M006","5161326731",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("二号点位","M006","5161326732",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("三号点位","M006","5161326733",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("四号点位","M006","5161326734",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001");
        sensorController.creart_sensor("五号点位","M006","5161326735",equipmentId3,"0.1","4028098175c6d2cc0175c6d2d7a10001");

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
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        appController.userSignin("张一","张一南山采茶","zhag1@163.com","13411110001","1","111","1","");
        appController.userSignin("张二","张二南山采茶","zhag2@163.com","13411110002","2","111","1","");
        appController.userSignin("张三","张三南山采茶","zhagnsan3@163.com","13411110003","2","111","1","");
        appController.userSignin("张四","张四南山采茶","zhagnsan4@163.com","13411110004","2","111","1","");
        appController.userSignin("张五","张五南山采茶","zhagnsan5@163.com","13411110005","2","111","1","");
        appController.userSignin("张六","张六南山采茶","zhagnsan6@163.com","13411110006","2","111","1","");
        appController.userSignin("张七","张七南山采茶","zhagnsan7@163.com","13411110007","2","111","1","");
        appController.userSignin("张八","张八南山采茶","zhagnsan8@163.com","13411110008","2","111","1","");
        appController.userSignin("张九","张九南山采茶","zhagnsan9@163.com","13411110009","2","111","1","");
        appController.userSignin("李一","李一南山采茶","lzhagnsan@163.com","13411110010","1","111","1","");
        appController.userSignin("李二","李二南山采茶","lzhagnsan@163.com","13411110011","2","111","1","");
        appController.userSignin("李三","李三南山采茶","lzhagnsan@163.com","13411110012","2","111","1","");
        appController.userSignin("李四","李四南山采茶","lzhagnsan@163.com","13411110013","2","111","1","");
        appController.userSignin("李五","李五南山采茶","lzhagnsan@163.com","13411110014","2","111","1","");
        appController.userSignin("李六","李六南山采茶","lzhagnsan@163.com","13411110015","2","111","1","");
        appController.userSignin("李七","李七南山采茶","lzhagnsan@163.com","13411110016","2","111","1","");
        appController.userSignin("李八","李八南山采茶","lzhagnsan@163.com","13411110017","2","111","1","");
        appController.userSignin("李九","李九南山采茶","lzhagnsan@163.com","13411110018","2","111","1","");
        appController.userSignin("王一","王一南山采茶","wzhagnsan@163.com","13411110019","2","111","1","");
        appController.userSignin("王二","王二南山采茶","wzhagnsan@163.com","13411110020","2","111","1","");
        appController.userSignin("王三","王三南山采茶","wzhagnsan@163.com","13411110021","2","111","1","");
        appController.userSignin("王四","王四南山采茶","wzhagnsan@163.com","13411110022","2","111","1","");
        appController.userSignin("王五","王五南山采茶","wzhagnsan@163.com","13411110023","2","111","1","");
        appController.userSignin("王六","王六南山采茶","wzhagnsan@163.com","13411110024","2","111","1","");
        appController.userSignin("王七","王七南山采茶","wzhagnsan@163.com","13411110025","2","111","1","");
        appController.userSignin("王九","王九南山采茶","wzhagnsan@163.com","13411110026","2","111","1","");
        appController.userSignin("赵一","赵一南山采茶","wzhagnsan@163.com","13411110027","2","111","1","");
        appController.userSignin("赵二","赵二南山采茶","wzhagnsan@163.com","13411110028","2","111","1","");
//        System.out.println(appController.userSignin("13426364670","111","123456","2"));
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
        System.out.println(sensorController.creart_sensor
                ("六号点位",
                        "M001",
                        "5161326716",
                        "4028098175c6d2cc0175c6d2d7a10000",
                        "0.1",
                        "4028098175c6d2cc0175c6d2d7a10001"));
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

}
