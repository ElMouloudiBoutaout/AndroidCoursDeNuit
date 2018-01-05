package app.coursdenuit.coursdenuit.iService;

import java.util.List;

import app.coursdenuit.coursdenuit.entities.Requete;
import app.coursdenuit.coursdenuit.enums.EtatRequete;

public interface IRequeteService {
	
	 public void accepterRequete(Requete requete) ;


	public void refuserRequete(Requete requete) ;


	 public void annulerRequete(Requete requete) ;
	
	
	public void supprimerRequete(Requete requete);

	List<Requete> retournerLesRequetes();

	Requete retournerRequeteParId(Long id);

}
