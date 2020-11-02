package com.cn.httpsms.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by ldn on 2019/10/22.
 */
public class StringEQ {
    private static Logger logger = Logger.getLogger(StringEQ.class);


    /**
     * 检查字符是否为 null || ""
     * 如果是 null 或者 "" 则返回false ,反则为 true
     * @param methodName 调用方法名称 (哪个方法使用此验证)
     * @param value 需要验证的多个字符，以英文逗号分隔
     * @return
     */
//    public static boolean checkStringIsNull(String methodName ,String... value){
//        int count = 0;
//        for(int i=0;i<value.length;i++){
//            //遍历字符数组所有的参数，发现某个为 null 或者 "" ,则跳出
//            if(StringUtils.isEmpty(value[i])){
//                logger.info(methodName+"所需要的参数不完整！");
//                return false;
//            }
//            count++;
//        }
//        if(count == value.length){
//            return true;
//        }
//        return false;
//    }

    /**
     * 检查字符是否为 null || ""
     * 如果是 null 或者 "" 则返回false ,反则为 true
     * @param value 需要验证的多个字符，以英文逗号分隔
     * @return
     */
    public static boolean checkStringIsNull(String... value){
        int count = 0;
        for(int i=0;i<value.length;i++){
            //遍历字符数组所有的参数，发现某个为 null 或者 "" ,则跳出
            if(StringUtils.isEmpty(value[i])){
                return false;
            }
            count++;
        }
        if(count == value.length){
            return true;
        }
        return false;
    }
}
