import com.cn.httpsms.appService.AppController;
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
        System.out.println(appController.UserSignin("13426364664","111","123456","2","A9999999"));
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

    @Test
    public void test_useropen_login() throws UnsupportedEncodingException {
//        userMode.useropen_login("13426364664","111");
        System.out.println(userMode.useropen_login("13426364664","111"));
//        System.out.println(adminController.api_userlogin("13426364664","123456").toJSONString());
    }
}
