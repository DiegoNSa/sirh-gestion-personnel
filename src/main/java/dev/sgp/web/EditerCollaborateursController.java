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
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	    String matricule = req.getParameter("matricule");
	    String nom = req.getParameter("nom");
	    String prenom = req.getParameter("prenom");
	    if(matricule == null || nom == null || prenom == null) {
			res.sendError(404,"Les paramètres suivants sont incorrects :"
					+ ((matricule == null)?"matricule,":"")
					+ ((nom == null)?"nom,":"")
					+ ((prenom == null)?"prenom,":""));
	    }else {
	    	String banque = req.getParameter("banque");
		    String iban = req.getParameter("iban");
		    String bic = req.getParameter("bic");
		    String intitulePoste = req.getParameter("intitule");

		    
	    	
			List<Collaborateur> listCollab = collabService.listerCollaborateurs();
			Collaborateur collaborateurAEditer = null;
			for( Collaborateur c : listCollab) {
				if(c.getMatricule().equals(matricule)) {
					collaborateurAEditer = c;
				}
			}
			collaborateurAEditer.setBanque(banque);
			collaborateurAEditer.setBic(bic);
			collaborateurAEditer.setIban(iban);
			collaborateurAEditer.setIntitulePoste(intitulePoste);
			
			
	    	res.sendRedirect("http://localhost:8080/sgp/collaborateurs/lister"); 
	    }
	}
}
