package pojo;

import java.sql.Date;

public class Representation {
	private heureDebut
	private heureFin
	private int id;
	private Date dateRepresentation;
	
	public Representation(int id , Date dateRepresentation ) {
		this.id = id;
		this.dateRepresentation = dateRepresentation;
	}
}
