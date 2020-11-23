package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Artiste;
import pojo.Client;

public class ArtisteDAO implements DAO<Artiste> {

	protected Connection connect = null;

	public ArtisteDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Artiste artiste) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Personne VALUES(null,'" + artiste.getMotDePasse() + "','"
							+ artiste.getNomUtilisateur() + "','" + "artiste" + "','" + artiste.getAdresse() + "','"
							+ artiste.getPrenom() + "','" + artiste.getNom() + "','" + artiste.getNomDeScene() + "','"
							+ "null" + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Artiste obj) {
		return false;
	}

	@Override
	public boolean update(Artiste obj) {
		return false;
	}

	@Override
	public Artiste find(int id) {
		return null;
	}

}
