package com.yuan.utils;

import com.yuan.common.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * FileName: DatabaseHelper
 * Author:   yhl
 * Date:     2018/11/18 23:39
 * Description: 配置文件管理工具
 */
public class PropertiesUtils {
	private static Logger LOGGER = LogManager.getLogger(PropertiesUtils.class);
	/**
	 * 读取配置文件返回map信息
	 * @param path
	 * @return
	 */
	public static Map<String, String> prop2Map(String path) {
		LOGGER.debug("根据资源文件路径读取文件，转换为Map类型对象: {}", path);
		Map<String, String> map = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream ins = PropertiesUtils.class.getClassLoader().getResourceAsStream(path);
		Reader reader = null;
		try {
			reader = new InputStreamReader(ins, Constant.DEFAULT_ENCODE.STRING_UTF8);
			prop.load(reader);
			Set<Map.Entry<Object,  Object>> set = prop.entrySet();
			Iterator<Map.Entry<Object, Object>> it = set.iterator();
			while (it.hasNext()) {
				Map.Entry<Object, Object> entry = it.next();
				map.put((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (Exception e) {
			LOGGER.error("根据资源文件路径读取文件，转换为Map类型对象：{}，在读取的过程中出现异常: {}", path, e);
		} finally {
			try {
				ins.close();
				reader.close();
			} catch (IOException e) {
				LOGGER.error("根据资源文件路径读取文件，转换为Map类型对象：{}，在关闭文件流对象时出现异常: {}", path, e);
			}
		}
		return map;
	}

	/**
	 * 读取配置文件
	 * @param path
	 */
	public static Properties loadProps(String path) {
		InputStream is = null;
		Properties properties = null;
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			if(is==null){
				throw new FileNotFoundException(path+"file is not found!");
			}
			properties = new Properties();
			properties.load(is);
		} catch (IOException e) {
			LOGGER.error("load properties file failure",e);
		}finally {
			if(is!=null){
				try {
					is.close();
				}catch (IOException e){
					LOGGER.error("close input stream failure",e);
				}
			}
		}
		return properties;
	}

	/**
	 * 根据指定key返回信息
	 * @param key
	 * @return
	 */
	public static String getValue(Properties properties,String key) {
		return getString(properties,key,"");
	}

	/**
	 * 获取字符串属性
	 * 默认值 “”
	 * @param properties
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties properties,String key,String defaultValue){
		String value = defaultValue;
		if(properties.contains(key)){
			value  = properties.getProperty(key);
		}
		return value;
	}
}
