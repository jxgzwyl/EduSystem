package com.zikool.edu.home.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zikool.edu.frame.common.GlobalConfigure;
import com.zikool.edu.frame.common.PageDTO;
import com.zikool.edu.home.dao.ITestDAO;
import com.zikool.edu.home.entity.Test;
import com.zikool.edu.home.service.ITestService;

@Service("iTestService")
public class TestServiceImpl implements ITestService {

	@Autowired
	@Qualifier("iTestDAO")
	private ITestDAO testDAO;
	
	@Override
	public PageDTO<Test> findTests(Integer pageIndex, Integer pageSize) {
		PageDTO<Test> pageDto = new PageDTO<Test>(pageIndex, pageSize);
		
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put(GlobalConfigure.PAGINATION_SQL_START, pageDto.getStart());
		parameter.put(GlobalConfigure.PAGINATION_SQL_END, pageDto.getPageSize());
		
		long rowSize = this.testDAO.countTests(parameter);
		List<Test> data = null;
		if(rowSize > 0){
			data = this.testDAO.findTests(parameter);
		}
		
		pageDto.setRowSize(rowSize);
		pageDto.setData(data);
		return pageDto;
	}

	@Override
	public boolean addTest(Test test) throws Exception {
		try {
			boolean flag = this.testDAO.addTest(test) > 0;
			return flag;
		} catch (Exception e) {
			throw new Exception("添加异常", e);
		}
	}

	@Override
	public boolean modifyTest(Test test) throws Exception {
		try {
			boolean flag = this.testDAO.modifyTest(test) > 0;
			return flag;
		} catch (Exception e) {
			throw new Exception("修改异常", e);
		}
	}

	@Override
	public boolean delTests(List<Integer> idTests) throws Exception {
		try {
			Map<String,Object> parameter = new HashMap<String,Object>();
			parameter.put("idTests", idTests);
			boolean flag = this.testDAO.delTests(parameter) > 0;
			return flag;
		} catch (Exception e) {
			throw new Exception("删除异常", e);
		}
	}

}
