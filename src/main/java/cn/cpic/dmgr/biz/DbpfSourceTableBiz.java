package cn.cpic.dmgr.biz;

import cn.cpic.dmgr.dao.entity.DbpfSourceTable;

import java.util.List;

/**
 * @Author: liangxiaojin
 * @Date: 2019/12/11 10:33
 */
public interface DbpfSourceTableBiz {

    List<DbpfSourceTable> selectByTableName(DbpfSourceTable dbpfSourceTable);

    int insertTable(DbpfSourceTable dbpfSourceTable);

    int updateTable(DbpfSourceTable dbpfSourceTable);
}
