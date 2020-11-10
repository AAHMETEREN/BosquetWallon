package pojo;

public class Categorie {
	public enum TypesCategorie { 
		BASE,
		BRONZE,
		ARGENT,
		OR,
		DIAMANT
	}
	private TypesCategorie type;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private int id;

	public Categorie(int id ,TypesCategorie type, int prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.id = id;
		this.type = type;
	}
}
