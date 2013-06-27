package com.zikool.edu.auth.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zikool.edu.auth.dao.IPrivilegeDAO;
import com.zikool.edu.auth.entity.Privilege;
import com.zikool.edu.frame.dao.BaseDAO;

@Repository("iPrivilegeDAO")
public class PrivilegeDAOImpl extends BaseDAO implements IPrivilegeDAO {

	private static final String PRIVILEGE_MAPPER = "PrivilegeMapper.";
	
	@Override
	public Privilege queryPrivilegeOne(Map<String, Object> parameter) {
		return this.sqlSession.selectOne(PRIVILEGE_MAPPER+"queryPrivilegeOne", parameter);
	}

	@Override
	public List<Privilege> queryPrivilegeList(Map<String, Object> parameter) {
		return this.sqlSession.selectList(PRIVILEGE_MAPPER+"queryPrivilegeList", parameter);
	}

}
