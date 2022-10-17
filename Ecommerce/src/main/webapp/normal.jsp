<%@page import="com.tan.entities.User"%>
<%
	
	User user = (User)session.getAttribute("current_user");
	if( user == null ){
		session.setAttribute("message", "Your are not logged in!! Login first");
		response.sendRedirect("login.jsp");
		return;
	}
	else if( user.getUserType().equals("admin") ){
		session.setAttribute("message", "Your are not Normal User!!");
		response.sendRedirect("login.jsp");
		return;
	} 

%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>normal user panel</h1>



</body>
</html>