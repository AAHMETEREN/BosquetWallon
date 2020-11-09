package pojo;

import java.util.ArrayList;
import java.util.List;

public class Spectacle {
	private String titre;
	private int nombrePlaceParClient = 10;
	private Configuration configuration;
	private PlanningSalle planningSalle;
	private List<Artiste> artistes = new ArrayList<Artiste>();
	private List<Representation> representations = new ArrayList<Representation>();
	
	public Spectacle(String titre) {
		this.titre = titre;
	}	
	
	public String getTitre() {
        return this.titre;
    }
    public void setNombrePlaceParClient(int nombrePlaceParClient) {
        this.nombrePlaceParClient = nombrePlaceParClient;
    }
    
    public int setNombrePlaceParClient() {
        return this.nombrePlaceParClient;
    }
    public void setNumber(String titre) {
        this.titre = titre;
    }
    
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
    
    public Configuration getConfiguration() {
        return this.configuration;
    }
	
    public void setPlanningSalle(PlanningSalle planningSalle) {
        this.planningSalle = planningSalle;
    }
    
    public PlanningSalle getPlanningSalle() {
        return this.planningSalle;
    }
    
    public List<Artiste> getArtistes() {
        return artistes;
    }
    
    public void addArtiste(Artiste artiste) {
        this.artistes.add(artiste);
    }
    
    
    
    
}
