package pojo;

public class Organisateur extends Personne {
	public final static String role = "organisateur";
	private String nomEntreprise;

	public Organisateur(int id, String motDePasse, String nomUtilisateur, String adresse, String prenom, String nom,
			String nomEntreprise) {
		super(id, role, motDePasse, nomUtilisateur, adresse, prenom, nom);
		this.nomEntreprise = nomEntreprise;
	}

	public Organisateur() {
	}

	public String getNomEntreprise() {
		return this.nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	@Override
	public boolean register() {
		return personneDAO.create(((Organisateur) this));
	}
}
