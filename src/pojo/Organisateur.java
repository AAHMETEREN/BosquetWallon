package pojo;

public class Organisateur implements Personne  {
	private  String motDePasse;
	private String nomUtilisateur;
	private String adresse;
	private String prenom;
	private String nom;

	
	public  Organisateur(String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom) {
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
}
