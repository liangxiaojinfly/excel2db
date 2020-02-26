package cn.cpic.dmgr.util;

import cn.cpic.dmgr.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.poi.ss.usermodel.CellType;


public class PoiUtils {
    private static Logger log = Logger.getLogger(PoiUtils.class);
	
	public static Object getCellValue(XSSFCell cell, Class type){
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
		if(type==String.class){
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String cellValue = cell.getStringCellValue().trim();
			return StringUtils.isEmpty(cellValue) ? "" : cellValue;
		}else if(type==Integer.class || type==Long.class){
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			Double value=new Double(cell.getNumericCellValue());
			return new Integer(value.intValue());
		}else if(type==java.util.Date.class){
			return cell.getDateCellValue();
		}else if(type==Double.class){
			return new Double(cell.getNumericCellValue());
		}else{
			return null;
		}
	}
	public static String getCellStringValue(HSSFCell cell){
		if(cell==null||cell.toString().trim().equals("")){
			return "";
		}
		switch(cell.getCellType()){
		case HSSFCell.CELL_TYPE_BLANK:
			return "";
		case HSSFCell.CELL_TYPE_STRING:
			return cell.getRichStringCellValue().getString();
		case HSSFCell.CELL_TYPE_NUMERIC:
			if(HSSFDateUtil.isCellDateFormatted(cell)){
			    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
				return dateFormat.format(cell.getDateCellValue());
			}else{
				String value=new BigDecimal(new Double(cell.getNumericCellValue()).toString()).toString();
				return value;
			}
		default:
			return "";
		}
	}
	public static String double2Int(String doubleString){
		return new BigDecimal(new Double(doubleString).intValue()).toString();
	}

	/*
	* 判断行是否为空
	* */
	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK){
				return false;
			}
		}
		return true;
	}

    /**
     * 解析第0行
     * @param startColumn
     * @param clazz
     * @param row0
     * @param fieldNameList
     * @param fieldTypeList
     * @throws NoSuchFieldException
     */
	public static void  translateFieldNameAndType(int startColumn,Class clazz,XSSFRow row0, List fieldNameList,List fieldTypeList) throws NoSuchFieldException {
        for (int i= startColumn; i <= row0.getPhysicalNumberOfCells()-1; i++){
            XSSFCell cell = row0.getCell(i);
            String fieldName = CamelUtil.methodNameCamel((String) PoiUtils.getCellValue(cell, String.class));
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            String typeName = field.getGenericType().getTypeName();
            if (typeName.contains(".")){
                typeName = typeName.substring(typeName.lastIndexOf(".")+1);
            }
            Class fieldType = CommonUtils.getType(typeName);
            fieldNameList.add(i,fieldName);
            fieldTypeList.add(i,fieldType);
        }
    }

    /**
     *
     * @param fieldType
     * @return
     */
    public static void  analyseFieldType(String fieldType,Map rowiMap){
        Pattern p = Pattern.compile(Constant.FIELD_TYPE_REGEX);
        Matcher m = p.matcher(fieldType.toUpperCase());
        fieldType = m.replaceAll(Constant.FIELD_TYPE_REPLACE);
        if (fieldType.contains("NUMBER") || fieldType.contains("DECIMAL") || fieldType.contains("INT")){
            rowiMap.put("bigdataFieldType","decimal");
        } else {
            rowiMap.put("bigdataFieldType","string");
        }
        if (!fieldType.contains("(")){
            rowiMap.put("fieldType",fieldType);
            rowiMap.put("fieldLenth",0);
            rowiMap.put("fieldAccuracy",0);
        }
        if (fieldType.contains("(") && !fieldType.contains(",")){
            rowiMap.put("fieldType",fieldType.substring(0,fieldType.indexOf("(")));
            rowiMap.put("fieldLenth",fieldType.substring(fieldType.indexOf("(")+1,fieldType.indexOf(")")));
            rowiMap.put("fieldAccuracy",0);
            if (fieldType.substring(fieldType.indexOf("(")+1).contains("CHAR")){
                String s = fieldType.substring(fieldType.indexOf("(") + 1, fieldType.indexOf(" CHAR")).trim();
                rowiMap.put("fieldLenth",Integer.parseInt(s)*3);
            }
        }
        if (fieldType.contains("(") && fieldType.contains(",")){
            rowiMap.put("fieldType",fieldType.substring(0,fieldType.indexOf("(")));
            rowiMap.put("fieldLenth",fieldType.substring(fieldType.indexOf("(")+1,fieldType.indexOf(",")));
            rowiMap.put("fieldAccuracy",fieldType.substring(fieldType.indexOf(",")+1,fieldType.indexOf(")")));
        }

    }

}
