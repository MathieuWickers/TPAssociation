<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="fr.iut.tp.dao.ArticleDAO,fr.iut.tp.entities.Article, java.util.ArrayList,java.util.List"%>

<%
	ArrayList<Article> panier;
	ArticleDAO aDao = new ArticleDAO();
	List<Article> articles = new ArrayList<Article>();
	articles = aDao.listAll();
	request.setAttribute("list", articles);
%>

<jsp:include page="/jsp/header.jsp" />
<h1>Catalogue des articles</h1>
<table border=2>
	<tr>
		<th>Code</th>
		<th>Nom</th>
		<th>Prix</th>
		<th>Stock</th>
		<th></th>
	</tr>

	<c:forEach var="prod" items="${list}">
		<tr>
			<td>${prod.code}</td>
			<td>${prod.nom}</td>
			<td>${prod.stock}</td>
			<td>${prod.prix}</td>
			<td><a
				href="<%=request.getContextPath()%>/frontController/article?prix=${prod.prix}&nom=${prod.nom}&code=${prod.code}">Ajouter au panier</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>