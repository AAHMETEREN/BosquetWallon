package pojo;

import dao.AbstractDAOFactory;
import dao.PersonneDAO;

public class Artiste extends Personne {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	protected final PersonneDAO personneDAO = dao.getPersonneDAO();
	private String nomDeScene;
	public final static String role = "artiste";
	private Spectacle spectacle;
	private Personne organisateur;

	public Artiste(int id, String motDePasse, String nomUtilisateur, String adresse, String prenom, String nom,
			String nomDeScene) {
		super(id, role, motDePasse, nomUtilisateur, adresse, prenom, nom);
		this.nomDeScene = nomDeScene;
	}

	public String getNomDeScene() {
		return this.nomDeScene;
	}

	public Spectacle getSpectacle() {
		return this.spectacle;
	}

	public Personne getOrganisateur() {
		return this.organisateur;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	public void setOrganisateur(Personne organisateur) {
		this.organisateur = organisateur;
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

	public boolean create() {
		return this.personneDAO.createArtisteSpectacle(this);
	}
}
