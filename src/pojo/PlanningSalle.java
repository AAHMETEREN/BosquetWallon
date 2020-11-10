package pojo;

import java.sql.Date;

public class PlanningSalle {
	private int id;
	private Date dateReservation;
	
	public PlanningSalle(int id , Date dateReservation) {
		this.id = id;
		this.dateReservation = dateReservation;
		System.out.println("10"+dateReservation);
	}
}
