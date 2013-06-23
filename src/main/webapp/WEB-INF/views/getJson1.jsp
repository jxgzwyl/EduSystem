<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="utf-8"%>
<%
Thread.sleep(1000*10);
try {
    response.getWriter().write("{name:'1234',nihao:'1234'}");
} catch(Exception ex) {
}
%>