package cn.cpic.dmgr.dao.mapper;

import cn.cpic.dmgr.dao.entity.DbpfSourceTable;

import java.util.List;

public interface DbpfSourceTableMapper {
	/**
	 * 
	* @Title: needCreateOrUpdateTabs
	* @Description: 需要创建或者需要更新表结构的表
	* @param @return    设定文件
	* @return List<DbpfSourceTable>    返回类型
	* @throws
	 */
	List<DbpfSourceTable> needCreateOrUpdateTabs();
	
	/**
	 * 
	* @Title: selectByPrimaryKeyList
	* @Description: 根据多个id查询表
	* @param @return    设定文件
	* @return List<DbpfSourceTable>    返回类型
	* @throws
	 */
	List<DbpfSourceTable> selectByPrimaryKeyList(List<Long> ids);
	
	
	List<DbpfSourceTable> selectByTableName(DbpfSourceTable dbpfSourceTable);

    int insertTable(DbpfSourceTable dbpfSourceTable);

    int updateTable(DbpfSourceTable dbpfSourceTable);
	
	
}