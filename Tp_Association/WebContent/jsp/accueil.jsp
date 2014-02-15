<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="fr.iut.tp.entities.Article, java.util.ArrayList,java.util.List"%>

		<jsp:include page="/jsp/header.jsp"/>
		<h1>Bienvenue  sur le site des adherents de l'association des paunays roses du chaos</h1>
		<ul>
			<li><a href="<%=request.getContextPath() %>/frontController/catalogue">Consulter les articles disponibles</a></li>
			<li><a href="#">Consulter votre commande</a></li>
		</ul>		
	</body>
</html>