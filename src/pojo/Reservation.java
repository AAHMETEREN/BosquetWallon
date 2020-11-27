package pojo;


import dao.AbstractDAOFactory;
import dao.DAO;

public class Reservation {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<Reservation> reservationDAO = dao.getReservationDAO();
	private int id = 0;
	private float acompte;
	private float solde;
	private float prix;
	private String status;
	private int idPersonne;
	private int idPlanningSalle;

	public Reservation() {};
	public Reservation(int acompte ,int solde ,float prix ) {
		this.acompte = acompte;
		this.solde = solde;
		this.prix = prix;
	}
	public String getStatus() {
		return this.status;
	}
	
	public int getIdPlanning() {
		return this.idPlanningSalle;
	}
	public int getidPersonne() {
		return this.idPersonne;
	}
	public  float getAcompte() {
		return this.acompte;
	}
	
	public  float getSolde() {
		return this.solde;
	}
	public float getPrix() {
		return this.prix;
	}
	public boolean createReservation(int idOrganisateur , int idPlanningSalle) {
		this.idPlanningSalle = idPlanningSalle;
		this.idPersonne = idOrganisateur;
		System.out.println("ID ORGANISATEUR "+idOrganisateur);
		return reservationDAO.create(this);
	}
	
	
	public void setId( int id ) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
}
