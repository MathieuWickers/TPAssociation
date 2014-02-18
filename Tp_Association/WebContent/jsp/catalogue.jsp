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
	<div class="raw">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<jsp:include page="/jsp/header.jsp" />
			<br/><br/><br/><br/>
			<h1>Catalogue des articles</h1>
			<br/><br/>
			<table border=2 class="table">
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
						<td>${prod.prix} €</td>
						<td>${prod.stock}</td>
						<td><a
							href="<%=request.getContextPath()%>/frontController/article?prix=${prod.prix}&nom=${prod.nom}&code=${prod.code}">Ajouter
								au panier</a></td>
					</tr>
				</c:forEach>		
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
<%if(session.getAttribute("handle")=="succes"){ %>
	  	<script>toastr.success('Article ajout&eacute; au panier');</script>
	  	<% session.removeAttribute("handle"); 
	} %>
</html>