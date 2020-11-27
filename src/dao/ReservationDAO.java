package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Reservation;

public class ReservationDAO implements DAO<Reservation> {
	
	protected Connection connect = null;
	
	public ReservationDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Reservation reservation) {
		try {
			this.connect
					.createStatement()
					.executeUpdate(
							"INSERT INTO Reservation VALUES(null,'"
					+reservation.getAcompte()
					+"','"
					+reservation.getSolde()
					+"','"
					+reservation.getStatus()
					+"','"
					+reservation.getPrix()
					+"','"
					+reservation.getidPersonne()
					+"','"
					+reservation.getIdPlanning()
					+"')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Reservation obj) {
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		return false;
	}


	@Override
	public Reservation find(Reservation obj) {
		return null;
	}

}
