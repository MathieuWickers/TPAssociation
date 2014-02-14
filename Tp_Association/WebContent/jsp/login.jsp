<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
	<div id="body">
		<div id="login" >
			<h2>Login</h2>
			<form method="POST" action="<%=request.getContextPath() %>/frontController/connexion">
				<label>Identifiant </label><input type="text" name="id"/><br/>
				<label>Mot De Passe </label><input type="password" name="pwd"/><br/>
				<input type="submit" value="OK"/><br/>
			</form>
			
			<p>Pas encore enregistré? <a href="<%= request.getContextPath() %>/frontController/inscription">Creez votre compte...</a></p>
		</div>
	</div>
	</body>
</html>