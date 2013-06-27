package com.zikool.edu.auth.dao;

import java.util.List;
import java.util.Map;

import com.zikool.edu.auth.entity.RolePrivilege;

public interface IRoleDAO {

	List<RolePrivilege> findOperationByIdUser(Map<String, Object> parameter);

}
