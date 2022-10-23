<%@page import="com.practice.entities.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.practice.dao.BranchDao"%>
<%@page import="com.practice.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	

	<!-- Add students -->
	<br><br>
	
	<a href="addStudent.jsp">Add student</a>
	
	<!-- ----------- -->
	
	<!-- Add Branch -->
	<br><br>
	<a href="addBranch.jsp">Add Branch</a>

	<!-- ---------- -->
	
	<!-- Add Subject -->
	
	<br><br>
	<a href="addSubject.jsp">Add Subject</a>
	
	<!-- ----------- -->


	<!-- Add teacher -->
	
	<br><br>
	<a href="addTeacher.jsp">Add Teacher</a>
	
	<!-- ----------- -->

	<!-- Assign teacher to a subject -->
	<br><br>
	<a href="assignTeacher.jsp">Assign Teacher to a subject</a>
	<!-- ----------- -->
	
	
	<!-- Show all students -->
	<br><br>
	<a href="showStudents.jsp">Show All Students</a>
	<!-- ----------- -->

	<!-- Show all branches -->
	<br><br>
	<a href="showBranches.jsp">Show All Branches</a>
	<!-- ----------- -->
	
	<!-- Show all subjects -->
	<br><br>
	<a href="showSubjects.jsp">Show All Subjects</a>
	<!-- ----------- -->

	<!-- Show all Teachers -->
	<br><br>
	<a href="showTeachers.jsp">Show All Teachers</a>
	<!-- ----------- -->



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>