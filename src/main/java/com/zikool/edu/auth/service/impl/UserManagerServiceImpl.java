package com.zikool.edu.auth.service.impl;

import java.util.List;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.auth.dao.UserDao;
import com.zikool.edu.auth.service.UserManagerService;

public class UserManagerServiceImpl implements UserManagerService{
	private UserDao userDao;
	
	public TbUser getUserByLoginNameAndPassword(TbUser user) {
		return (TbUser) userDao.find(1);
	}
	public List getUsers(){
		return userDao.selectByWhereSql("1=1");
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void delete(Object... entityids) {
		userDao.delete(entityids);
	}

	public Object find(Object entityId) {
		return userDao.find(entityId);
	}

	public void save(Object entity) {
		userDao.save(entity);
	}

	public void update(Object entity) {
		userDao.update(entity);
	}
	
}
