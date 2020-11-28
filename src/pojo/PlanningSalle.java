package pojo;

import java.sql.Date;
import java.util.Calendar;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.PlanningSalleDAO;

public class PlanningSalle {
	private final AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private final DAO<PlanningSalle> planningSalleDAO = dao.getPlanningSalleDAO();
	private int id = 0;
	private Spectacle spectacle;
	private Date dateReservation;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public PlanningSalle(Date dateReservation , Spectacle spectacle) {
		this.dateReservation = dateReservation;
		System.out.println("10" + dateReservation);
		this.spectacle = spectacle;
	}

	public boolean create() {
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

	
	public Spectacle getSpectacle() {
		return this.spectacle;
	}
}
