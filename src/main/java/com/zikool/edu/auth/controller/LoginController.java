package com.zikool.edu.auth.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.auth.service.UserManagerService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserManagerService userManagerService;
	
	public UserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	@RequestMapping(value = "/login.do")
	public String login(String userLoginName,String password){
		TbUser user=new TbUser();
		user.setUserLoginName(userLoginName);
		user.setPassword(password);
		userManagerService.getUserByLoginNameAndPassword(user);
		List list=userManagerService.getUsers();
		System.out.println(list.size());
		if(user==null){
			return "home";
		}
		return "";
	}
	
	
	
}
