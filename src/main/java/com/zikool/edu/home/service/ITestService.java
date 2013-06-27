package com.zikool.edu.home.service;

import java.util.List;

import com.zikool.edu.frame.common.PageDTO;
import com.zikool.edu.home.entity.Test;

public interface ITestService {

	PageDTO<Test> findTests(Integer pageIndex, Integer pageSize);

	boolean addTest(Test test) throws Exception;

	boolean modifyTest(Test test) throws Exception;

	boolean delTests(List<Integer> idTests) throws Exception;

}
