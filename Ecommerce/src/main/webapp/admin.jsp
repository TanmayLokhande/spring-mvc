
<%@page import="com.tan.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.tan.helper.FactoryProvider"%>
<%@page import="com.tan.Dao.CategoryDao"%>
<%@page import="com.tan.entities.User"%>
<%
User user = (User) session.getAttribute("current_user");
if (user == null) {

	session.setAttribute("message", "You are not logged in!!Login first");
	response.sendRedirect("login.jsp");
	return;
} else {
	if (user.getUserType().equals("normal")) {
		session.setAttribute("message", "You are not admin");
		response.sendRedirect("login.jsp");
		return;
	}

}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="components/header.jsp"%>
<title>Admin panel</title>
</head>
<body>

	<%@include file="components/navbar.jsp"%>

	<div class="container admin">

		<div class="container-fluid mt-3">
			<%@include file="components/message.jsp"%>
		</div>

		<div class="row mt-3">

			<div class="col-md-4">

				<div class="card">
					<div class="card-body text-center">

						<div class="container">
							<img style="max-width: 125px" class="rounded-circle img-fluid"
								src="images/man (1).png">
						</div>
						<h1>123</h1>
						<h1 class="text-uppercase text-muted">Users</h1>
					</div>
				</div>

			</div>

			<div class="col-md-4">

				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 125px" class="rounded-circle img-fluid"
								src="images/list.png">
						</div>
						<h1>123</h1>
						<h1 class="text-uppercase text-muted">Categories</h1>
					</div>
				</div>

			</div>

			<div class="col-md-4">

				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 125px" class="rounded-circle img-fluid"
								src="images/delivery-box.png">
						</div>
						<h1>123</h1>
						<h1 class="text-uppercase text-muted">Products</h1>
					</div>
				</div>

			</div>

		</div>

		<div class="row mt-3">

			<div class="col-md-6">

				<div class="card" data-toggle="modal"
					data-target="#add_category_modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 125px" class="rounded-circle img-fluid"
								src="images/menu.png">
						</div>
						<p class="mt-2">Click here to add new category</p>
						<h1 class="text-uppercase text-muted">Add Category</h1>
					</div>
				</div>

			</div>

			<div class="col-md-6">

				<div class="card" data-toggle="modal"
					data-target="#add_product_modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 125px" class="rounded-circle img-fluid"
								src="images/plus.png">
						</div>
						<p class="mt-2">Click here to add new products</p>

						<h1 class="text-uppercase text-muted">Add product</h1>
					</div>
				</div>

			</div>
		</div>


	</div>


	<!-- add category modal -->


	<!-- Modal -->
	<div class="modal fade" id="add_category_modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Fill Category
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form action="productOperation" method="post">

						<input type="hidden" name="operation" value="addCategory">

						<div class="form-group">
							<input type="text" class="form-control" name="catTitle"
								placeholder="Enter category title" required />
						</div>

						<div class="form-group">
							<textarea style="height: 250px;" class=" form-control"
								placeholder="Enter category Description" name="catDescription"
								required></textarea>
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Add Category</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</form>

				</div>

			</div>
		</div>
	</div>
	<!-- end category modal -->



	<!-- product modal -->


	<!-- Modal -->
	<div class="modal fade" id="add_product_modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Product details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form>

						<div class="form-group">
							<input class="form-control" type="text"
								placeholder="Enter title of product" name="pName" required>
						</div>


						<div class="form-group">
							<textarea style="height: 150px;" class="form-control"
								placeholder="Enter discription of product" name="pDesc"></textarea>
						</div>

						<div class="form-group">
							<input class="form-control" type="number"
								placeholder="Enter price of product" name="pPrice" required>
						</div>

						<div class="form-group">
							<input class="form-control" type="number"
								placeholder="Enter product discount" name="pDiscount" required>
						</div>

						<div class="form-group">
							<input class="form-control" type="number"
								placeholder="Enter Quantity" name="pQuantity" required>
						</div>

						<%
						CategoryDao cDao = new CategoryDao(FactoryProvider.getFactory());
						List<Category> list = cDao.getCategories();
						%>

						<div class="form-group">
							<select name="catId" id="" class="form-control">
								<%
								for (Category c : list) {
								%>
								<option value="<%=c.getCategoryId()%>"><%=c.getCategoryTitle()%></option>
								<%
								}
								%>


							</select>
						</div>


						<div class="form-group">
							<label for="pPic">Select picture of product</label> <br> <input
								class="form-control" id="pPic" type="file" name="pPic" required>
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Add Product</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</form>



				</div>
				
			</div>
		</div>
	</div>

	<!-- end product modal -->

	<%@include file="components/footer.jsp"%>
</body>
</html>