package dao;

import java.sql.Connection;
import pojo.*;
public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = database.SqliteConnection.getInstance();
	

	
	public DAO<Reservation> getReservationDAO(){
		return new ReservationDAO(conn);
	}
	
	public DAO<Categorie> getCategorieDAO(){
		return new CategorieDAO(conn);
	}

	public DAO<Configuration> getConfigurationDAO(){
		return new ConfigurationDAO(conn);
	}

	public DAO<PlanningSalle> getPlanningSalleDAO(){
		return new PlanningSalleDAO(conn);
	}
	
	public DAO<Representation> getRepresentationDAO(){
		return new RepresentationDAO(conn);
	}
	
	
	public DAO<Spectacle> getSpectacleDAO(){
		return new SpectacleDAO(conn);
	}
	
	
	public PersonneDAO getPersonneDAO(){
		return new PersonneDAO(conn);
	}

}