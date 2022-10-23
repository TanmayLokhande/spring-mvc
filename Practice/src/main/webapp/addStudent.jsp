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

	<form action="addStudent" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				name="sname" aria-describedby="emailHelp"
				placeholder="Enter Name of Student">
		</div>

		<%
			BranchDao bdao = new BranchDao(FactoryProvider.getFactory());
			List<Branch> branches = bdao.getAllBranches();
		%>

		<div class="form-group">
			<label for="Branch">Choose a Branch:</label> 
			<select name="b_Id" id="branch">
				
				<%
					for( Branch b : branches ){ %>
						<option value="<%= b.getBranch_id() %>"><%= b.getBranch_name() %></option>
					<% }
				%>
				
			</select>

		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>

	</form>

</body>
</html>