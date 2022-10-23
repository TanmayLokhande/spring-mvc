<%@page import="com.practice.entities.Student1"%>
<%@page import="com.practice.entities.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.practice.helper.FactoryProvider"%>
<%@page import="com.practice.dao.BranchDao"%>
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

BranchDao bdao = new BranchDao(FactoryProvider.getFactory());
List<Branch> branches = bdao.getAllBranches();

for(Branch b: branches){ %>
	<h1><%=b.getBranch_name() %>
<% }

%>


</body>
</html>