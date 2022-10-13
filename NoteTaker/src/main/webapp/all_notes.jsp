<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="header.jsp"%>
<title>All Notes</title>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>All Notes</h1>

		<div class="row">
			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();

				for (Note note : list) {
				%>


				<div class="card mt-3">
					<img class="card-img-top m-4" style="max-width:100px;" src="images/post-it.png" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=note.getTitle() %></h5>
						<p class="card-text"><%=note.getContent() %></p>
						<div class="container text-center">
						<a href="edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
						<a href="deleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
						</div>
					</div>
				</div>


				<%
				}

				s.close();
				%>
			</div>
		</div>


	</div>



	<%@include file="footer.jsp"%>
</body>
</html>