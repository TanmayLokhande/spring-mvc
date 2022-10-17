<%@page import="com.tan.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="components/header.jsp" %>
<title>Insert title here</title>
</head>
<body>

<%@include file="components/navbar.jsp" %>

<%
	out.println(FactoryProvider.getFactory());

%>

<%@include file="components/footer.jsp" %>
</body>
</html>