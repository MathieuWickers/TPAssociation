<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogue</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<h1>Catalogue des articles</h1>
	/*
		admettons que la methode qui recupere toute la table Article
		renvoit une arrayList.
		
	*/
	
	<table border=2>
		<tr>
			<th>Code</th>
			<th>Nom</th>
			<th>Prix</th>
			<th>Stock</th>
			<th></th>
		</tr>
		
		<c:forEach var="prod" items="<%=request.getContextPath()%>/*pas fini*/">
			<td>${prod.code}</td>
			<td>${prod.nom}</td>
			<td>${prod.prix}</td>
			<td>${prod.stock}</td>
			<td><a href="#">Commander</a></td>
		</c:forEach>
		
	</table>
	
</body>
</html>