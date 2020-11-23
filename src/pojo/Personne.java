package pojo;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.PersonneDAO;

public class Personne {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	protected final PersonneDAO personneDAO = dao.getPersonneDAO();
	private int id;
	private String motDePasse;
	private String nomUtilisateur;
	private String adresse;
	private String prenom;
	private String role;
	private String nom;

	public Personne(Integer id, String role, String motDePasse, String nomUtilisateur, String adresse, String prenom,
			String nom) {
		this.id = id;
		this.motDePasse = motDePasse;
		this.nomUtilisateur = nomUtilisateur;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
	}

	public Personne() {
	};

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean login() {
		return this.personneDAO.login(this);
	}

	public String getRole() {
		return this.role;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public int getId() {
		return this.id;
	}

	public boolean register() {
		return false;
	}

}
