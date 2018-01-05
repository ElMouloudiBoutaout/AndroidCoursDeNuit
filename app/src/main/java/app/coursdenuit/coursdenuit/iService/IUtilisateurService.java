package app.coursdenuit.coursdenuit.iService;


import app.coursdenuit.coursdenuit.entities.Requete;
import app.coursdenuit.coursdenuit.enums.EtatRequete;

public interface IUtilisateurService {
	
	void EnvoyerRequete(Requete req);
	void RecevoireRequete(Requete requete);
 
	 
	 public void accepterRequete(Requete requete);
	 
	 public void refuserRequete(Requete requete) ;

	 
	  public void annulerRequete(Requete requete) ;

	
}
