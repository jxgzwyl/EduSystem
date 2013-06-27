package com.zikool.edu.home.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zikool.edu.frame.common.JSONResponse;
import com.zikool.edu.frame.common.PageDTO;
import com.zikool.edu.home.entity.Test;
import com.zikool.edu.home.service.ITestService;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	@Qualifier("iTestService")
	private ITestService testService;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="/list.do")
	public String listTests(Model model, Integer pageIndex, Integer pageSize){
		PageDTO<Test> pageDto = this.testService.findTests(pageIndex, pageSize);
		model.addAttribute("pageDto", pageDto);
		return "test/list";
	}
	
	@RequestMapping(value="/listjson.do")
	public @ResponseBody JSONResponse listJsonTests(Model model, Integer pageIndex, Integer pageSize){
		PageDTO<Test> pageDto = this.testService.findTests(pageIndex, pageSize);
		JSONResponse json = new JSONResponse();
		json.setData(pageDto);
		json.setSuccess(true);
		return json;
	}
	
	@RequestMapping(value="/add.do")
	public @ResponseBody JSONResponse addTest(Test test){
		JSONResponse json = new JSONResponse();
		try {
			test.setCreateTime(new Date());
			test.setFlag(false);
			test.setTestName("张三");
			boolean flag = this.testService.addTest(test);
			json.setSuccess(flag);
			json.setData(test);
			if(flag) json.setMsg("添加成功!"); else json.setMsg("添加失败!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			json.setMsg("添加TEST异常!");
		}
		return json;
	}
	
	@RequestMapping(value="/modify.do")
	public @ResponseBody Map<String,Object> modifyTest(Test test){
		Map<String,Object> json = new HashMap<String,Object>();
		if(test.getIdTest() == null){
			json.put("message", "请选择需要修改的TEST");
			return json;
		}
		try {
			boolean flag = this.testService.modifyTest(test);
			json.put("success", flag);
			json.put("data", test);
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			json.put("message","修改TEST异常!");
		}
		
		return json;
	}
	
	@RequestMapping(value="/del.do")
	public @ResponseBody JSONResponse delTests(@RequestParam(value="idTests") Integer[] idTests){
		JSONResponse json = new JSONResponse();
		try {
			boolean flag = this.testService.delTests(Arrays.asList(idTests));
			json.setSuccess(flag);
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			json.setMsg("删除TEST异常!");
		}
		return json;
	}
	
}
