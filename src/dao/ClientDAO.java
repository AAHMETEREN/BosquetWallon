package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Client;

public class ClientDAO implements DAO<Client> {
	
	protected Connection connect = null;
	
	public ClientDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Client client) {
		try {
			this.connect
					.createStatement()
					.executeUpdate(
							"INSERT INTO Personne VALUES(null,'"+client.getMotDePasse()+"','"+client.getNomUtilisateur()+"','"+"client"+"','"+client.getAdresse()+"','"+client.getPrenom()+"','"+client.getNom()+"','"+"null"+"','"+client.getAge()+"')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Client obj) {
		return false;
	}

	@Override
	public boolean update(Client obj) {
		return false;
	}


	@Override
	public Client find(int id) {
		Client client = new Client(id, null, null, null, null, null, id);
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery("SELECT * FROM Personne WHERE id = " + id);
			if(result.next()) {
				client = new Client(
						Integer.parseInt(result.getString("id")),
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
