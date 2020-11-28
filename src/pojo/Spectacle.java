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

}
