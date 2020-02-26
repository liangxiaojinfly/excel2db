package cn.cpic.dmgr.controller;

import cn.cpic.dmgr.biz.DbpfSourceTableBiz;
import cn.cpic.dmgr.biz.impl.DbpfSourceTableBizImpl;
import cn.cpic.dmgr.constant.Constant;
import cn.cpic.dmgr.dao.entity.DbpfSourceTable;
import cn.cpic.dmgr.util.PoiUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liangxiaojin
 * @Date: 2019/12/12 23:22
 */
public class DbpfSourceTableController {
    private static final Logger logger = LoggerFactory.getLogger(DbpfSourceTableController.class);
    private static DbpfSourceTableBiz dbpfSourceTableBiz = new DbpfSourceTableBizImpl();

    public static void insertLoadTable(XSSFSheet sheetTable) throws Exception {
        Class clazz = Class.forName("cn.cpic.dmgr.dao.entity.DbpfSourceTable");
        //解析第0行的值，根据pojo类获取字段类型和字段名
        List<String> fieldNameList = new ArrayList();
        List<Class> fieldTypeList = new ArrayList();
        XSSFRow row0 = sheetTable.getRow(0);
        PoiUtils.translateFieldNameAndType(0,clazz,row0,fieldNameList,fieldTypeList);

        //解析每行为一个rowiMap,然后封装成一个对象,保存到Oracle
        for (int i = 1; i <= sheetTable.getLastRowNum(); i++) {
            XSSFRow rowi = sheetTable.getRow(i);
            if (rowi == null) {
                continue;
            }

            //TODO 根据Excel里面的首行字段名生成字段名，并且把第二行开始的每一行都封装成一个对象
            DbpfSourceTable sourceTable = new DbpfSourceTable();
            Map<String, Object> rowiMap = new HashMap<String, Object>();
            String tableName = PoiUtils.getCellValue(rowi.getCell(0), String.class).toString().trim().toUpperCase();
            sourceTable.setTableName(tableName);
            List<DbpfSourceTable> dbpfSourceTables = dbpfSourceTableBiz.selectByTableName(sourceTable);
            //插入时设置一个下面4个字段设置一个默认值，如果Excel里面有配置，会被覆盖
            if (dbpfSourceTables.size() == 0){
                rowiMap.put("charSet", Constant.SOURCE_TABLE_CHAR_SET);
                rowiMap.put("orgCharSet",Constant.SOURCE_TABLE_ORG_CHAR_SET);
                rowiMap.put("endSeparator",Constant.SOURCE_TABLE_END_SEPARATOR);
                rowiMap.put("javasplitkey",Constant.SOURCE_TABLE_JAVASPLITKEY);
                rowiMap.put("hdfspath",Constant.SOURCE_TABLE_HDFSPATH);
            } else if (dbpfSourceTables.size() == 1){
                sourceTable = dbpfSourceTables.get(0);
            } else if (dbpfSourceTables.size() > 1){
                logger.error("=========table_name:"+tableName+"在数据库中有不止一个值："+dbpfSourceTables.size());
                return;
            }

            for (int j = 0; j <= row0.getPhysicalNumberOfCells() - 1; j++) {
                Object cellValue = null;
                try {
                    cellValue = PoiUtils.getCellValue(rowi.getCell(j), fieldTypeList.get(j));
                } catch (Exception e) {
                    logger.error("============第"+i+"行,第"+j+"列获取单元格值异常=============");
                    logger.error(e.getMessage(),e);
                    return;
                }
                if ("tableName".equals(fieldNameList.get(j)) || "sourceCode".equals(fieldNameList.get(j)) || "sTabName".equals(fieldNameList.get(j))){
                    cellValue = cellValue.toString().trim().toUpperCase();
                }
                rowiMap.put(fieldNameList.get(j),cellValue);
            }

            BeanUtils.populate(sourceTable, rowiMap);
            logger.info(sourceTable.toString());
            try {
                if (sourceTable.getId() == null){
                    int id = dbpfSourceTableBiz.insertTable(sourceTable);
                    logger.info("===========第"+i+"行插入成功,table_name="+sourceTable.getTableName()+",id="+id+"========");
                } else {
                    int isSuccess = dbpfSourceTableBiz.updateTable(sourceTable);
                    //logger.info("==========="+(isSuccess == 1 ? "更新成功" : "更新失败")+",id="+sourceTable.getId()+"========");
                    logger.info("===========第"+i+"行"+(isSuccess == 1 ? "更新成功" : "更新失败")+",table_name="+sourceTable.getTableName()+",id="+sourceTable.getId()+"========");
                }
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
                return;
            }
        }
    }

}
