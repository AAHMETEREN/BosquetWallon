package pojo;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.DAOFactory;

public class Client implements Personne {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Client> clientDAO = dao.getClientDAO();
	private  String motDePasse;
	private String nomUtilisateur;
	private String adresse;
	private String prenom;
	private String nom;
	private Integer age;
	private final String role = "client";
	private int id;
	public  Client(int id , String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom, Integer age) {
		this.id = id;
		this.motDePasse = motDePasse;
		this.nomUtilisateur = nomUtilisateur;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}
	
	public Client() {
	}
	
	public Integer getAge() {
		return this.age;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getPrenom() {
		return this.prenom;
	}

	@Override
	public String getMotDePasse() {
		return this.motDePasse;
	}

	@Override
	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	@Override
	public String getAdresse() {
		return this.adresse;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	public boolean create() {
		return clientDAO.create(this);
	}

}
