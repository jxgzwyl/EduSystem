package com.zikool.edu.home.entity;

import java.io.Serializable;
import java.util.Date;

public class Test implements Serializable {

	private static final long serialVersionUID = -3259830219709244744L;

	private Integer idTest;
	
	private String testName;
	
	private Date createTime;
	
	private boolean flag;

	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
