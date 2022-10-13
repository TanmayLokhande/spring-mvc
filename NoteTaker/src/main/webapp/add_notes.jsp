<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="header.jsp"%>
<title>Add Notes</title>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>Add Notes</h1>


		<!-- form for adding notes -->
		<form action="SaveNoteServlet" method="post">

			<div class="form-group">
				<label for="title">Note Title</label> <input required type="text"
					name="title" class="form-control" id="title" aria-describedby="emailHelp"
					placeholder="Enter here">
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required class="form-control" style="height: 300px" id="content"
					name="content" placeholder="Enter your content"></textarea>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>

		</form>

	</div>

	<%@include file="footer.jsp"%>
</body>
</html>