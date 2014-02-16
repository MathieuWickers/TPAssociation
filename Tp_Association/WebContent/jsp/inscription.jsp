<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"><link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/toastr.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/booystrap-theme.css">
<script src="<%=request.getContextPath()%>/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/toastr.js"></script>
<script src="<%=request.getContextPath()%>/js/bootsrap.js"></script>
	<title>Inscription</title>
</head>
<body>
	
	<div class="col-md-2"></div>
	<div id="body" class="col-md-8">
		<div id="inscription">
				<h2>Enregistrez vous</h2>
				<form method="post" action="<%= request.getContextPath() %>/frontController/inscription" class="form-horizontal" role="form">
					<div class="form-group" style="margin-top:20px;">
						<label class="col-sm-4 ">Identifiant <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" name="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4">Mot de passe <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control"s type="password" name="pwd" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Mot de passe(confirm) <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control"s type="password" name="pwdC" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Nom de famille <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" name="ndf" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Pr&eacute;nom <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" name="prenom" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Adresse (rue) <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" name="adresse" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Code Postal <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" name="codepostal" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Ville <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" name="ville" />
						</div>					
					</div>
					<div class="form-group">
						<label class="col-sm-4">Pays <span style="color:#FF0000;">*</span> :</label>
						<div class="col-sm-8">
							<select name="pays" size="1" class="form-control">
								<option selected="selected">France (FR)</option> 
								<option>Allemagne (DE)</option> 
								<option>Espagne (ES)</option> 
							</select>
						</div>					
					</div>
					<div class="col-sm-offset-4 col-sm-8">
						<input type="submit" value="Enregistrer" />
				    </div>
					
				</form>
				<p><span style="color:#FF0000;">*</span>Champ obligatoire</p>
			</div>
		</div>
		<div class="col-md-2"></div>
</body>
	<%if(session.getAttribute("handle")=="log"){ %>
	  	<script>toastr.error('Identifiant d&eacute;j&agrave; utilis&eacute;');</script>
	  	<% session.removeAttribute("handle"); 
	} else if (session.getAttribute("handle")=="mdp"){ %>
	  	<script>toastr.error('Les mots de passe doivent &ecirc;tre identique');</script>
	  	<% session.removeAttribute("handle"); 
	} else if (session.getAttribute("handle")=="oblig"){ %>
	  	<script>toastr.error('Veuillez remplir les champs obligatoire');</script>
	  	<% session.removeAttribute("handle"); 
	} %>
</html>