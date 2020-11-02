package com.cn.httpsms.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ldn on 2019/9/19.
 */
public class HttpServletRequestToString {

    public static String httpTool(HttpServletRequest request)
    {
        String callbackstr = new String();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            callbackstr=sb.toString();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return callbackstr;
    }
}
