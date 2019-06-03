<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/js/bootstrap.js">
	
</script>
</head>
<body>

	<%
		Collaborateur currentCollab = (Collaborateur) request.getAttribute("currentCollaborateur");
	%>
	<form action="/sgp/collaborateurs/editer" method="POST">
		<div class="container">
			<div class="row">
				<div class="col">
					<img src="<%=request.getContextPath()%>/images/avatar.png"
						alt="photo" style="max-width: 300px;">
				</div>
				<div class="col">
					<h1><%=currentCollab.getNom()%>
						<%=currentCollab.getPrenom()%></h1>
					<div class="accordion" id="accordionExample">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h2 class="mb-0">
									<button class="btn btn-link" type="button"
										data-toggle="collapse" data-target="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne">
										Identité</button>
								</h2>
							</div>

							<div id="collapseOne" class="collapse show"
								aria-labelledby="headingOne" data-parent="#accordionExample">
								<div class="card-body">

									<div class="row justify-content-between">
										<div class="col-sm">Nom</div>
										<div class="col-sm">
											<input type="text" name="nom"
												value="<%=currentCollab.getNom()%>" readonly>
										</div>
									</div>
									<br>
									<div class="row justify-content-between">
										<div class="col-sm">Prenom</div>
										<div class="col-sm">
											<input type="text" name="prenom"
												value="<%=currentCollab.getPrenom()%>" readonly>
										</div>
									</div>
									<br>
									<div class="row justify-content-between">
										<div class="col-sm">Date de naissance</div>
										<div class="col-sm">
											<input type="text" name="date"
												value="<%=currentCollab.getDateDeNaissance()%>">
										</div>
									</div>
									<br>
									<div class="row justify-content-between">
										<div class="col-sm">Adresse</div>
										<div class="col-sm">
											<input type="text" name="adresse"
												value="<%=currentCollab.getAdresse()%>"
												style="height: 100px;">
										</div>
									</div>
									<br>
									<div class="row justify-content-between">
										<div class="col-sm">Numero de sécurité sociale</div>
										<div class="col-sm">
											<input type="text" name="securite"
												value="<%=currentCollab.getNumeroSecuriteSociale()%>"
												readonly>
										</div>
									</div>

								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h2 class="mb-0">
									<button class="btn btn-link collapsed" type="button"
										data-toggle="collapse" data-target="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">
										Poste</button>
								</h2>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-parent="#accordionExample">
								<div class="card-body">
									<div class="row justify-content-between">
										<div class="col-sm">Intitulé Poste</div>
										<div class="col-sm">
											<input type="text" name="intitule"
												value="<%=currentCollab.getIntitulePoste()%>">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h2 class="mb-0">
									<button class="btn btn-link collapsed" type="button"
										data-toggle="collapse" data-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">
										Coordonnées Banquaire</button>
								</h2>
							</div>
							<div id="collapseThree" class="collapse"
								aria-labelledby="headingThree" data-parent="#accordionExample">
								<div class="card-body">
									<div class="row justify-content-between">
										<div class="col-sm">Banque</div>
										<div class="col-sm">
											<input type="text" name="banque"
												value="<%=currentCollab.getBanque()%>">
										</div>
									</div>
									<br>
									<div class="row justify-content-between">
										<div class="col-sm">Bic</div>
										<div class="col-sm">
											<input type="text" name="bic"
												value="<%=currentCollab.getBic()%>">
										</div>
									</div>
									<br>
									<div class="row justify-content-between">
										<div class="col-sm">Iban</div>
										<div class="col-sm">
											<input type="text" name="iban"
												value="<%=currentCollab.getIban()%>">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<input type="submit" value="Sauvegarder">
					<div class="invisible">
  						<input type="text" name="matricule" value="<%=currentCollab.getMatricule()%>" readonly>
  					</div>
				</div>
			</div>
		</div>
	</form>
	</script>

</body>
</html>