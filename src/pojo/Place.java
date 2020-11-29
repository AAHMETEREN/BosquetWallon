package pojo;

import pojo.Categorie.TypesCategorie;
import pojo.Configuration.TypePlaces;

public class Place {
	private int id;
	private float prix;
	private Representation representation;
	private Commande commande;
	private TypePlaces type_categorie_configuration;
	private TypesCategorie type_categorie;
	public int getId() {
		return id;
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
	public TypePlaces getType_categorie_configuration() {
		return type_categorie_configuration;
	}
	public void setType_categorie_configuration(TypePlaces type_categorie_configuration) {
		this.type_categorie_configuration = type_categorie_configuration;
	}
	public TypesCategorie getType_categorie() {
		return type_categorie;
	}
	public void setType_categorie(TypesCategorie type_categorie) {
		this.type_categorie = type_categorie;
	}

}
