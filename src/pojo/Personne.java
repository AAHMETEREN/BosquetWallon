package pojo;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.PersonneDAO;
import utils.Hash;

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
			String nom)  {
		
		String hashedPassword;
		try {
			hashedPassword = Hash.hashPassword(motDePasse);
			this.motDePasse = hashedPassword;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id = id;
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

	public void setMotDePasse(String motDePasse) throws NoSuchAlgorithmException {
		String hashedPassword = Hash.hashPassword(motDePasse);
		this.motDePasse = hashedPassword;
	}
	

	public void setRole(String role) {
		this.role = role;
	}
	public List<Artiste> findAllArtiste(){
		return this.personneDAO.findAllArtiste();
	}

	public boolean login() throws NoSuchAlgorithmException {
		return this.personneDAO.login(this);
	}
	public Personne find()  {
		return this.personneDAO.find(this);
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
