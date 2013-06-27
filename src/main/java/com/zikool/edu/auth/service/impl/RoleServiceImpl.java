package com.zikool.edu.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zikool.edu.auth.dao.IRoleDAO;
import com.zikool.edu.auth.entity.RolePrivilege;
import com.zikool.edu.auth.service.IRoleService;

@Service("iRoleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	@Qualifier("iRoleDAO")
	private IRoleDAO roleDAO;
	
	@Override
	public List<RolePrivilege> findOperationByIdUser(Integer userId) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("userId", userId);
		return this.roleDAO.findOperationByIdUser(parameter);
	}

}
