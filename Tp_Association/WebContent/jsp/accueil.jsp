<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="fr.iut.tp.entities.Article, java.util.ArrayList,java.util.List"%>
		
		<div class="raw">
			<div class="col-md-2"></div>
			<div class="col-md-8">
			<jsp:include page="/jsp/header.jsp"/>
			<br/><br/><br/><br/>
			
				<h3 class="text-muted">Bienvenue  sur le site des adherents de l'association des poneys roses du chaos</h3>
				<ul>
					<li><a href="<%=request.getContextPath() %>/frontController/catalogue">Consulter les articles disponibles</a></li>
					<li><a href="<%=request.getContextPath()%>/frontController/panier">Consulter votre commande</a></li>
				</ul>
			</div>
			<div class="col-md-2"></div>
		</div>
	</body>
	<%if(session.getAttribute("handle")=="commande"){ %>
	  	<script>toastr.success('Commande effectu&eacute;e');</script>
	  	<% session.removeAttribute("handle"); 
	}%>
</html>

