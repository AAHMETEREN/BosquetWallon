package pojo;

public class Personne {
	protected String motDePasse;
	protected String nomUtilisateur;
	protected String adresse;
	protected String prenom;
	protected String nom;
	
	public Personne(String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom) {
		this.motDePasse = motDePasse;
		this.nomUtilisateur = nomUtilisateur;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public Personne() {
		
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
	
}
