import com.cn.httpsms.appService.AppController;
import com.cn.httpsms.appService.EquipmentController;
import com.cn.httpsms.appService.ModeService.UserMode;
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

    @Test
    public void test_useropen_reg() throws UnsupportedEncodingException {
        userMode.useropen_reg("13426364664","111");
//        System.out.println(adminController.api_userlogin("13426364664","123456").toJSONString());
    }

    /**
     * 用户注册 测试方法
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test_userBase_reg() throws UnsupportedEncodingException {
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        System.out.println(appController.UserSignin("13426364669","111","123456","2","A9999999"));
    }

    /**
     * 用手机号登陆 测试方法
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test_loginTel() throws UnsupportedEncodingException {
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        System.out.println(appController.loginTel("13426364664","111"));
    }

    /**
     * 获取用户列表 测试方法
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test_seAllUserList() throws UnsupportedEncodingException {
//        appController.UserSignin("13426364664","111","123456","2","A9999999");
        System.out.println(appController.seAllUserList());
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
                 "1004"));
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
        System.out.println(equipmentController.find_eqmt_list());
    }
}
