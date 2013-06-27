package com.zikool.edu.home.dao;

import java.util.List;
import java.util.Map;

import com.zikool.edu.home.entity.Test;

public interface ITestDAO {

	List<Test> findTests(Map<String, Object> parameter);

	long countTests(Map<String, Object> parameter);

	int addTest(Test test);

	int modifyTest(Test test);

	int delTests(Map<String, Object> parameter);

}
