package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateursController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		if(matriculeParam == null) {
			resp.sendError(404,"Un matricule est attendu");
		}else {
			// recupere la valeur d'un parametre dont le nom est departement
			resp.setContentType("text/html");
			// code HTML ecrit dans le corps de la reponse
			resp.getWriter().write("<h1>Edition de collaborateurs</h1>"
					+ "<p><b>Matricule : " + matriculeParam + "</b></p>");
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
	    	res.setStatus(201, "Creation d’un collaborateur avec les informations suivantes :"
	    			+ "matricule=" + matricule + ",titre=" + titre + ",nom=" + nom + ",prenom="+prenom);
	    }
	}
}
