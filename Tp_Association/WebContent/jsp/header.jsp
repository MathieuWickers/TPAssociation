<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
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
	<div class="raw">
		<div class="col-md-1">
			 <a href="<%=request.getContextPath()%>/frontController/">Accueil</a>
		</div>
		<div class="col-md-1">
			 <a	href="<%=request.getContextPath()%>/frontController/catalogue">Articles</a>
		</div>
		<div class="col-md-1">
			 <a	href="<%=request.getContextPath()%>/frontController/panier">Commande</a>
		</div>
		<div class="col-md-1">
			<a	href="<%=request.getContextPath()%>/frontController/historique">Historique</a>
		</div>
		<div class="col-md-1">
			 <a href="<%=request.getContextPath()%>/logout/deconnexion">D&eacute;connexion</a>
		</div>
		<div class="col-md-5">
		</div>
		<div class="col-md-2">
			 Adherent : <b>${identifiant}</b>
		</div>
	</div>
