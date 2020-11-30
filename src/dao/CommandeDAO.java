package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Categorie;
import pojo.Commande;
import pojo.Configuration;
import pojo.Organisateur;
import pojo.Personne;
import pojo.Place;
import pojo.PlanningSalle;
import pojo.Reservation;
import pojo.Spectacle;
import pojo.Categorie.TypesCategorie;
import pojo.Commande.livraison;
import pojo.Commande.payement;
import pojo.Configuration.TypePlaces;

public class CommandeDAO implements DAO<Commande> {
	protected Connection connect = null;

	public CommandeDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Commande commande) {

		try {
			String insertSQL = "INSERT INTO Commande VALUES(" + "null,'" + commande.getModeDePayement() + "','"
					+ commande.getModeDeLivraison() + "','" + commande.getCout() + "','"
					+ commande.getPersonne().getId() + "')";

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
		List<Commande> commandes = new ArrayList<Commande>();

		try {
			ResultSet result = this.connect.createStatement().executeQuery(
					"SELECT Commande.id as commande_id , * FROM Commande WHERE fk_personne='"
							+ commande.getPersonne().getId() + "'");

			while (result.next()) {
				
				List<Place> places = new ArrayList<Place>();

				ResultSet placesResult = this.connect.createStatement().executeQuery(
						"SELECT * FROM Place WHERE fk_commande='" + result.getString("commande_id") + "'");

				while (placesResult.next()) {
					places.add(new Place(Float.parseFloat(placesResult.getString("prix")), null, commande,
							TypesCategorie.valueOf(placesResult.getString("type_categorie"))));

				}

				Commande commandeIndex = new Commande(payement.valueOf(result.getString("modeDePayement")),
						livraison.valueOf(result.getString("modeDeLivraison")),
						Float.parseFloat(result.getString("cout")), commande.getPersonne());
				commandeIndex.setId(Integer.parseInt(result.getString("id")));
				commandeIndex.setPlaces(places);
				commandes.add(commandeIndex);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commandes;

	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
