package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Representation;
import pojo.Spectacle;

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
					+ representation.getIdSpectacle()
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
}
