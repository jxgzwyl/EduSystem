<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="utf-8"%>
<%
try {
    String node=request.getParameter("node");
    StringBuffer sb=new StringBuffer("");
    if(node==null||node.equals("src")){
        sb.append("[");
    	for(int i=0;i<5;i++){
    		sb.append("{text:'AbstractComponent.js"+i+"',id:'src/AbstractComponent.js"+i+"','leaf':false,cls:'folder'},");
    	}
    	sb.deleteCharAt(sb.length()-1);
    	sb.append("]");
    }else{
    	sb.append("[");
    	for(int i=0;i<5;i++){
    		sb.append("{text:'"+node+i+"',id:'"+node+i+"','leaf':true,cls:'file',url:'complex"+(i+1)+".html'},");
    	}
    	sb.deleteCharAt(sb.length()-1);
    	sb.append("]");
    }
    response.getWriter().write(sb.toString());
} catch(Exception ex) {

}
%>