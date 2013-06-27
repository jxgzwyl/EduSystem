package com.zikool.edu.user.dao;

import java.util.Map;

import com.zikool.edu.user.entity.User;

public interface IUserDAO {

	User findUserOne(Map<String, Object> parameter);

}
