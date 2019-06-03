<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
<h1>Nouveau Collaborateur</h1>
	<form action="/sgp/collaborateurs/ajouter" method="GET">
 		<div class="container">
 			<div class="row justify-content-between">
 				<div class="col-sm">
 					Nom
 				</div>
 				 <div class="col-sm">
 				 	<input type="text" name="nom" value="">
 				</div>
 			</div>
 			<br>
 			<div class="row justify-content-between">
 				<div class="col-sm">
 					Prenom
 				</div>
 				 <div class="col-sm">
  					 <input type="text" name="prenom" value="">
 				</div>
 			</div>
 			<br>
 			<div class="row justify-content-between">
 				<div class="col-sm">
 					Date de naissance
 				</div>
 				 <div class="col-sm">
  		  	   <input type="text" name="date" value="">
 				</div>
 			</div>
 			<br>
 			<div class="row justify-content-between">
 				<div class="col-sm">
 					Adresse
 				</div>
 				 <div class="col-sm">
  					<input type="text" name="adresse" value="" style="height:100px;">
 				</div>
 			</div>
 			<br>
 			<div class="row justify-content-between">
 				<div class="col-sm">
 					Numero de sécurité sociale
 				</div>
 				 <div class="col-sm">
  		  	  <input type="text" name="securite" value="">
 				</div>
 			</div>
 			<br>
 			<div class="row justify-content-between">
 				<div class="col-sm">
 				</div>
 				 <div class="col-sm">
  					<input type="submit" value="Submit">
  					
  					
 				</div>
 			</div>
 		</div>
</form> 
</body>
</html>