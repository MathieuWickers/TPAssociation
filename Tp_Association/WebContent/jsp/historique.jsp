<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="fr.iut.tp.entities.Article, java.util.ArrayList,java.util.List,fr.iut.tp.services.HistoriqueCommande, fr.iut.tp.entities.Commande"%>


<%
	HistoriqueCommande hc = new HistoriqueCommande();
	String login = (String) session.getAttribute("identifiant");
	List<Commande> commandes = new ArrayList<Commande>();
	commandes = hc.getCommandeAdherent(login);
	request.setAttribute("list", commandes);
%>
	<div class="raw">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<jsp:include page="/jsp/header.jsp" />
		
			<br/><br/><br/><br/>
			<h1>Historique des commandes</h1>
			<br/><br/>

		<%
			if (!commandes.isEmpty()) {
		%>
		<c:forEach var="comm" items="${list}">
			<h4>Commande numero ${comm.commande_Id}</h4>
			<ul>
				<c:forEach var="lart" items="${comm.getArticles()}">
					<li>${lart.nom} : ${lart.prix} €</li>
				</c:forEach>
			</ul>
		</c:forEach>
		<%
			}
		%>
	</div>
	<div class="col-md-2"></div>
	</div>
</body>
</html>