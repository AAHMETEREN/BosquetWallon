package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Categorie;
import pojo.Configuration;
import pojo.Spectacle;

public class CategorieDAO implements DAO<Categorie> {

	protected Connection connect = null;

	public CategorieDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Categorie categorie) {
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Categorie VALUES(null,'" 
					+ categorie.getType()
					+ "','" 
					+ categorie.getPrix() 
					+ "','" 
					+ categorie.getNbrPlaceDispo() 
					+ "','" 
					+ categorie.getNbrPlaceMax() 
					+ "','" 
					+ categorie.getConfigurationId() 
					+ "')");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Categorie obj) {
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		return false;
	}

	@Override
	public Categorie find(Categorie obj) {
		return null;
	}
}
