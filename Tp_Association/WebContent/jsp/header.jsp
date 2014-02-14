<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Accueil</title>	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<table border=2 id="header">
		<tr>
			<td id="accueil"><a href="#">Accueil</a></td>
			<td id="article"><a href="#">Articles</a></td>
			<td id="commande"><a href="#">Commande</a></td>
			<td id="deconnexion"><a href="<%=request.getContextPath()%>/logout">D&eacute;connexion</a></td>
			<td id="blank"></td>
			<td id="adherent">Adherent : <b>${identifiant}</b></td>
		</tr>
		</table>
