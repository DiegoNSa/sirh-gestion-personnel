package dev.sgp.web;

import dev.sgp.entite.*;
import dev.sgp.service.CollaborateurService;
import dev.sgp.utils.Constantes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateursController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		if(matriculeParam == null) {
			resp.sendError(404,"Un matricule est attendu");
		}else {
			List<Collaborateur> listCollab = collabService.listerCollaborateurs();
			Collaborateur collaborateurAEditer = null;
			for( Collaborateur c : listCollab) {
				if(c.getMatricule().equals(matriculeParam)) {
					collaborateurAEditer = c;
				}
			}
			req.setAttribute("currentCollaborateur", collaborateurAEditer);

			req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
			// recupere la valeur d'un parametre dont le nom est departement
			//resp.setContentType("text/html");
			// code HTML ecrit dans le corps de la reponse
			//resp.getWriter().write("<h1>Edition de collaborateurs</h1>"
			//		+ "<p><b>Matricule : " + matriculeParam + "</b></p>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	    String matricule = req.getParameter("matricule");
	    String titre = req.getParameter("titre");
	    String nom = req.getParameter("nom");
	    String prenom = req.getParameter("prenom");
	    if(matricule == null || titre == null || nom == null || prenom == null) {
			res.sendError(404,"Les paramètres suivants sont incorrects :"
					+ ((matricule == null)?"matricule,":"")
					+ ((titre == null)?"titre,":"")
					+ ((nom == null)?"nom,":"")
					+ ((prenom == null)?"prenom,":""));
	    }else {
	    	res.getWriter().write("Creation d’un collaborateur avec les informations suivantes : <ul>"
	    			+ "<li>" +"matricule=" + matricule +"</li>"
	    			+ "<li>" +"titre=" + titre +"</li>"
	    			+ "<li>" +"nom=" + nom +"</li>"
	    			+ "<li>" +"prenom="+prenom +"</li>"
	    			+ "</ul>");

	    	res.setStatus(201,"Creation d’un collaborateur avec les informations suivantes :"
	    			+ "matricule=" + matricule + ",titre=" + titre + ",nom=" + nom + ",prenom="+prenom);
	    }
	}
}
