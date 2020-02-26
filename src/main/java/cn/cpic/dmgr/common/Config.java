package cn.cpic.dmgr.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 */
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    private Config() {
    }

    public static final String CONFIG_FILE_DIR;    //配置文件路径
    public static String DB_URL;    //关系数据库url
    public static String DB_USERNAME;    //关系数据库用户名
    public static String DB_PASSWORD;    //关系数据库密码
    public static String P11_TEMP_PATH;

    static {
        CONFIG_FILE_DIR = ConfigHandler.CONFIG_FILE_DIR;
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(CONFIG_FILE_DIR);
            properties.load(in);
            in.close();
            DB_URL = properties.getProperty("DB_URL");
            DB_USERNAME = properties.getProperty("DB_USERNAME");
            DB_PASSWORD = properties.getProperty("DB_PASSWORD");

            logger.info("==========="+(DB_URL.contains("10.180.178.48") ? "生产库" : "测试库")+"===========");
            Thread.sleep(4000);
            logger.warn("【info】 P11_TEMP_PATH values is：" + P11_TEMP_PATH);
        } catch (IOException | InterruptedException e1) {
            logger.error(e1.getMessage(), e1);
        }
    }

}
