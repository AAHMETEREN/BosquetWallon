package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Client;
import pojo.Organisateur;
import pojo.Personne;

public class PersonneDAO {

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
						Personne pers=  new Client(result.getString("motDePasse"), result.getString("nomUtilisateur"),
								result.getString("adresse"), result.getString("prenom"), result.getString("nom"),
								Integer.parseInt(result.getString("age")));
						System.out.println("5555"+pers.getPrenom());
						return pers;
					}else if(role.equals("organisateur")) {
						return new Organisateur(result.getString("motDePasse"), result.getString("nomUtilisateur"),
								result.getString("adresse"), result.getString("prenom"), result.getString("nom"));
					}
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return new Client(); // Client vide
	}
}
