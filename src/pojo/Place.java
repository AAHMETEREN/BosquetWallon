package pojo;

import dao.AbstractDAOFactory;
import dao.DAO;
import pojo.Categorie.TypesCategorie;

public class Place {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Place> placeDAO = dao.getPlaceDAO();

	private int id;
	private float prix;
	private Representation representation;
	private Commande commande;
	private TypesCategorie type_categorie;
	public int getId() {
		return id;
	}
	public Place(float prix, Representation representation, Commande commande,
			TypesCategorie type_categorie) {
		super();
		this.prix = prix;
		this.representation = representation;
		this.commande = commande;
		this.type_categorie = type_categorie;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public TypesCategorie getType_categorie() {
		return type_categorie;
	}
	public void setType_categorie(TypesCategorie type_categorie) {
		this.type_categorie = type_categorie;
	}
	
	public boolean create() {
		return this.placeDAO.create(this);
	}
}
