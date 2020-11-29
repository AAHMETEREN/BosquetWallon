package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Reservation;
import pojo.Spectacle;
import utils.Hash;

public class ReservationDAO implements DAO<Reservation> {

	protected Connection connect = null;

	public ReservationDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Reservation reservation) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Reservation VALUES(null,'" + reservation.getAcompte() + "','"
							+ reservation.getSolde() + "','" + reservation.getStatus() + "','" + reservation.getPrix()
							+ "','" + reservation.getOrganisateur().getId() + "','" + reservation.getPlanning().getId()
							+ "')");
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

	@Override
	public List<Reservation> findAll(Reservation reservation) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			ResultSet result = this.connect.createStatement().executeQuery(
					"SELECT Reservation.id  AS reservation_id  , Spectacle.id as spectacle_id , PlanningSalle.id as PlanningSalle_id ,   * FROM Reservation "
							+ " INNER JOIN PlanningSalle ON Reservation.fk_planningSalle = PlanningSalle.id "
							+ " INNER JOIN Spectacle ON Spectacle.id = PlanningSalle.fk_spectacle "
							+ " WHERE fk_personne = '" + Integer.toString(reservation.getOrganisateur().getId())  + "' "

			);
			
			while (result.next()) {
				System.out.println("RESULT FOUND");
				// Creation de spectacle 
				int spectacleId  = Integer.parseInt(result.getString("reservation_id"));
				int nbrPlaceParClient = Integer.parseInt(result.getString("nbrPlaceParClient"));
				String titreSpectacle = result.getString("titre");
				Spectacle spectacle = new Spectacle(titreSpectacle,nbrPlaceParClient );
				spectacle.setId(spectacleId);
				
				// Creation de planning salle 
				Date dateReservation = Date.valueOf(result.getString("dateDebutR"));
				PlanningSalle planningSalle = new PlanningSalle(dateReservation , spectacle);
				// Creation de la reservation
				float acompteReservation = Float.parseFloat(result.getString("acompte"));
				float solde = Float.parseFloat(result.getString("solde"));
				float prix = Float.parseFloat(result.getString("prix"));
				Reservation reservationIndex = new Reservation(acompteReservation, solde, prix, planningSalle, reservation.getOrganisateur());
				reservationIndex.setId(spectacleId);
				reservations.add(reservationIndex);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

}
