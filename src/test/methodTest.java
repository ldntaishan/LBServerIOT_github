import com.alibaba.fastjson.JSONObject;
import com.cn.httpsms.adminService.AdminController;
import com.cn.httpsms.appService.ModeService.UserMode;
import com.cn.httpsms.appService.OpenManagerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by ldn on 2019/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-config/applicationContext.xml","classpath:spring-config/dispatcher-servlet.xml"})
public class methodTest {

    @Autowired
    public WebApplicationContext wac;
    public MockMvc mockMvc;
    public MockHttpSession session;

    // 模拟request,response
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    // 注入loginController
    @Autowired
    private OpenManagerController openManagerController ;



    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp ()throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }


    @Test
    public void test_api_userlogin() {
        try {
//            request.setParameter("userName", "admin");
//            request.setParameter("password", "2");
//            assertEquals("login",adminController.api_userlogin("13426364664","123456")) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_api_useropen_reg() {
        try {

            JSONObject return_login_json = new JSONObject();
            return_login_json.put("loginTag","13426364664");
            return_login_json.put("userPassWord","111");
            MvcResult mvcResult = mockMvc.perform(post("/OpenService/api_useropen_reg")
                    .param("request", return_login_json.toJSONString()))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);
//            JSONObject resultObj = JSON.parseObject(result);
            // 判断接口返回json中success字段是否为true
//            Assert.assertTrue(resultObj.getBooleanValue("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHttp() throws Exception{
        JSONObject return_login_json = new JSONObject();
        return_login_json.put("loginTag","13426364664");
        return_login_json.put("userPassWord","111");

        mockMvc.perform(post("/OpenService/api_useropen_reg").with(request -> {
            request.setRemoteAddr("192.168.1.1");
            return request;
        }));
    }

    @Test
    public void test001() throws UnsupportedEncodingException {
//        System.out.println(adminController.api_userlogin("13426364664","123456").toJSONString());
    }

}
