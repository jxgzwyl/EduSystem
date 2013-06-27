package com.zikool.edu.home.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zikool.edu.frame.dao.BaseDAO;
import com.zikool.edu.home.dao.ITestDAO;
import com.zikool.edu.home.entity.Test;

@Repository("iTestDAO")
public class TestDAOImpl extends BaseDAO implements ITestDAO {

	private static final String TEST_MAPPER = "TestMapper.";
	
	@Override
	public List<Test> findTests(Map<String, Object> parameter) {
		return this.sqlSession.selectList(TEST_MAPPER+"findTests", parameter);
	}

	@Override
	public long countTests(Map<String, Object> parameter) {
		Object obj = this.sqlSession.selectOne(TEST_MAPPER+"countTests", parameter);
		return obj==null?0L:Long.parseLong(obj.toString());
	}

	@Override
	public int addTest(Test test) {
		return this.sqlSession.insert(TEST_MAPPER+"addTest", test);
	}

	@Override
	public int modifyTest(Test test) {
		return this.sqlSession.update(TEST_MAPPER+"modifyTestByEntity", test);
	}

	@Override
	public int delTests(Map<String, Object> parameter) {
		return this.sqlSession.delete(TEST_MAPPER+"delTests", parameter);
	}

}
