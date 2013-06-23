package com.zikool.edu.common.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
public abstract class DaoSupport implements DAO{
	
	protected SqlSessionTemplate sqlSession;
	
	public void delete(Object ... entityids) {
		for(Object id : entityids){
			sqlSession.delete(this.getClass().getCanonicalName()+".deleteByPrimaryKey", id);
		}
	}
	public Object find(Object entityId) {
		return sqlSession.selectOne(this.getClass().getCanonicalName()+".selectByPrimaryKey", entityId);
	}
	
	public void save(Object entity) {
		sqlSession.insert(this.getClass().getCanonicalName()+".insert", entity);
	}
	
	public void update(Object entity) {
		sqlSession.update(this.getClass().getCanonicalName()+".updateByPrimaryKey", entity);
	}
    
	public List selectByWhereSql(String sql){
		return sqlSession.selectList(this.getClass().getCanonicalName()+".selectBySql", sql);
	}
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
