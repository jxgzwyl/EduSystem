<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="utf-8"%>
<%
try{
    String s=request.getParameter("title");
    System.out.println(s);
    //response.getWriter().write("{success:true}");
    response.getWriter().write("{failure:true}");
} catch(Exception ex) {
}
%>