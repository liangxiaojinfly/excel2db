package cn.cpic.dmgr.util;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesUtil {
	
	private static Properties prop = new Properties();
	static Logger log = Logger.getLogger("PropertiesUtil"); 
	

	
	/**
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
	
	/**
	 * 根据properties 获取properties属性
	 * @param file
	 * @return
	 */
	public static Properties getProperties(String file){
		InputStream inStream = null;
	    Properties prop = new Properties();
	    try {
	    	inStream = new FileInputStream(new File(file));
		} catch (FileNotFoundException e) {
			log.getLogger(e.getMessage());
		}
	    try {
			prop.load(inStream);
		} catch (IOException e) {
			log.getLogger(e.getMessage());
		}
	    return prop;
	}
	
}
