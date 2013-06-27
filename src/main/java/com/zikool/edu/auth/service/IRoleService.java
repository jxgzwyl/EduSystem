package com.zikool.edu.auth.service;

import java.util.List;

import com.zikool.edu.auth.entity.RolePrivilege;

public interface IRoleService {

	/**
	 * 根据用户ID获取用户的可以操作的权限
	 * @param userId 用户ID
	 * @return {@code List<RolePrivilege>}
	 */
	List<RolePrivilege> findOperationByIdUser(Integer userId);

}
