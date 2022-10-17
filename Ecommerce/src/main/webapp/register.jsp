<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="components/header.jsp"%>
<title>Insert title here</title>

</head>
<body>

	<%@include file="components/navbar.jsp"%>

	<div class="container-fluid">


		<div class="row mt-5">

			<div class="col-md-4 offset-md-4">

				<div class="card">
				
					<%@include file="components/message.jsp" %>

					<div class="card-body px-5">

						<div class="container text-center">
							<img src="images/follow.png" style="max-height: 100px"
								class="img-fluid">
						</div>

						<h3 class="text-center my-3">Sign Up here</h3>

						<form action="register" method="post">
							<div class="form-group">
								<label for="name">User Name</label> <input type="text" name="user_name"
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter username">
							</div>

							<div class="form-group">
								<label for="email">User Email</label> <input type="email" name="user_email"
									class="form-control" id="email" aria-describedby="emailHelp"
									placeholder="Enter email">
							</div>

							<div class="form-group">
								<label for="password">Password</label> <input type="password" name="user-password"
									class="form-control" id="password" aria-describedby="emailHelp"
									placeholder="Enter password">
							</div>

							<div class="form-group">
								<label for="phone">Mobile number</label> <input type="number" name="user-phone"
									class="form-control" id="phone" aria-describedby="emailHelp"
									placeholder="Enter mobile number">
							</div>

							<div class="form-group">
								<label for="password">Address</label>
								<textarea style="height: 200px" class="form-control" name="user_address"
									placeholder="Enter your Address"></textarea>
							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-outline-success">Register</button>
								<button type="reset" class="btn btn-outline-warning">Reset</button>

							</div>
						</form>
					</div>

				</div>

			</div>

		</div>


	</div>


	<%@include file="components/footer.jsp"%>
</body>
</html>