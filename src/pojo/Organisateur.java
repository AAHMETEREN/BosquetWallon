package pojo;

public class Organisateur implements Personne  {
	private  String motDePasse;
	private String nomUtilisateur;
	private String adresse;
	private String prenom;
	private String nom;
	private final String role = "organisateur";
	private int id;

	public  Organisateur(int id ,String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom) {
		this.id = id;
		this.motDePasse = motDePasse;
		this.nomUtilisateur = nomUtilisateur;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public Organisateur() {
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
}
