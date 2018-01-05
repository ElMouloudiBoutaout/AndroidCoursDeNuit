package app.coursdenuit.coursdenuit.entities;


import java.util.ArrayList;
import java.util.List;



public class Etudiant extends Utilisateur {

	
	private List<Requete> demandes;

	private Object _links;

	public Object get_links() {
		return _links;
	}

	public void set_links(Object _links) {
		this._links = _links;
	}

	public List<Requete> getDemandes() {
		return demandes;
	}

	public Etudiant() {
		super();
		this.demandes = new ArrayList<Requete>();
	}

	public void setDemandes(List<Requete> demandes) {
		this.demandes = demandes;
	}

}
