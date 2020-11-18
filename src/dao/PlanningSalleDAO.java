package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Client;
import pojo.PlanningSalle;

public class PlanningSalleDAO  implements DAO<PlanningSalle> {
	protected Connection connect = null;

	public PlanningSalleDAO(Connection conn) {
		connect = conn;
	}
	@Override
	public boolean create(PlanningSalle planningSalle) {
		try {
			String insertSQL ="INSERT INTO PlanningSalle VALUES(null,'"
					+planningSalle.getdateDebutR()
					+"','"
					+planningSalle.getdateFinR()
					+"','"
					+planningSalle.getIdSpectacle()
					+"')";
			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					planningSalle.setId((int) generatedKeys.getLong(1));
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
	public boolean delete(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanningSalle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
