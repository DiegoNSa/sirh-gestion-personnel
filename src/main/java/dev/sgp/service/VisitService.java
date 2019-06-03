package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;

public class VisitService {
	List<VisiteWeb> listeVisitesWeb = new ArrayList<>();

	public List<VisiteWeb> listerCollaborateurs() {
		return listeVisitesWeb;
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisitesWeb.add(visite);
	}
}
