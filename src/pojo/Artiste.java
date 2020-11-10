package pojo;

public class Artiste implements Personne{
	private  String motDePasse;
	private String nomUtilisateur;
	private String adresse;
	private String prenom;
	private String nom;
	private String nomDeScene;
	private final String role = "artiste";
	private int id;

	
	public  Artiste(int id ,String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom,String nomDeScene) {
		this.id = id;
		this.motDePasse = motDePasse;
		this.nomUtilisateur = nomUtilisateur;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
		this.nom = nomDeScene;
	}
	
	public Artiste() {
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
	public String toString() {
		return this.nomDeScene;
	}
}
