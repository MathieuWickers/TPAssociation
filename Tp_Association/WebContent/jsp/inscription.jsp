<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
	<title>Inscription</title>
</head>
<body>
	<div id="body">
		<div id="inscription">
			<h2>Enregistrez vous</h2>
			<form method="post" action="<%= request.getContextPath() %>/frontController/inscription">
				<label>Identifiant :</label> <input type="text" name="id" /><span style="color:#FF0000;">*</span><br/> 
				<label>Mot de passe :</label> <input type="password" name="pwd" /><span style="color:#FF0000;">*</span><br/>
				<label>Mot de passe(confirm) :</label> <input type="password" name="pwdC" /><span style="color:#FF0000;">*</span><br/>
				<label>Nom de famille :</label> <input type="text" name="ndf" /><span style="color:#FF0000;">*</span><br/> 
				<label>Prenom :</label> <input type="text" name="prenom" /><span style="color:#FF0000;">*</span><br/> 
				<label>Adresse (rue) :</label> <input type="text" name="adresse" /><br/>
				<label>Code Postal :</label> <input type="text" name="codepostal" /><br/> 
				<label>Ville :</label> <input type="text" name="ville" /><br/> 	
				<label>Pays</label> <select name="pays" size="1">
					<option selected="selected">France (FR)</option> 
					<option>Allemagne (DE)</option> 
					<option>Espagne (ES)</option> 
				</select><br/>
				<input type="submit" value="Enregistrer" />
			</form>
			<p><span style="color:#FF0000;">*</span>Champ obligatoire</p>
		</div>
	</div>
</body>
</html>