package com.zikool.edu.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class PrivilegeController {
	@RequestMapping(value="/getMenu.do")
	public @ResponseBody String getMenu(String node){
		StringBuffer sb=new StringBuffer("");
	    if(node==null||node.equals("")){
	        sb.append("[");
	    	sb.append("{text:'学员菜单',id:'0',leaf:false,cls:'folder'},");
	    	sb.append("{text:'辅导老师菜单',id:'1',leaf:false,cls:'folder'},");
	    	sb.append("{text:'管理员菜单',id:'3',leaf:false,cls:'folder'},");
	    	sb.deleteCharAt(sb.length()-1);
	    	sb.append("]");
	    }else{
	    	if(node.equals("0")){
		    	sb.append("[");
		    	sb.append("{text:'项目管理',id:'01',leaf:true,cls:'file',url:'projectList.jsp'},");
		    	sb.append("{text:'公告查看',id:'02',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'课程作业进度管理',id:'03',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'基本信息管理',id:'04',leaf:true,cls:'file',url:'userEdit.jsp'},");
		    	sb.deleteCharAt(sb.length()-1);
		    	sb.append("]");
	    	}else if(node.equals("1")){
		    	sb.append("[");
		    	sb.append("{text:'项目管理',id:'11',leaf:true,cls:'file',url:'studentProject.jsp'},");
		    	sb.append("{text:'公告管理',id:'12',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'课程作业批阅',id:'13',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'基本信息管理',id:'14',leaf:true,cls:'file',url:'userEdit.jsp'},");
		    	sb.deleteCharAt(sb.length()-1);
		    	sb.append("]");
	    	}else if(node.equals("3")){
		    	sb.append("[");
		    	sb.append("{text:'行政单位人员管理',id:'31',leaf:true,cls:'file',url:'studentProject.jsp'},");
		    	sb.append("{text:'项目管理',id:'32',leaf:true,cls:'file',url:'studentProject.jsp'},");
		    	sb.append("{text:'公告管理',id:'33',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'课程及作业资源管理',id:'34',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'基本信息管理',id:'35',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'管理员信息管理',id:'36',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'角色管理',id:'37',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.append("{text:'学情在线督导',id:'38',leaf:true,cls:'file',url:'studentNotice.jsp'},");
		    	sb.deleteCharAt(sb.length()-1);
		    	sb.append("]");
	    	}
	    }
		return sb.toString();
	}
}
