package pojo;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
	private List<Categorie> categories = new ArrayList<Categorie>();
	private String description;
	private String type;
	int id;
	
	public Configuration(int id , List<Categorie> categories , String description , String type) {
		this.id = id;
		this.categories = categories;
		this.description = description;
		this.type =type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getId() {
		return this.id;
	}
	public void addCategorie(Categorie categorie) {
		this.categories.add(categorie);
	}
}	
