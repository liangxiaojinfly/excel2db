package cn.cpic.dmgr.dao;

import cn.cpic.dmgr.common.Config;
import cn.cpic.dmgr.dao.entity.DbpfSourceTable;
import cn.cpic.dmgr.dao.mapper.DbpfSourceTableMapper;
import cn.cpic.dmgr.util.EDUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class DaoFactory {
	private static final Logger log = LoggerFactory.getLogger(DaoFactory.class);
	private static SqlSessionFactory sqlSessionFactory = null;
	
	
	private static void initFactory() {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			Properties properties = new Properties();
			properties.setProperty("url", Config.DB_URL);
			log.info(Config.DB_USERNAME);
 			properties.setProperty("username", EDUtils.decrypt(Config.DB_USERNAME));
 			properties.setProperty("password",EDUtils.decrypt(Config.DB_PASSWORD));
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
		
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}

    }

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			initFactory();
		}
		return sqlSessionFactory;
	}
    public static  <T> T getMapper(Class<T> clazz){
        SqlSession session = getSqlSessionFactory().openSession();
        T t = session.getMapper(clazz);
        return t;
    }

    public  void testListAll() {
        SqlSession session=new DaoFactory().getSqlSessionFactory().openSession();
        try {
            DbpfSourceTableMapper dbpfSourceTableMapper = session.getMapper(DbpfSourceTableMapper.class);
            List<DbpfSourceTable> dbpfSourceTableList = dbpfSourceTableMapper.needCreateOrUpdateTabs();
            log.warn("dbpfSourceTableList.size()::"+ dbpfSourceTableList.size());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }finally {
            session.close();
        }
    }
	public void main(String[] args) {
		DaoFactory daoFactory = new DaoFactory();
		daoFactory.testListAll();
		
	}
}
