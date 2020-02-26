package cn.cpic.dmgr.biz.impl;

import cn.cpic.dmgr.biz.DbpfSourceTableBiz;
import cn.cpic.dmgr.dao.DaoFactory;
import cn.cpic.dmgr.dao.entity.DbpfSourceTable;
import cn.cpic.dmgr.dao.mapper.DbpfSourceTableMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Author: liangxiaojin
 * @Date: 2019/12/11 10:33
 */
public class DbpfSourceTableBizImpl implements DbpfSourceTableBiz {

    private static Logger log = Logger.getLogger(DbpfSourceTableBizImpl.class);
    private static SqlSession session = new DaoFactory().getSqlSessionFactory().openSession();
    @Override
    public List<DbpfSourceTable> selectByTableName(DbpfSourceTable dbpfSourceTable) {
        DbpfSourceTableMapper m = session.getMapper(DbpfSourceTableMapper.class);
        List<DbpfSourceTable> tableList = m.selectByTableName(dbpfSourceTable);
        return tableList;
    }

    @Override
    public int insertTable(DbpfSourceTable dbpfSourceTable) {
        DbpfSourceTableMapper m = session.getMapper(DbpfSourceTableMapper.class);
        m.insertTable(dbpfSourceTable);
        //log.info("=========【插入】table_name:"+dbpfSourceTable.getTableName()+",【id】:"+dbpfSourceTable.getId()+"============");
        session.commit();
        return dbpfSourceTable.getId().intValue();
    }

    @Override
    public int updateTable(DbpfSourceTable dbpfSourceTable) {
        DbpfSourceTableMapper m = session.getMapper(DbpfSourceTableMapper.class);
        int isSuccess = m.updateTable(dbpfSourceTable);
        //log.info("=========【更新】table_name:"+dbpfSourceTable.getTableName()+",【id】:"+dbpfSourceTable.getId()+"============");
        session.commit();
        return isSuccess;
    }
}
