package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Client;

public class ClientDAO extends DAO<Client> {
	public ClientDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Client client) {
		try {
			System.out.println(client.getMotDePasse());
			System.out.println(client.getNomUtilisateur());
			System.out.println(client.getPrenom());
			System.out.println(client.getAdresse());
			System.out.println(client.getNom());
			System.out.println(client.getAge());

			this.connect
					.createStatement()
					.executeUpdate(
							"INSERT INTO Personne VALUES(null,'"+client.getMotDePasse()+"','"+client.getNomUtilisateur()+"','"+"client"+"','"+client.getAdresse()+"','"+client.getPrenom()+"','"+client.getNom()+"','"+"null"+"','"+client.getAge()+"')");
			
			;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Client obj) {
		return false;
	}

	public boolean update(Client obj) {
		return false;
	}

	public Client find(int id) {
		Client client = new Client();
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery("SELECT * FROM Personne WHERE id = " + id);
			if(result.next()) {
				client = new Client(
						result.getString("motDePasse"),
						result.getString("nomUtilisateur"),
						result.getString("adresse"),
						result.getString("prenom"),
						result.getString("nom"),
						Integer.parseInt(result.getString("age"))
					);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
}
