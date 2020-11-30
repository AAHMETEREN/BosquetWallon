package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import pojo.Commande;

public class CommandeDAO implements DAO<Commande> {
	protected Connection connect = null;

	public CommandeDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Commande commande) {
		
		try {
			String insertSQL = "INSERT INTO Commande VALUES("
					+ "null,'" 
					+ commande.getModeDePayement()
					+ "','"
					+ commande.getModeDeLivraison()
					+ "','"
					+ commande.getCout()
					+ "','"
					+ commande.getPersonne().getId()
					+ "')";

			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					commande.setId((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Commande obj) {
		return false;
	}
	
	@Override
	public boolean update(Commande obj) {
		return false;
	}



	@Override
	public List<Commande> findAll(Commande commande) {
		return null;
	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
