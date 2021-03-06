package pojo;

import java.sql.Date;
import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.RepresentationDAO;

public class Representation {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Representation> representationDAO = dao.getRepresentationDAO();
	private int heureDebut;
	private int heureFin;
	private int id;
	private Date dateRepresentation;
	private Spectacle spectacle;

	public Representation(int id, Date dateRepresentation, int heureDebut, int heureFin, Spectacle spectacle) {
		this.id = id;
		this.dateRepresentation = dateRepresentation;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.spectacle = spectacle;
	}

	public Representation() {
	}

	public int getId() {
		return this.id;
	}

	public boolean create() {
		return representationDAO.create(this);
	}

	public Date getDateRepresentation() {
		return this.dateRepresentation;
	}

	public int getHeureDebut() {
		return this.heureDebut;
	}

	public int getHeureFin() {
		return this.heureFin;
	}

	public Spectacle getSpectacle() {
		return this.spectacle;
	}
	
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	
	@Override
	public String toString() {
		return ""+heureDebut+ "H � " +heureFin+"H";
	}
	public List<Representation> findAll (){
		return (List<Representation>) representationDAO.findAll(this);
	}
}
