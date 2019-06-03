package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.utils.Constantes;

public class AjouterCollaborateursController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
	    String nom = req.getParameter("nom");
	    String prenom = req.getParameter("prenom");
	    String adresse = req.getParameter("adresse");
	    LocalDate dateNaissance = LocalDate.parse(req.getParameter("date"));
	    String securiteSociale = req.getParameter("securite");
	    
	    if(nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || dateNaissance==null || securiteSociale.length() != 15) {
	    	String errorMessage = "Valeur(s) manquante(s) ou invalides :";
	    	errorMessage+= nom.isEmpty()?" nom,":"";
	    	errorMessage+= prenom.isEmpty()?" prenom,":"";
	    	errorMessage+= adresse.isEmpty()?" adresse,":"";
	    	errorMessage+= (dateNaissance==null)?" date de naissance, ":"";
	    	errorMessage+= (securiteSociale.length() != 15)?" numero de sécurité sociale":"";
	    	resp.sendError(400, errorMessage);
	    }else {
	    	Collaborateur newCollaborateur = new Collaborateur();
	    	newCollaborateur.setNom(nom);
	    	newCollaborateur.setPrenom(prenom);
	    	newCollaborateur.setAdresse(adresse);
	    	newCollaborateur.setDateDeNaissance(dateNaissance);
	    	newCollaborateur.setNumeroSecuriteSociale(securiteSociale);
	    	newCollaborateur.setEmailPro(prenom + "." +nom + "@societe.com");
	    	newCollaborateur.setActif(true);
	    	newCollaborateur.setPhoto("photoFactice.jpg");
	    	
	    	Departement departementInconnu = new Departement();
	    	departementInconnu.setId(-1);
	    	departementInconnu.setNom("Non assigné");
	    	
	    	newCollaborateur.setDepartement(departementInconnu);
	    	newCollaborateur.setIntitulePoste("sans poste");
	    	newCollaborateur.setTelephone("06xxxxxxxx");
	    	
	    	newCollaborateur.setMatricule("M-" + (collabService.listerCollaborateurs().size() + 1));

	    	newCollaborateur.setBanque("");
	    	newCollaborateur.setIban("");
	    	newCollaborateur.setBic("");

	    	collabService.sauvegarderCollaborateur(newCollaborateur);
	    	resp.sendRedirect("http://localhost:8080/sgp/collaborateurs/lister"); 
	    	//req.getRequestDispatcher("/collaborateurs/lister").forward(req, resp);
	    }
	}
}