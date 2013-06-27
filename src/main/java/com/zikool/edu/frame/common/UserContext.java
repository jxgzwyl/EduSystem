package com.zikool.edu.frame.common;

import java.io.Serializable;

import com.zikool.edu.user.entity.User;

public class UserContext implements Serializable {

	private static final long serialVersionUID = -1260654722380762925L;

	private User currentUser;
	
	private String addressIp;
	
	public UserContext() {
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getAddressIp() {
		return addressIp;
	}

	public void setAddressIp(String addressIp) {
		this.addressIp = addressIp;
	}
	
}
