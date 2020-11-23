package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Artiste;
import pojo.Client;
import pojo.Organisateur;
import pojo.Personne;
import pojo.Spectacle;

public class PersonneDAO implements DAO<Personne> {

	protected Connection connect = null;

	public PersonneDAO(Connection conn) {
		connect = conn;
	}

	public boolean login(Personne personne) {
		try {
			ResultSet result = this.connect.createStatement()
					.executeQuery("SELECT * FROM Personne WHERE nomUtilisateur = '" 
					+ personne.getNomUtilisateur()
					+ "' AND role ='" 
					+ personne.getRole() 
					+ "'"
				);
			if (result.next()) {
				String resultPassword = result.getString("motDePasse");
				if (personne.getMotDePasse().equals(resultPassword)) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean create(Client client) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Personne VALUES("
							+ "null,'" 
							+ client.getMotDePasse() 
							+ "','"
							+ client.getNomUtilisateur() 
							+ "','" 
							+ "client" 
							+ "','" 
							+ client.getAdresse() 
							+ "','"
							+ client.getPrenom() 
							+ "','" 
							+ client.getNom() 
							+ "','" 
							+ "null" 
							+ "','" 
							+ client.getAge()
							+ "','" 
							+ "null" 
							+ "')"
						);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean create(Organisateur organisateur) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Personne VALUES(" 
							+ "null,'" 
							+ organisateur.getMotDePasse() 
							+ "','"
							+ organisateur.getNomUtilisateur() 
							+ "','" 
							+ "organisateur" 
							+ "','"
							+ organisateur.getAdresse() 
							+ "','" 
							+ organisateur.getPrenom() 
							+ "','"
							+ organisateur.getNom() 
							+ "','" 
							+ "null" 
							+ "','" 
							+ "','null'" 
							+ "','"
							+ organisateur.getNomEntreprise() 
							+ "')"
						);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean create(Artiste artiste) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Personne VALUES(null,'" 
							+ artiste.getMotDePasse() 
							+ "','"
							+ artiste.getNomUtilisateur() 
							+ "','" + "artiste" 
							+ "','" 
							+ artiste.getAdresse() 
							+ "','"
							+ artiste.getPrenom() 
							+ "','" 
							+ artiste.getNom() 
							+ "','" 
							+ artiste.getNomDeScene() 
							+ "','"
							+ "null" 
							+ "','" 
							+ "null" 
							+ "')"
						);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean create(Personne obj) {
		return false;
	}

	@Override
	public boolean delete(Personne obj) {
		return false;
	}

	@Override
	public boolean update(Personne obj) {
		return false;
	}

	@Override
	public Personne find(int id) {
		return null;
	}
}
