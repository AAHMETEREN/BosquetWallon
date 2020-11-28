package pojo;

import dao.DAO;
import dao.AbstractDAOFactory;

public class Configuration {
	public enum TypePlaces {
		DEBOUT("Debout (8000 places)"), ASSIS_CONCERT("Assis version concert (5000 places)"),
		ASSIS_CIRQUE("Assis version cirque (6000 places)");

		private final String display;

		private TypePlaces(String label) {
			this.display = label;
		}

		@Override
		public String toString() {
			return display;
		}
	}
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Configuration> configurationDAO = dao.getConfigurationDAO();
	private String description;
	private TypePlaces type;
	int id;
	private Spectacle spectacle;
	
	
	public Configuration(int id,  String description, TypePlaces place , Spectacle spectacle) {
		this.id = id;
		this.description = description;
		this.type = place;
		this.spectacle  = spectacle;
	}
	
	public String getDescription() {
		return this.description;
	}

	public Spectacle getSpectacle() {
		return this.spectacle;
	}

	public String getType() {
		if(this.type == TypePlaces.DEBOUT) 
			return "DEBOUT";
		else if(this.type == TypePlaces.ASSIS_CIRQUE)
			return "ASSIS_CIRQUE";		
		else
			return "ASSIS_CONCERT";
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public boolean create() {
		boolean isConfigurationCreated = configurationDAO.create(this);
		return isConfigurationCreated;
	}
}
