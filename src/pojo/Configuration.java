package pojo;

import java.util.ArrayList;
import java.util.List;
import dao.DAO;
import dao.AbstractDAOFactory;
import dao.ConfigurationDAO;

public class Configuration {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Configuration> configurationDAO = dao.getConfigurationDAO();
	private List<Categorie> categories = new ArrayList<Categorie>();
	private String description;
	private String type;
	int id;
	int spectacleId;

	public Configuration(int id, List<Categorie> categories, String description, String type) {
		this.id = id;
		this.categories = categories;
		this.description = description;
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public int getSpectacleId() {
		return this.spectacleId;
	}

	public String getType() {
		return this.type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void addCategorie(Categorie categorie) {
		this.categories.add(categorie);
	}

	public boolean createConfiguration(int spectacleId) {
		this.spectacleId = spectacleId;
		boolean isConfigurationCreated = configurationDAO.create(this);
		if (isConfigurationCreated) {
			for (Categorie categorie : this.categories) {
				categorie.createCategorie(this.id);
			}
		}

		return true;
	}
}
