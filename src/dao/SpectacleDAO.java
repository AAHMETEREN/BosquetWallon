package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import pojo.Personne;
import pojo.Spectacle;

public class SpectacleDAO implements DAO<Spectacle> {

	protected Connection connect = null;

	public SpectacleDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Spectacle spectacle) {
		try {
			String insertSQL = "INSERT INTO Spectacle VALUES(null,'" + spectacle.getTitre() + "','"
					+ spectacle.getNombrePlaceParClient() + "')";

			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					spectacle.setId((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override
	public boolean delete(Spectacle obj) {
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		return false;
	}

	@Override
	public Spectacle find(Spectacle obj) {
		return null;
	}

	@Override
	public List<Spectacle> findAll(Spectacle personne) {
		// TODO Auto-generated method stub
		return null;
	}
}
