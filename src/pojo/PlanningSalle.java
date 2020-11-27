package pojo;

import java.sql.Date;
import java.util.Calendar;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.PlanningSalleDAO;

public class PlanningSalle {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<PlanningSalle> planningSalleDAO = dao.getPlanningSalleDAO();
	private int id;
	private int idSpectacle;

	private Date dateReservation;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public PlanningSalle(int id, Date dateReservation) {
		this.id = id;
		this.dateReservation = dateReservation;
		System.out.println("10" + dateReservation);
	}

	public boolean createPlanningSalle(int idSpectacle) {
		this.setSpectacleId(idSpectacle);
		return this.planningSalleDAO.create(this);
	}

	public Date getdateDebutR() {
		return this.dateReservation;
	}

	public Date getdateFinR() {
		Calendar c = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(c.getTimeInMillis());
		c.setTime(startDate);
		c.add(Calendar.DATE, 1);
		return new java.sql.Date(c.getTimeInMillis());
	}

	public void setSpectacleId(int id) {
		this.idSpectacle = id;
	}
	
	public int getIdSpectacle() {
		return this.idSpectacle;
	}
}
