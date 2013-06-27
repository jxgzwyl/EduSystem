package com.zikool.edu.user.service;

import com.zikool.edu.user.entity.User;

public interface IUserService {

	User findByIdentityCard(String userIdentityCard);

}
