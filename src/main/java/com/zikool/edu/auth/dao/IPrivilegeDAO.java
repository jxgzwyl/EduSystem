package com.zikool.edu.auth.dao;

import java.util.List;
import java.util.Map;

import com.zikool.edu.auth.entity.Privilege;

public interface IPrivilegeDAO {

	Privilege queryPrivilegeOne(Map<String, Object> parameter);

	List<Privilege> queryPrivilegeList(Map<String, Object> parameter);

}
