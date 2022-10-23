<%@page import="java.util.List"%>
<%@page import="com.practice.entities.Student1"%>
<%@page import="com.practice.helper.FactoryProvider"%>
<%@page import="com.practice.dao.Student1Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	Student1Dao sdao = new Student1Dao(FactoryProvider.getFactory());
	List<Student1> students = sdao.getAllStudents();
	
	for( Student1 s:students ){ %>
		<h2> <%= s.getStudent_name() %> </h2>
		<h3><%= s.getBranch().getBranch_name() %></h3>
	<% }
	
%>





</body>
</html>