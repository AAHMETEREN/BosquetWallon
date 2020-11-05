package pojo;

public class Client implements Personne {
	private  String motDePasse;
	private String nomUtilisateur;
	private String adresse;
	private String prenom;
	private String nom;
	private Integer age;

	
	public  Client(String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom, Integer age) {
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

}
