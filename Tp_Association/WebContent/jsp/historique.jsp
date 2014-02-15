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
<jsp:include page="/jsp/header.jsp" />

<%
	if (!commandes.isEmpty()) {
%>
<c:forEach var="comm" items="${list}">
	<h4>Commande numero ${comm.commande_Id}</h4>
	<ul>
		<c:forEach var="lart" items="${comm.getArticles()}">
			<li>${lart.nom}</li>
			<li>${lart.prix}</li>
		</c:forEach>
	</ul>
</c:forEach>
<%
	}
%>
</body>
</html>

</body>
</html>