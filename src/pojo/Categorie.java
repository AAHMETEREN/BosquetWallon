package pojo;

public class Categorie {
	private String type;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private int id;

	public Categorie(int id , int prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.id = id;
	}
}
