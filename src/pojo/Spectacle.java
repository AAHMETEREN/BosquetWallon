package pojo;

import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Spectacle {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Spectacle> spectacleDAO = dao.getSpectacleDAO();
	private Configuration configuration;
	private int id;
	private String titre;
	private int nombrePlaceParClient;

	public Spectacle() {
	};

	public Spectacle(String titre, int nombrePlaceParClient) {
		this.titre = titre;
		this.nombrePlaceParClient = nombrePlaceParClient;
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

	public Configuration getConfiguration() {
		return this.configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	public int getNombrePlaceParClient() {
		
		return this.nombrePlaceParClient;
	}

	public void setNumber(String titre) {
		this.titre = titre;
	}

	public boolean create() {
		return this.spectacleDAO.create(this);

	}

	public int getId() {
		return this.id;
	}
	
	public List<Reservation> findAll() {
		return  (List<Reservation>) spectacleDAO.findAll(this);
	}

}
