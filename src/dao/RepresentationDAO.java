package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Configuration;
import pojo.Organisateur;
import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Representation;
import pojo.Reservation;
import pojo.Spectacle;
import pojo.Configuration.TypePlaces;

public class RepresentationDAO implements DAO<Representation> {
	protected Connection connect = null;

	public RepresentationDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Representation representation) {
		try {
			this.connect
			.createStatement()
			.executeUpdate("INSERT INTO Representation VALUES("
					+ "null,'" 
					+ representation.getDateRepresentation()
					+ "','"
					+ representation.getHeureDebut()
					+ "','"
					+ representation.getHeureFin()
					+ "','"
					+ representation.getSpectacle().getId()
					+ "')"
				);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Representation obj) {
		return false;
	}

	@Override
	public boolean update(Representation obj) {
		return false;
	}

	@Override
	public Representation find(Representation obj) {
		return null;
	}

	@Override
	public List<Representation> findAll(Representation representation) {
		List<Representation> representations = new ArrayList<Representation>();
		System.out.println("here2");
		try {
			ResultSet result = this.connect.createStatement()					
					.executeQuery("SELECT * FROM Representation WHERE fk_spectacle = '" + representation.getSpectacle().getId() +"'" );

			
			while (result.next()) {
				int representationId = Integer.parseInt(result.getString("id"));
				int heureDebut = (int) Float.parseFloat(result.getString("heureDebut"));
				int heureFin = (int) Float.parseFloat(result.getString("heureFin"));
				Date date = Date.valueOf(result.getString("date"));

				
				representations.add(
						new Representation(representationId, date, heureDebut,heureFin, representation.getSpectacle())
					);
				
						
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return representations;
	}
}
