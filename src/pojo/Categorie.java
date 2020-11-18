package pojo;

import dao.AbstractDAOFactory;
import dao.CategorieDAO;
import dao.ConfigurationDAO;
import dao.DAO;

public class Categorie {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Categorie> categorieDAO = dao.getCategorieDAO();

	public enum TypesCategorie {
		BASE, BRONZE, ARGENT, OR, DIAMANT
	}

	private TypesCategorie type;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private int id;
	private int configurationId;

	public Categorie(int id, TypesCategorie type, int prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.id = id;
		this.type = type;
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
