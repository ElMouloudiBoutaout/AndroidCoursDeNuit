package app.coursdenuit.coursdenuit.service;


import app.coursdenuit.coursdenuit.entities.Requete;
import app.coursdenuit.coursdenuit.iService.Mediateur;
import  app.coursdenuit.coursdenuit.iService.IUtilisateurService;
public class ConcreteMediateur implements Mediateur {

	private IUtilisateurService profService;

	private IUtilisateurService etudiantService;

	public void setProfService(IUtilisateurService profService) {
		this.profService = profService;
	}

	public void setEtudiantService(IUtilisateurService etudiantService) {
		this.etudiantService = etudiantService;
	}

	public void transmettreRequeteDeProfesseur(Requete requete) {
		etudiantService.RecevoireRequete(requete);
	}

	public void transmettreRequeteDeEtudiant(Requete requete) {
		System.out.println(requete.getExpediteur().getNom());
		profService.RecevoireRequete(requete);
	}

}
