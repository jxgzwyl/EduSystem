package com.zikool.edu.home.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Integer pageIndex, Integer pageSize) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
		return "complex4";
	}
	
	@RequestMapping(value = "/getForm.do", method = RequestMethod.GET)
	public String getForm(Locale locale, Model model, Integer pageIndex, Integer pageSize) {
		return "getForm";
	}
	
	@RequestMapping(value = "/getJson.do", method = RequestMethod.GET)
	public String getJson(Locale locale, Model model, Integer pageIndex, Integer pageSize) {
		return "getJson";
	}
	
	@RequestMapping(value = "/getTree.do", method = RequestMethod.GET)
	public String getTree(Locale locale, Model model, Integer pageIndex, Integer pageSize) {
		return "getTree";
	}
	
	@RequestMapping(value = "/getTreePanel.do", method = RequestMethod.GET)
	public String getTreePanel(Locale locale, Model model, Integer pageIndex, Integer pageSize) {
		return "treePanelForm";
	}
}
