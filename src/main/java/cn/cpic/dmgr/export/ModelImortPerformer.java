package cn.cpic.dmgr.export;

import cn.cpic.dmgr.constant.Constant;
import cn.cpic.dmgr.controller.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liangxiaojin
 * @Date: 2019/12/3 15:12
 */
public class ModelImortPerformer {
    private static final Logger logger = LoggerFactory.getLogger(ModelImortPerformer.class);

    public static void insertLoadHiveTables(XSSFWorkbook xwb) throws Exception {
        XSSFSheet loadTable = xwb.getSheet(Constant.DBPF_SOURCE_TABLE);
        XSSFSheet loadField = xwb.getSheet(Constant.DBPF_SOURCE_FIELD);
        XSSFSheet synJob = xwb.getSheet(Constant.DBPF_SYN_JOB);


        logger.info("==========="+loadTable.getSheetName()+"=============");
        DbpfSourceTableController.insertLoadTable(loadTable);

//        logger.info("==========="+loadField.getSheetName()+"=============");
//        DbpfSourceFieldController.insertLoadField(loadField);
//
//        logger.info("==========="+synJob.getSheetName()+"=============");
//        DbpfSynJobController.insertSybJob(synJob);

    }
}
