package com.zikool.edu.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class PrivilegeController {
	@RequestMapping(value="/getMenu.do")
	public @ResponseBody List<TreeNode> getMenu(String node){
		ArrayList<TreeNode> menu=new ArrayList<TreeNode>();
		
		
		//学员管理菜单
		TreeNode treeNode=new TreeNode();
		treeNode.setId("0");
		treeNode.setText("学员菜单");
		treeNode.setLeaf(false);
		treeNode.setCls("folder");
		ArrayList<TreeNode> children=new ArrayList<TreeNode>();
		
		TreeNode a=new TreeNode();
		a.setCls("file");
		a.setId("01");
		a.setLeaf(true);
		a.setText("项目管理");
		a.setUrl("projectList.jsp");
		
		TreeNode b=new TreeNode();
		b.setCls("file");
		b.setId("02");
		b.setLeaf(true);
		b.setText("公告查看");
		b.setUrl("studentNotice.jsp");
		
		TreeNode c=new TreeNode();
		c.setCls("file");
		c.setId("03");
		c.setLeaf(true);
		c.setText("课程作业进度管理");
		c.setUrl("studentNotice.jsp");
		
		TreeNode d=new TreeNode();
		d.setCls("file");
		d.setId("04");
		d.setLeaf(true);
		d.setText("基本信息管理");
		d.setUrl("studentNotice.jsp");
		
		children.add(a);
		children.add(b);
		children.add(c);
		children.add(d);
		treeNode.setChildren(children);
		
		//辅导老师管理菜单
		TreeNode teacherMenu=new TreeNode();
		teacherMenu.setId("1");
		teacherMenu.setText("辅导老师菜单");
		teacherMenu.setLeaf(false);
		teacherMenu.setCls("folder");
		ArrayList<TreeNode> tchildren=new ArrayList<TreeNode>();
		
		TreeNode ta=new TreeNode();
		ta.setCls("file");
		ta.setId("11");
		ta.setLeaf(true);
		ta.setText("项目管理");
		ta.setUrl("projectList.jsp");
		
		TreeNode tb=new TreeNode();
		tb.setCls("file");
		tb.setId("12");
		tb.setLeaf(true);
		tb.setText("公告查看");
		tb.setUrl("studentNotice.jsp");
		
		TreeNode tc=new TreeNode();
		tc.setCls("file");
		tc.setId("13");
		tc.setLeaf(true);
		tc.setText("课程作业批阅");
		tc.setUrl("studentNotice.jsp");
		
		TreeNode td=new TreeNode();
		td.setCls("file");
		td.setId("14");
		td.setLeaf(true);
		td.setText("基本信息管理");
		td.setUrl("studentNotice.jsp");
		
		tchildren.add(ta);
		tchildren.add(tb);
		tchildren.add(tc);
		tchildren.add(td);
		teacherMenu.setChildren(tchildren);
		
		//管理员管理菜单
		TreeNode adminMenu=new TreeNode();
		adminMenu.setId("3");
		adminMenu.setText("管理员菜单");
		adminMenu.setLeaf(false);
		adminMenu.setCls("folder");
		ArrayList<TreeNode> achildren=new ArrayList<TreeNode>();
		
		TreeNode aa=new TreeNode();
		aa.setCls("file");
		aa.setId("31");
		aa.setLeaf(true);
		aa.setText("行政单位人员管理");
		aa.setUrl("projectList.jsp");
		
		TreeNode ab=new TreeNode();
		ab.setCls("file");
		ab.setId("32");
		ab.setLeaf(true);
		ab.setText("项目管理");
		ab.setUrl("studentNotice.jsp");
		
		TreeNode ac=new TreeNode();
		ac.setCls("file");
		ac.setId("33");
		ac.setLeaf(true);
		ac.setText("公告管理");
		ac.setUrl("studentNotice.jsp");
		
		TreeNode ad=new TreeNode();
		ad.setCls("file");
		ad.setId("34");
		ad.setLeaf(true);
		ad.setText("课程及作业资源管理");
		ad.setUrl("studentNotice.jsp");
		
		TreeNode ae=new TreeNode();
		ae.setCls("file");
		ae.setId("35");
		ae.setLeaf(true);
		ae.setText("基本信息管理");
		ae.setUrl("studentNotice.jsp");
		
		TreeNode af=new TreeNode();
		af.setCls("file");
		af.setId("36");
		af.setLeaf(true);
		af.setText("管理员信息管理");
		af.setUrl("studentNotice.jsp");
		
		TreeNode ag=new TreeNode();
		ag.setCls("file");
		ag.setId("37");
		ag.setLeaf(true);
		ag.setText("角色管理");
		ag.setUrl("studentNotice.jsp");
		
		TreeNode ah=new TreeNode();
		ah.setCls("file");
		ah.setId("38");
		ah.setLeaf(true);
		ah.setText("学情在线督导");
		ah.setUrl("studentNotice.jsp");
		
		achildren.add(aa);
		achildren.add(ab);
		achildren.add(ac);
		achildren.add(ad);
		achildren.add(ae);
		achildren.add(af);
		achildren.add(ag);
		achildren.add(ah);
		adminMenu.setChildren(achildren);
		
		menu.add(treeNode);
		menu.add(teacherMenu);
		menu.add(adminMenu);
		
//		StringBuffer sb=new StringBuffer("");
//	    if(node==null||node.equals("")){
//	        sb.append("[");
//	    	sb.append("{text:'学员菜单',id:'0',leaf:false,cls:'folder'},");
//	    	sb.append("{text:'辅导老师菜单',id:'1',leaf:false,cls:'folder'},");
//	    	sb.append("{text:'管理员菜单',id:'3',leaf:false,cls:'folder'},");
//	    	sb.deleteCharAt(sb.length()-1);
//	    	sb.append("]");
//	    }else{
//	    	if(node.equals("0")){
//		    	sb.append("[");
//		    	sb.append("{text:'项目管理',id:'01',leaf:true,cls:'file',url:'projectList.jsp'},");
//		    	sb.append("{text:'公告查看',id:'02',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'课程作业进度管理',id:'03',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'基本信息管理',id:'04',leaf:true,cls:'file',url:'userEdit.jsp'},");
//		    	sb.deleteCharAt(sb.length()-1);
//		    	sb.append("]");
//	    	}else if(node.equals("1")){
//		    	sb.append("[");
//		    	sb.append("{text:'项目管理',id:'11',leaf:true,cls:'file',url:'studentProject.jsp'},");
//		    	sb.append("{text:'公告管理',id:'12',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'课程作业批阅',id:'13',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'基本信息管理',id:'14',leaf:true,cls:'file',url:'userEdit.jsp'},");
//		    	sb.deleteCharAt(sb.length()-1);
//		    	sb.append("]");
//	    	}else if(node.equals("3")){
//		    	sb.append("[");
//		    	sb.append("{text:'行政单位人员管理',id:'31',leaf:true,cls:'file',url:'studentProject.jsp'},");
//		    	sb.append("{text:'项目管理',id:'32',leaf:true,cls:'file',url:'studentProject.jsp'},");
//		    	sb.append("{text:'公告管理',id:'33',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'课程及作业资源管理',id:'34',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'基本信息管理',id:'35',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'管理员信息管理',id:'36',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'角色管理',id:'37',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.append("{text:'学情在线督导',id:'38',leaf:true,cls:'file',url:'studentNotice.jsp'},");
//		    	sb.deleteCharAt(sb.length()-1);
//		    	sb.append("]");
//	    	}
//	    }
		return menu;
	}
}
