package com.zikool.edu.common.dao;
import java.util.List;

public interface DAO{
	public void save(Object entity);
	public void update(Object entity);
	public void delete(Object ... entityids);
	public Object find(Object entityId);
	public List selectByWhereSql(String sql);
}

