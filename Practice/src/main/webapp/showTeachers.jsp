<%@page import="com.practice.entities.Subject"%>
<%@page import="com.practice.entities.Teacher1"%>
<%@page import="java.util.List"%>
<%@page import="com.practice.helper.FactoryProvider"%>
<%@page import="com.practice.dao.Teacher1Dao"%>
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
	Teacher1Dao tdao = new Teacher1Dao(FactoryProvider.getFactory());
	List<Teacher1> teachers =  tdao.getAllteachers();
	for( Teacher1 t:teachers ){ %>
		<h1><%=t.gettName() %></h1>
		<%
			List<Subject> subjects = t.getSubjects();
			for( Subject s: subjects ){ %>
				<h2><%= s.getSub_name() %></h2>
			<% }
		%>
	<% }
%>

</body>
</html>