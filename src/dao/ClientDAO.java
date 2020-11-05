package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Client;

public class ClientDAO extends DAO<Client> {
	public ClientDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Client obj) {
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
						result.getString("role"),
						result.getString("adresse"),
						result.getString("prenom"),
						result.getString("nom")
					);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
}
