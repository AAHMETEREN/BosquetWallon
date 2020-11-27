package pojo;

import dao.AbstractDAOFactory;
import dao.PersonneDAO;

public class Artiste extends Personne {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	protected final PersonneDAO personneDAO = dao.getPersonneDAO();	private String nomDeScene;
	public final static String role = "artiste";
	int spectacleId;
	int organisateurId;
	public Artiste(int id, String motDePasse, String nomUtilisateur, String adresse, String prenom, String nom,
			String nomDeScene) {
		super(id, role, motDePasse, nomUtilisateur, adresse, prenom, nom);
		this.nomDeScene = nomDeScene;
	}

	public String getNomDeScene() {
		return this.nomDeScene;
	}

	public int getSpectacleId() {
		return this.spectacleId;
	}
	
	public int getOrganisateurId() {
		return this.organisateurId;
	}
	
	public void setNomDeScene(String nomDeScene) {
		this.nomDeScene = nomDeScene;
	}
	
	@Override
	public boolean register() {
		return personneDAO.create(((Artiste) this));
	}
	
	@Override
	public String toString() {
		return this.getNomUtilisateur();
	}
	
	public boolean createArtisteSpectacle(int organisateurId,int spectacleId) {
		this.spectacleId = spectacleId;
		this.organisateurId = organisateurId;
		System.out.println("metier");
		return this.personneDAO.createArtisteSpectacle(this);
	}
}
