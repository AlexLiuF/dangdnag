package com.baizhi.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory ssf;
	static {
		try {
			//读取主配置文件
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//创建sqlsessionfactory(sqlsession工厂)
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static SqlSession getSqlSession() {
		//通过ssf获取sqlsession
		SqlSession sqlSession = null;
		sqlSession = ssf.openSession();
		return sqlSession;
	}
	//先判断sqlsession不是空再关
	public static void close(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
}
