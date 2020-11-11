package pojo;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.SpectacleDAO;

public class Spectacle {
	private String titre;
	private int nombrePlaceParClient;
	private Organisateur organisateur;
	private Configuration configuration;
	private PlanningSalle planningSalle;
	private List<Artiste> artistes = new ArrayList<Artiste>();
	private List<Representation> representations = new ArrayList<Representation>();
	private int id;
	private DAO<Spectacle> spectacleDAO = new SpectacleDAO(database.SqliteConnection.getInstance());

	public Spectacle(int id, String titre, int nombrePlaceParClient, Organisateur organisateur,
			Configuration configuration, PlanningSalle planningSalle, List<Artiste> artistes,
			List<Representation> representations) {

		this.id = id;
		this.titre = titre;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.organisateur = organisateur;
		this.configuration = configuration;
		this.planningSalle = planningSalle;
		this.artistes = artistes;
		this.representations = representations;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setNombrePlaceParClient(int nombrePlaceParClient) {
		this.nombrePlaceParClient = nombrePlaceParClient;
	}

	public int getNombrePlaceParClient() {
		return this.nombrePlaceParClient;
	}

	public void setNumber(String titre) {
		this.titre = titre;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public Configuration getConfiguration() {
		return this.configuration;
	}

	public void setPlanningSalle(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}

	public PlanningSalle getPlanningSalle() {
		return this.planningSalle;
	}

	public List<Artiste> getArtistes() {
		return artistes;
	}

	public void addArtiste(Artiste artiste) {
		this.artistes.add(artiste);
	}

	public List<Representation> getRepresentations() {
		return representations;
	}

	public void addRepresentation(Representation representation) {
		this.representations.add(representation);
	}

	public Organisateur getCreatedBy() {
		return organisateur;
	}

	public void addRepresentation(Organisateur organisateur) {
		this.organisateur = (organisateur);
	}

	public void createSpectacle() {
		boolean isSpectacleCreated = this.spectacleDAO.create(this);

		if (isSpectacleCreated) {
			// creation representation
			isSpectacleCreated = createRepresentations();
			// creation configuration et categorie
			isSpectacleCreated = createConfiguration();
			// create planning salle
			// create reservation
		}
	}

	boolean createRepresentations() {
		for (Representation representation : representations) 
		{ 
			representation.createRepresentation(this.id);
		}
		return true;
	}
	boolean createConfiguration() {
		configuration.createConfiguration(this.id);
		return true;
	}
}
