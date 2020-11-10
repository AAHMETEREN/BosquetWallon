package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Configuration;
import pojo.Spectacle;

public class ConfigurationDAO implements DAO<Configuration>{

	protected Connection connect = null;

	public ConfigurationDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Configuration configuration) {
		try {
			String insertSQL = "INSERT INTO Configuration VALUES(null,'" 
					+ configuration.getType() 
					+ "','"
					+ configuration.getDescription()
					+ "','"
					+ configuration.getSpectacleId()
					+ "')";

			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					System.out.println(generatedKeys.getLong(1));
					configuration.setId((int)generatedKeys.getLong(1));
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
	public boolean delete(Configuration obj) {
		return false;
	}

	@Override
	public boolean update(Configuration obj) {
		return false;
	}

	@Override
	public Configuration find(int id) {
		return null;
	}
}
