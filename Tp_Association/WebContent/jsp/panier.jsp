<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="fr.iut.tp.entities.Article;" %>
  
		<jsp:include page="/jsp/header.jsp"/>
		<h1>Panier (0 articles)</h1>
		
	<%List<Article> monPanier = (List<Article>) session.getAttribute("panier"); %>
	<table>
	<%	
	for (Article ar : monPanier) {
		System.out.println("<tr><td>"+ar.getNom()+"</td><td>"+ar.getPrix()+"</td></tr>");
	}
	%>
	</table>
	</body>
</html>