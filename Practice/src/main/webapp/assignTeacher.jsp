<%@page import="com.practice.entities.Subject"%>
<%@page import="com.practice.dao.SubjectDao"%>
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

	<form action="assignTeacher" method="post">
		

		<%
		Teacher1Dao tdao = new Teacher1Dao(FactoryProvider.getFactory());
		List<Teacher1> teachers = tdao.getAllteachers();
		%>

		<div class="form-group">
			<label for="Teacher">Select Teacher:</label> <select name="t_Id"
				id="branch">

				<%
				for (Teacher1 b : teachers) {
				%>
				<option value="<%=b.getTeacherId()%>"><%=b.gettName()%></option>
				<%
				}
				%>

			</select>

		</div>
		
		
		<%
		SubjectDao sdao = new SubjectDao(FactoryProvider.getFactory());
		List<Subject> subjects = sdao.getAllSubjects();
		%>
		
		<div class="form-group">
			<label for="Subject">Select Subject:</label> <select name="s_Id"
				id="branch">

				<%
				for (Subject b : subjects) {
				%>
				<option value="<%= b.getSub_id() %>"><%=b.getSub_name()%></option>
				<%
				}
				%>

			</select>

		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>