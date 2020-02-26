package cn.cpic.dmgr.export;

import cn.cpic.dmgr.biz.*;
import cn.cpic.dmgr.biz.impl.*;
import cn.cpic.dmgr.common.ConfigHandler;
import cn.cpic.dmgr.controller.*;
import cn.cpic.dmgr.dao.entity.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 导入元数据入口类
 */
public class ModelImortManager {
    private static final Logger logger = LoggerFactory.getLogger(ModelImortManager.class);
	private static final String EXCELPATH = "D:\\数据\\04 ETL流程\\01 统一导数历史记录\\统一接入模板--测试环境-调试代码用.xlsx";
	public static void main(String[] args) throws Exception {
        new ConfigHandler( System.getProperty("user.dir")+"/config.properties");
        XSSFWorkbook xwb = null;
        try {
			xwb = new XSSFWorkbook(new FileInputStream(EXCELPATH));
		} catch (FileNotFoundException e) {
            logger.error("=================文件不存在=============");
            logger.error(e.getMessage(),e);
		} catch (IOException e) {
            logger.error("=================io流错误=================");
            logger.error(e.getMessage(),e);
		}
        ModelImortPerformer performer = new ModelImortPerformer();
        performer.insertLoadHiveTables(xwb);

    }

}
