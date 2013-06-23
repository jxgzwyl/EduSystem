package com.zikool.edu.auth.service;

import java.util.List;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.common.service.BaseService;

public interface UserManagerService extends BaseService{
	public TbUser getUserByLoginNameAndPassword(TbUser user);
	public List getUsers();
}
