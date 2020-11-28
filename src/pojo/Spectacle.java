package pojo;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.SpectacleDAO;

public class Spectacle {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Spectacle> spectacleDAO = dao.getSpectacleDAO();
	private int id = 0;
	private String titre;
	private int nombrePlaceParClient;
	private Configuration configuration;
	private List<Artiste> artistes = new ArrayList<Artiste>();
 
	
	public Spectacle() { };

	public Spectacle(String titre, int nombrePlaceParClient, Configuration configuration
			) {

		this.titre = titre;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.configuration = configuration;
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



	public List<Artiste> getArtistes() {
		return artistes;
	}

	public void addArtiste(Artiste artiste) {
		this.artistes.add(artiste);

		for (Artiste a : artistes) {
			System.out.println(a);
		}
	}




	public void create() {
		boolean isSpectacleCreated = this.spectacleDAO.create(this);
		if (isSpectacleCreated) {
			createConfiguration();
			createArtistes();

		}
	}

	public int getId() {
		return this.id;
	}


	private boolean createArtistes() {
		boolean isArtistesCreated = false;
		for (Artiste artiste : this.artistes) {
			isArtistesCreated = artiste.createArtisteSpectacle(artiste.getId(), this.id);
		}
		return isArtistesCreated;
	}

	private boolean createConfiguration() {
		return configuration.create(this.id);
	}

}
