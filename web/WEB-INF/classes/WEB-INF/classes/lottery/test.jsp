<%@ page import="net.sf.json.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
response.setHeader("Content-Type","text/html;charset=utf-8");
String str="[{\"name\": \"10\",\"weight\":30},{\"name\": \"20\",\"weight\":25},{\"name\": \"30\",\"weight\":10},{\"name\": \"40\",\"weight\":10},{\"name\": \"50\",\"weight\":5},{\"name\": \"100\",\"weight\":3}]";
out.print(str);
out.flush();
out.close();
%>
