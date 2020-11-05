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

    @Test
    public void test_useropen_reg() throws UnsupportedEncodingException {
        userMode.useropen_reg("13426364664","111");
//        System.out.println(adminController.api_userlogin("13426364664","123456").toJSONString());
    }

    @Test
    public void test_useropen_login() throws UnsupportedEncodingException {
//        userMode.useropen_login("13426364664","111");
        System.out.println(userMode.useropen_login("13426364664","111"));
//        System.out.println(adminController.api_userlogin("13426364664","123456").toJSONString());
    }
}
