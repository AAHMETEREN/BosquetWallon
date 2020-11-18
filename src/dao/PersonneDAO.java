package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Client;
import pojo.Organisateur;
import pojo.Personne;
import pojo.Spectacle;

public class PersonneDAO implements DAO<PersonneDAO> {

	protected Connection connect = null;

	public PersonneDAO(Connection conn) {
		connect = conn;
	}

	public Personne login(String username, String password,String userRole) {
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery("SELECT * FROM Personne WHERE nomUtilisateur = '" +username+"'"+"AND role = '"+userRole+"'");
			if (result.next()) {
				String resultPassword = result.getString("motDePasse");
				String role = result.getString("role");
				if (password.equals(resultPassword)) {
					if(role.equals("client")) {
						Personne pers=  new Client(
								Integer.parseInt(result.getString("id")),
								result.getString("motDePasse"),
								result.getString("nomUtilisateur"),
								result.getString("adresse"),
								result.getString("prenom"),
								result.getString("nom"),
								Integer.parseInt(result.getString("age"))
							);
						System.out.println("5555"+pers.getPrenom());
						return pers;
					}else if(role.equals("organisateur")) {
						return new Organisateur(
								Integer.parseInt(result.getString("id")),
								result.getString("motDePasse"),
								result.getString("nomUtilisateur"),
								result.getString("adresse"),
								result.getString("prenom"),
								result.getString("nom")
							);
					}
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return new Client(); // Client vide
	}

	@Override
	public boolean create(PersonneDAO obj) {
		return false;
	}

	@Override
	public boolean delete(PersonneDAO obj) {
		return false;
	}

	@Override
	public boolean update(PersonneDAO obj) {
		return false;
	}

	@Override
	public PersonneDAO find(int id) {
		return null;
	}
}
