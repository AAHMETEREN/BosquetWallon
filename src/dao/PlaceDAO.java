package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Place;
import pojo.Configuration;
import pojo.Organisateur;
import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Representation;
import pojo.Reservation;
import pojo.Spectacle;
import pojo.Configuration.TypePlaces;

public class PlaceDAO implements DAO<Place> {
	protected Connection connect = null;

	public PlaceDAO(Connection conn) {
		connect = conn;
	}

	@Override
	public boolean create(Place Place) {
		try {
			this.connect
			.createStatement()
			.executeUpdate("INSERT INTO Place VALUES("
					+ "null,'" 
					+ Place.getPrix()
					+ "','"
					+ Place.getCommande().getId()
					+ "','"
					+ Place.getRepresentation().getId()
					+ "','"
					+ Place.getType_categorie()
					+ "')"
				);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Place obj) {
		return false;
	}

	@Override
	public boolean update(Place obj) {
		return false;
	}



	@Override
	public List<Place> findAll(Place place) {
		return null;
	}

	@Override
	public Place find(Place obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
