package com.zikool.edu.frame.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseDAO {

	@Autowired
	@Qualifier("sqlSession")
	protected SqlSessionTemplate sqlSession;

}
