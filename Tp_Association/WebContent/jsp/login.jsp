<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/toastr.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/booystrap-theme.css">
<script src="<%=request.getContextPath()%>/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/toastr.js"></script>
<script src="<%=request.getContextPath()%>/js/bootsrap.js"></script>

</head>
<body>
	
	<div class="col-md-4">
	</div>
	<div id="body" class="col-md-4">
		<div id="login">
			<h2>Login</h2>
			<form class="form-horizontal" method="POST"
				action="<%=request.getContextPath()%>/frontController/connexion">
				<div class="form-group" style="margin-top:20px;">
					<label class="col-sm-4">Identifiant </label>
					<div class="col-sm-8">
						<input class="form-control" type="text" name="id" />
					</div>

				</div>
				<div class="form-group">
					<label class="col-sm-4">Mot De Passe </label>
					<div class="col-sm-8">
						<input class="form-control" type="password" name="pwd" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<input type="submit" value="Ok">
					</div>
				</div>
			</form>

			<p>
				Pas encore enregistré? <a
					href="<%=request.getContextPath()%>/frontController/inscription">Creez
					votre compte...</a>
			</p>
		</div>
	</div>
	
	<div class="col-md-4">
	</div>
</body>
	<%if(session.getAttribute("handle")=="error"){ %>
   		<script>toastr.error('Authentification failed');</script>
   		<% session.removeAttribute("handle"); %>
   <%} %>
</html>