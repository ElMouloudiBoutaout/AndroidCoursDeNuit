package app.coursdenuit.coursdenuit.iService;


import app.coursdenuit.coursdenuit.entities.Requete;

public interface Mediateur {
	
	
    public void transmettreRequeteDeProfesseur(Requete requete);
    public void transmettreRequeteDeEtudiant(Requete requete);

 
}
