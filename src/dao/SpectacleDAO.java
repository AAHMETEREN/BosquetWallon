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
import pojo.Categorie.TypesCategorie;
import pojo.Configuration;
import pojo.Configuration.TypePlaces;
import pojo.Organisateur;
import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Reservation;
import pojo.Spectacle;

public class SpectacleDAO implements DAO<Spectacle> {

	protected Connection connect = null;

	public SpectacleDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Spectacle spectacle) {
		try {
			String insertSQL = "INSERT INTO Spectacle VALUES(null,'" + spectacle.getTitre() + "','"
					+ spectacle.getNombrePlaceParClient() + "')";

			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					spectacle.setId((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override
	public boolean delete(Spectacle obj) {
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		return false;
	}

	@Override
	public Spectacle find(Spectacle obj) {
		return null;
	}

	@Override
	public List<Reservation> findAll(Spectacle s) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		List<Categorie> categories = new ArrayList<Categorie>();
		System.out.println("here");
		try {
			ResultSet result = this.connect.createStatement().executeQuery(
					"SELECT Reservation.id  AS reservation_id  , Spectacle.id as spectacle_id , PlanningSalle.id as PlanningSalle_id , Personne.id as Personne_id , Configuration.id as Configuration_id ,  * FROM Reservation "
							+ " INNER JOIN PlanningSalle ON Reservation.fk_planningSalle = PlanningSalle.id "
							+ " INNER JOIN Spectacle ON Spectacle.id = PlanningSalle.fk_spectacle "
							+ " INNER JOIN Personne ON Personne.id =  Reservation.fk_personne "
							+ " INNER JOIN Configuration ON Configuration.fk_spectacle =  Spectacle.id ");

			int configurationId = Integer.parseInt(result.getString("Configuration_id"));
			if(result.next()) {
				ResultSet categoriesResult = this.connect.createStatement()
						.executeQuery("SELECT * FROM Categorie WHERE fk_configuration = '" + configurationId + "'");

				while (categoriesResult.next()) {
					int prix = (int) Float.parseFloat(categoriesResult.getString("prix"));
					int nbrPlaceDispo = (int) Float.parseFloat(categoriesResult.getString("nbrPlaceDispo"));
					int nbrPlaceMax = (int) Float.parseFloat(categoriesResult.getString("nbrPlaceMax"));
					Categorie categorie = new Categorie(TypesCategorie.valueOf(categoriesResult.getString("type")),
							prix, null, null);
					categorie.setNbrPlaceDispo(nbrPlaceDispo);
					categorie.setNbrPlaceMax(nbrPlaceMax);
					categories.add(categorie);
				}
			}
			while (result.next()) {
				
				// Creation de la configuration
				TypePlaces typePlace = TypePlaces.valueOf(result.getString("type"));
				System.out.println(typePlace);
				String description = result.getString("description");
				Configuration configuration = new Configuration(configurationId, description, typePlace, null);
				configuration.setCategories(categories);
				// Creation de spectacle
				int spectacleId = Integer.parseInt(result.getString("reservation_id"));
				int nbrPlaceParClient = Integer.parseInt(result.getString("nbrPlaceParClient"));
				System.out.println(nbrPlaceParClient);
				String titreSpectacle = result.getString("titre");
				Spectacle spectacle = new Spectacle(titreSpectacle, nbrPlaceParClient);
				spectacle.setConfiguration(configuration);
				spectacle.setId(spectacleId);

				// Creation de planning salle
				Date dateReservation = Date.valueOf(result.getString("dateDebutR"));
				PlanningSalle planningSalle = new PlanningSalle(dateReservation, spectacle);
				// Creation de l'organisateur
				Organisateur organisateur = new Organisateur();
				organisateur.setId(Integer.parseInt(result.getString("Personne_id")));
				organisateur.setNomUtilisateur(result.getString("nomUtilisateur"));
				organisateur.setNomEntreprise(result.getString("nomEntreprise"));

				// Creation de la reservation
				float acompteReservation = Float.parseFloat(result.getString("acompte"));
				float solde = Float.parseFloat(result.getString("solde"));
				float prix = Float.parseFloat(result.getString("prix"));
				Reservation reservationIndex = new Reservation(acompteReservation, solde, prix, planningSalle,
						organisateur);
				reservationIndex.setId(spectacleId);
				reservations.add(reservationIndex);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}
}
