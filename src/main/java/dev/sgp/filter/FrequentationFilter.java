package dev.sgp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisitService;
import dev.sgp.utils.Constantes;

public class FrequentationFilter implements Filter {
	private VisitService visiteService = Constantes.VISITE_FILTERING;
	
	private FilterConfig config = null;
	private static int visitCount = 0;
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub	
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		
		VisiteWeb newVisit = new VisiteWeb();
		String path = ((HttpServletRequest) req).getRequestURI();
		newVisit.setChemin(path);
		newVisit.setId(visitCount++);
		newVisit.setTempsExecution((int)(after-before));
		visiteService.sauvegarderVisite(newVisit);
		System.out.println("filtering " + visiteService.listerCollaborateurs().size());
		

	}
	
	public void destroy() {
		
	}

}
