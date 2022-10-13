<!doctype html>
<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<%@include file="header.jsp"%>
<title>Edit</title>
</head>
<body>


	<div class="container">
		<%@include file="navbar.jsp"%>

		<%
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());

			Session s = FactoryProvider.getFactory().openSession();

			Note note = (Note)s.get(Note.class, noteId);
		%>

		<form action="updateServlet" method="post">
			
			 <input value="<%= note.getId() %>" name="noteId" type="hidden"/>
			
			<div class="form-group">
				<label for="title">Note Title</label> <input required type="text"
					name="title" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here" value="<%=note.getTitle() %>">
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required class="form-control" style="height: 300px"
					id="content" name="content" placeholder="Enter your content" ><%=note.getContent() %></textarea>
					
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save your note</button>
			</div>

		</form>

	</div>

	<%@include file="footer.jsp"%>
</body>
</html>