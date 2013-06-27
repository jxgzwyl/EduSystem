package com.zikool.edu.user.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zikool.edu.frame.dao.BaseDAO;
import com.zikool.edu.user.dao.IUserDAO;
import com.zikool.edu.user.entity.User;

@Repository("iUserDAO")
public class UserDAOImpl extends BaseDAO implements IUserDAO {

	private static final String USER_MAPPER = "UserMapper.";
	
	@Override
	public User findUserOne(Map<String, Object> parameter) {
		return this.sqlSession.selectOne(USER_MAPPER+"findUserOne", parameter);
	}

}
