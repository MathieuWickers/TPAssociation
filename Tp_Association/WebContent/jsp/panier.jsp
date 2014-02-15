<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.iut.tp.entities.Article;"%>

<%
	ArrayList<Article> monPanier;
	monPanier = (ArrayList<Article>) session.getAttribute("panier");
	request.setAttribute("list", monPanier);
%>

<jsp:include page="/jsp/header.jsp" />
<h1>
	Panier (<%
	if (monPanier != null) {
%><%=monPanier.size()%>
	<%
		} else {
	%>0<%
		}
	%>
	articles)
</h1>

<%
	if (monPanier != null) {
%>
<table border=2>
	<c:forEach var="prod" items="${list}">
		<tr>
			<td>${prod.code}</td>
			<td>${prod.nom}</td>
			<td>${prod.prix}</td>
		</tr>
	</c:forEach>
</table>
<a href="<%=request.getContextPath() %>/logout/panier">Annuler la commande</a>
<div id="commande">
	<form method="post"
		action="<%=request.getContextPath()%>/frontController/commande">
		<input type="submit" value="Commander" />
	</form>
</div>
<%
	}
%>

</body>
</html>