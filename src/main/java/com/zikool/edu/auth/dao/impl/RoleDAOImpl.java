package com.zikool.edu.auth.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zikool.edu.auth.dao.IRoleDAO;
import com.zikool.edu.auth.entity.RolePrivilege;
import com.zikool.edu.frame.dao.BaseDAO;

@Repository("iRoleDAO")
public class RoleDAOImpl extends BaseDAO implements IRoleDAO {

	private static final String ROLE_MAPPER = "RoleMapper.";

	private static final String ROLE_PRIVILEGE_MAPPER = "RolePrivilegeMapper.";
	
	private static final String ROLE_USER_MAPPER = "RoleUserMapper.";
	
	@Override
	public List<RolePrivilege> findOperationByIdUser(Map<String, Object> parameter) {
		return this.sqlSession.selectList(ROLE_PRIVILEGE_MAPPER+"findOperationByIdUser", parameter);
	}

}
