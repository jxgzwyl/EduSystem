package com.zikool.edu.auth.entity;

import java.io.Serializable;

public class Privilege implements Serializable {

	private static final long serialVersionUID = -4155054130090543796L;

	private Integer privilegeId;

	private Integer pid;
	
	private String privilegeName;
	
	private String uri;
	
	private boolean main;
	
	private int orderNo;

	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
}
