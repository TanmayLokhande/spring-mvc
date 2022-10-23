<%@page import="com.practice.entities.Teacher1"%>
<%@page import="com.practice.entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.practice.helper.FactoryProvider"%>
<%@page import="com.practice.dao.SubjectDao"%>
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
	SubjectDao sdao = new SubjectDao(FactoryProvider.getFactory());
	List<Subject> subjects = sdao.getAllSubjects();
	
	for( Subject s: subjects ){ %>
		<h2><%= s.getSub_name() %></h2>
		<% 
			List<Teacher1> teachers = s.getTeacher();
			
			for( Teacher1 t: teachers ){ %>
				<h3><%= t.gettName() %></h3>
			<% }  
		%>
	<% }
	
%>

</body>
</html>