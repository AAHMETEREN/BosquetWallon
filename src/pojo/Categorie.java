package pojo;

import java.sql.Date;

import dao.AbstractDAOFactory;
import dao.DAO;
import views.Location.TypePlaces;

public class Categorie {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Categorie> categorieDAO = dao.getCategorieDAO();

	public enum TypesCategorie {
		BASE, BRONZE, ARGENT, OR, DIAMANT
	}

	private TypesCategorie type;
	private int prix = 0;
	private int id = 0;
	private int configurationId;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;

	public Categorie(Date date , TypesCategorie type,int prix , TypePlaces place) {
		this.prix = prix;
		this.type = type;
		this.calculerNombrePlace(type, place);
	}

	public void calculerNombrePlace(TypesCategorie type, TypePlaces place) {
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

	public int getConfigurationId() {
		return this.configurationId;
	}

	public boolean createCategorie(int configurationId) {
		this.configurationId = configurationId;
		categorieDAO.create(this);
		return true;
	}
}
