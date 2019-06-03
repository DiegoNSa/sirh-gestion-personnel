<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>

<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<form action="/sgp/collaborateurs/lister" method="GET">
		<div class="container">
			<div class="row">
				<h1>Les collaborateurs</h1>
			</div>
			<div class="row">

				<div class="col">
					<div class="d-inline-flex p-2 bd-highlight">Rechercher un nom
						ou un prenom qui commence par</div>

					<div class="d-inline-flex p-2 bd-highlight">
						<input type="text" name="recherche" value="">
					</div>
					<div class="d-inline-flex p-2 bd-highlight">
						<input type="submit" value="Rechercher">
					</div>

				</div>

				<div class="col-md-auto">bli bla blo</div>
			</div>
	</form>

	<div class="container">
		<div class="row">

			<%
				String rechercheOption =  request.getParameter("recherche");
				if(rechercheOption == null){
					rechercheOption = "";
				}

				List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");
				for (Collaborateur collaborateur : listeNoms) {
					if(collaborateur.getNom().startsWith(rechercheOption)){
			%>

			<div class="col">
				<div class="mb-3">
					<div class="card " style="width: 30rem;">
						<div class="card-body p-0 m-0">
							<div class="card-header">
								<h5 class="card-title"><%=collaborateur.getNom()%>
									<%=collaborateur.getPrenom()%>
								</h5>
							</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<div class="container">
										<div class="row">
											<div class="col-2">
												<img src="<%=request.getContextPath()%>/images/avatar.png" alt="photo" style="width: 60px;">
											</div>
											<div class="col-10">
												<div class="container">
													<div class="row justify-content-between">
														<div class="col">Fonction</div>
														<div class="col"><%=collaborateur.getIntitulePoste()%></div>
													</div>
													<div class="row justify-content-between">
														<div class="col">Departement</div>
														<div class="col"><%=collaborateur.getDepartement().getNom()%></div>
													</div>
													<div class="row justify-content-between">
														<div class="col">Email</div>
														<div class="col">
															<%=collaborateur.getEmailPro()%>
														</div>
													</div>
													<div class="row justify-content-between">
														<div class="col">Telephone</div>
														<div class="col">
															<%=collaborateur.getTelephone()%>
														</div>
													</div>

													<div class="row">
														<div class="row justify-content-between">

															<div class="col-sm"></div>
															<div class="col-sm">
																<input type="button" value="Editer"
																	onclick="location.href='/sgp/collaborateurs/editer?matricule=<%=collaborateur.getMatricule()%>'">
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<%
				}
				}
			%>
		</div>
	</div>


</body>
</html>