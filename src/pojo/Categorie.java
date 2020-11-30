package pojo;

import java.sql.Date;

import dao.AbstractDAOFactory;
import dao.DAO;
import pojo.Configuration.TypePlaces;

public class Categorie {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Categorie> categorieDAO = dao.getCategorieDAO();

	public enum TypesCategorie {
		BASE, BRONZE, ARGENT, OR, DIAMANT
	}

	private TypesCategorie type;
	private int prix = 0;
	private int id = 0;
	private Configuration configuration;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;

	public Categorie(TypesCategorie type,int prix , TypePlaces place , Configuration configuration) {
		this.prix = prix;
		this.type = type;
		this.configuration = configuration;
		this.calculerNombrePlace(type, place);
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public void setNbrPlaceMax(int nbrPlaceMax) {
		this.nbrPlaceMax = nbrPlaceMax;
	}
	public void setNbrPlaceDispo(int nbrPlaceDispo) {
		this.nbrPlaceDispo = nbrPlaceDispo;
	}
	public void calculerNombrePlace(TypesCategorie type, TypePlaces place) {
		if(place == null) return;
		int nbrPlaceDispo = 0;
		switch (place) {
		case DEBOUT:
			nbrPlaceDispo = 8000;
			break;
		case ASSIS_CONCERT:
			switch (type) {
			case OR:
				nbrPlaceDispo = 500;
				break;
			case ARGENT:
				nbrPlaceDispo = 1500;
				break;
			case BRONZE:
				nbrPlaceDispo = 3000;
				break;
			}
			break;
		case ASSIS_CIRQUE:
			switch (type) {
			case DIAMANT:
				nbrPlaceDispo = 1000;
				break;
			case OR:
				nbrPlaceDispo = 2000;
				break;
			case ARGENT:
				nbrPlaceDispo = 1500;
				break;
			case BRONZE:
				nbrPlaceDispo = 1500;
				break;
			}
			break;

		}
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceDispo;
	}

	public String getType() {
		return this.type.toString();
	}

	public int getPrix() {
		return this.prix;
	}

	public int getNbrPlaceDispo() {
		return this.nbrPlaceDispo;
	}

	public int getNbrPlaceMax() {
		return this.nbrPlaceMax;
	}

	public Configuration getConfiguration() {
		return this.configuration;
	}
	public int getId() {
		return this.id;
	}
	public boolean create() {
		boolean isCategorieCreated = categorieDAO.create(this);
		return isCategorieCreated;
	}
	
	public boolean update() {
		boolean isNbrPlaceDispoDecremented = categorieDAO.update(this);
		return isNbrPlaceDispoDecremented;
	}
	public void setId(int id) {
		this.id = id;
	}
}
