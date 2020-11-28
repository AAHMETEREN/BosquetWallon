package pojo;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.SpectacleDAO;

public class Spectacle {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Spectacle> spectacleDAO = dao.getSpectacleDAO();
	private String titre;
	private int nombrePlaceParClient;
	private Organisateur organisateur;
	private Configuration configuration;
	private PlanningSalle planningSalle;
	private Reservation reservation = new Reservation();
	private List<Artiste> artistes = new ArrayList<Artiste>();
	private List<Representation> representations = new ArrayList<Representation>();
	private int id;
	
	public Spectacle() {};
	public Spectacle(int id, String titre, int nombrePlaceParClient, Organisateur organisateur,
			Configuration configuration, PlanningSalle planningSalle,
			List<Representation> representations) {

		this.id = id;
		this.titre = titre;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.organisateur = organisateur;
		this.configuration = configuration;
		this.planningSalle = planningSalle;
		this.representations = representations;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return this.titre;
	}
	
	public Reservation getReservation () {
		return this.reservation;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setNombrePlaceParClient(int nombrePlaceParClient) {
		this.nombrePlaceParClient = nombrePlaceParClient;
	}

	public void setOrganisateur(Personne organisateur) {
		this.organisateur = (Organisateur) organisateur;
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
		
		for(Artiste a : artistes) {
			System.out.println(a);
		}
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


	public void createSpectacle() {
		boolean isSpectacleCreated = this.spectacleDAO.create(this);
		if (isSpectacleCreated) {
			createRepresentations();
			createConfiguration();
			createPlanningSalle();
			createReservation();
			createArtistes();

		}
	}

	private boolean createReservation() {
		return reservation.createReservation(this.organisateur.getId(), this.planningSalle.getId());
	}

	private boolean createPlanningSalle() {
		return  planningSalle.createPlanningSalle(this.id);
	}

	private boolean createRepresentations() {
		boolean isRepresentationsCreated = false;
		
		for (Representation representation : representations) {
			System.out.println(representation);
			isRepresentationsCreated = representation.createRepresentation(this.id);
		}
		return isRepresentationsCreated;
	}
	private boolean createArtistes() {
		boolean isArtistesCreated = false;
		for (Artiste artiste : this.artistes) {
			isArtistesCreated = artiste.createArtisteSpectacle(this.organisateur.getId(),this.id);
		}
		return isArtistesCreated;
	}
	private boolean createConfiguration() {
		return configuration.createConfiguration(this.id);
	}
	

}
