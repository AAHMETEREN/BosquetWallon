package dao;

import java.sql.Connection;
import pojo.*;
public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = database.SqliteConnection.getInstance();
	
	public DAO<Client> getClientDAO(){
		return new ClientDAO(conn);
	}

	/**public DAO<Classe> getClasseDAO(){
		return new ClasseDAO(conn);
	}
	
	public DAO<Professeur> getProfesseurDAO(){
		return new ProfesseurDAO(conn);
	}
	

	
	public DAO<Matiere> getMatiereDAO(){
		return new MatiereDAO(conn);
	}
		
	*/
}