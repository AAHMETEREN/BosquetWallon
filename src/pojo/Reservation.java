package pojo;


import java.sql.Date;
import java.util.Calendar;

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
		return reservationDAO.create(this);
	}
	
	@SuppressWarnings("deprecation")
	public void setPrix( Date date ) {
		int jourDeLaSemaine = date.getDay();
		if(jourDeLaSemaine == 5 || jourDeLaSemaine == 6) { // Friday or saturday
			this.prix = 4500;
		}else {
			this.prix = 3000;
		}
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
}
