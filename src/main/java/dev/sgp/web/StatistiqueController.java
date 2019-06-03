package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisitService;
import dev.sgp.utils.Constantes;

public class StatistiqueController extends HttpServlet {
	private VisitService visiteService = Constantes.VISITE_FILTERING;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		
		int nombreVisiteNouveau = 0;
		int nombreVisiteLister = 0;
		int nombreVisiteEditer = 0;

		System.out.println("taille : " + visiteService.listerCollaborateurs().size());

		for(VisiteWeb visite : visiteService.listerCollaborateurs()) {
			System.out.println(visite.getChemin());

			if(visite.getChemin().equals("/sgp/collaborateurs/nouveau")) {
				nombreVisiteNouveau++;
			}
			if(visite.getChemin().equals("/sgp/collaborateurs/lister")) {
				nombreVisiteLister++;
			}
			if(visite.getChemin().equals("/sgp/collaborateurs/editer")) {
				nombreVisiteEditer++;
			}
		}
		req.setAttribute("nombreVisiteNouveau", nombreVisiteNouveau);
		req.setAttribute("nombreVisiteLister", nombreVisiteLister);
		req.setAttribute("nombreVisiteEditer", nombreVisiteEditer);

		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(req, resp);
	}	
}
