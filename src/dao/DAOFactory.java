package dao;

import java.sql.Connection;
import pojo.*;
public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = database.SqliteConnection.getInstance();
	
	public DAO<Client> getClientDAO(){
		return new ClientDAO(conn);
	}
	
	public DAO<Reservation> getReservationDAO(){
		return new ReservationDAO(conn);
	}
	
	public DAO<Categorie> getCategorieDAO(){
		return new CategorieDAO(conn);
	}

	public DAO<Configuration> getConfigurationDAO(){
		return new ConfigurationDAO(conn);
	}
	
	
	public DAO<Organisateur> getOrganisateurDAO(){
		return new OrganisateurDAO(conn);
	}
	
	
	public DAO<Personne> getPersonneDAO(){
		return new PersonneDAO(conn);
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

}