<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Fill Product Details</h1>
				<form action="handle-product" method="post">

					<div class="form-group">
						<label for="exampleFormControlInput1">Product Name</label> <input
							type="text" class="form-control" id="exampleFormControlInput1"
							name="name" placeholder="Enter product name">
					</div>

					<div class="form-group">
						<label for="exampleFormControlTextarea1">Product
							Description</label>
						<textarea class="form-control" name="description"
							id="exampleFormControlTextarea1" rows="3"></textarea>
					</div>

					<div class="form-group">
						<label for="exampleFormControlInput1">Product Price</label> <input
							type="text" class="form-control" id="exampleFormControlInput1"
							name="price" placeholder="Enter product price">
					</div>
					
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
					
				</form>

			</div>

		</div>

	</div>

</body>
</html>