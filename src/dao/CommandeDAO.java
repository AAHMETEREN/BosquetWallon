package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Commande;
import pojo.Configuration;
import pojo.Organisateur;
import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Representation;
import pojo.Reservation;
import pojo.Spectacle;
import pojo.Configuration.TypePlaces;

public class CommandeDAO implements DAO<Commande> {
	protected Connection connect = null;

	public CommandeDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Commande commande) {
		try {
			this.connect
			.createStatement()
			.executeUpdate("INSERT INTO Commande VALUES("
					+ "null,'" 
					+ commande.getModeDePayement()
					+ "','"
					+ commande.getModeDeLivraison()
					+ "','"
					+ commande.getCout()
					+ "','"
					+ commande.getPersonne().getId()
					+ "')"
				);
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
	public List<Commande> findAll(Commande representation) {
		return null;
	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
