
<%
String message = (String) session.getAttribute("message");
String type="";



if (message != null) {
	if ( message == "User already exists" ){
		type = "danger";
	}
	else if( message == "Invalid Details" ){
		type = "danger";
	}
	else {
		type = "success";
	}
%>

<div class="alert alert-<%= type %> alert-dismissible fade show"
	role="alert">
	<strong> <%= message %> </strong> 
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>



<%	
}

session.removeAttribute("message");
%>