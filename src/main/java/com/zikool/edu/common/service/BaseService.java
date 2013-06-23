package com.zikool.edu.common.service;
public interface BaseService {
	public void save(Object entity);
	public void update(Object entity);
	public void delete(Object ... entityids);
	public Object find(Object entityId);
}
