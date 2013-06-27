package com.zikool.edu.auth.entity;

import java.io.Serializable;

public class RolePrivilege implements Serializable {

	private static final long serialVersionUID = 8407783319025896786L;

	private Integer id;
	
	private Integer roleId;
	
	private Integer privilegeId;
	
	private String operation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
