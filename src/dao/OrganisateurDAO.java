package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Client;
import pojo.Organisateur;

public class OrganisateurDAO implements DAO<Organisateur>{

	protected Connection connect = null;
	
	public OrganisateurDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Organisateur organisateur) {
		try {
			this.connect
					.createStatement()
					.executeUpdate(
							"INSERT INTO Personne VALUES(null,'"+organisateur.getMotDePasse()+"','"+organisateur.getNomUtilisateur()+"','"+"organisateur"+"','"+organisateur.getAdresse()+"','"+organisateur.getPrenom()+"','"+organisateur.getNom()+"','"+"null"+"','null')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Organisateur obj) {
		return false;
	}

	@Override
	public boolean update(Organisateur obj) {
		return false;
	}

	@Override
	public Organisateur find(int id) {
		Organisateur organisateur = new Organisateur();
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery("SELECT * FROM Personne WHERE id = " + id);
			if(result.next()) {
				organisateur = new Organisateur(
						result.getString("motDePasse"),
						result.getString("nomUtilisateur"),
						result.getString("adresse"),
						result.getString("prenom"),
						result.getString("nom")
					);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organisateur;
	}
}
