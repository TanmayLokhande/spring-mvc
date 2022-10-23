<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
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
	<h1><%=b.getBranch_name() %></h1>
	<% 
	Session s = FactoryProvider.getFactory().openSession();
	String hql = "FROM Student1 E WHERE E.branch = :branch_id";
	Query query = s.createQuery(hql);
	query.setParameter("branch_id",b);
	List<Student1> results = query.list();
	for( Student1 stud:results ){ %>
		<h2><%= stud.getStudent_name() %></h2>		
	<% }
		
	%>
<% }

%>


</body>
</html>