package com.cn.httpsms.common;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author liu.songgao
 * <p>创建时间： 2015年5月13日 下午1:59:53</p>
 * <p>描述：加载全局系统属性</p>
 * @version 1.0
 */
public class PropertyPlaceholderConfiger extends PropertyPlaceholderConfigurer {
	
	private final static Map<String, String> propMap = new HashMap<>();
	
	private Logger log = Logger.getLogger(getClass());
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for(Object key : props.keySet()){
			String proName = (String)key;
			String proValue = props.getProperty(proName);
			propMap.put(proName, proValue);
			log.info("初始化系统属性："+proName + "=" + proValue);
		}
	}
	
	public static String getPropertyValue(String proName){
		return propMap.get(proName);
	}
	
}
