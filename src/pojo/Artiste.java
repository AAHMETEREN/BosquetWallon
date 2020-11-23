package pojo;

public class Artiste extends Personne {
	private String nomDeScene;
	public final static String role = "artiste";

	public Artiste(int id, String motDePasse, String nomUtilisateur, String adresse, String prenom, String nom,
			String nomDeScene) {
		super(id, role, motDePasse, nomUtilisateur, adresse, prenom, nom);
		this.nomDeScene = nomDeScene;
	}

	public String getNomDeScene() {
		return this.nomDeScene;
	}

	public void setNomDeScene(String nomDeScene) {
		this.nomDeScene = nomDeScene;
	}
	
	@Override
	public boolean register() {
		return personneDAO.create(((Artiste) this));
	}
}
