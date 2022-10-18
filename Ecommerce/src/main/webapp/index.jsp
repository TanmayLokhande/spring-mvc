<%@page import="com.tan.helper.helper"%>
<%@page import="com.tan.entities.Category"%>
<%@page import="com.tan.Dao.CategoryDao"%>
<%@page import="com.tan.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.tan.Dao.ProductDao"%>
<%@page import="com.tan.helper.FactoryProvider"%>
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

	<div class="row mt-3 mx-2">

		<%
		ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
		List<Product> list = pdao.getAllProducts();

		CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
		List<Category> clist = cdao.getCategories();
		%>

		<!-- show categories -->
		<div class="col-md-2">
			<div class="list-group mt-4">
				<a href="#" class="list-group-item list-group-item-action active">
					All Categories </a>

				<%
				for (Category c : clist) {
				%>
				<a href="#" class="list-group-item list-group-item-action"><%=c.getCategoryTitle()%></a>
				<%
				}
				%>

			</div>

		</div>


		<!-- show products -->
		<div class="col-md-8">

			<div class="row mt-4">
				<div class="col-md-12">

					<div class="card-columns">

						<%
						for (Product p : list) {
						%>
						<div class="card" >
						
							<img style="max-height:270px; max-width:100%;" class="card-img-top mt-2 " src="images/products/<%=p.getpPhoto() %>" alt="Card image cap">
							
							<div class="card-body">
								<h5 class="card-title"> <%=p.getpName() %></h5>
								<p class="card-text"><%= helper.get10Words(p.getpDesc()) %></p>
							</div>
							
							<div class="card-footer">
								<button class="btn custom-bg text-white">Add to cart</button>
								<button class="btn btn-outline-primary ">&#8377; <%= p.getpPrice() %></button>
							
							</div>
						
						</div>

						<%
						}
						%>


					</div>

				</div>
			</div>

		</div>

	</div>



	<%@include file="components/footer.jsp"%>
</body>
</html>