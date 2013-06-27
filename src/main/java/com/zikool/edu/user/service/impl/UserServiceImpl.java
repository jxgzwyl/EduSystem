package com.zikool.edu.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zikool.edu.user.dao.IUserDAO;
import com.zikool.edu.user.entity.User;
import com.zikool.edu.user.service.IUserService;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("iUserDAO")
	private IUserDAO userDAO;
	
	@Override
	public User findByIdentityCard(String userIdentityCard) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("userIdentityCard", userIdentityCard);
		parameter.put("delete", false);
		return this.userDAO.findUserOne(parameter);
	}

}
