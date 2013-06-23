package com.zikool.edu.auth.service.impl;

import java.util.List;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.auth.dao.UserDao;
import com.zikool.edu.auth.service.UserManagerService;

public class UserManagerServiceImpl implements UserManagerService{
	private UserDao userDao;
	
	@Override
	public TbUser getUserByLoginNameAndPassword(TbUser user) {
		return (TbUser) userDao.find(1);
	}
	@Override
	public List getUsers(){
		return userDao.selectByWhereSql("1=1");
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void delete(Object... entityids) {
		userDao.delete(entityids);
	}

	@Override
	public Object find(Object entityId) {
		return userDao.find(entityId);
	}

	@Override
	public void save(Object entity) {
		userDao.save(entity);
	}

	@Override
	public void update(Object entity) {
		userDao.update(entity);
	}
	
}
