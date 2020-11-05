package pojo;

public class Personne {
	protected String motDePasse;
	protected String nomUtilisateur;
	protected String role;
	protected String adresse;
	protected String prenom;
	protected String nom;
	
	public Personne(String motDePasse , String nomUtilisateur , String role , String adresse ,String prenom ,String nom) {
		this.motDePasse = motDePasse;
		this.nomUtilisateur = nomUtilisateur;
		this.adresse = adresse;
		this.role = role;
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
}
