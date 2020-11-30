package database;
import java.sql.*;
import javax.swing.JOptionPane;


public class SqliteConnection {

	private static Connection instance = null;

	private SqliteConnection()  {
		try {
			String connectionUrl = "jdbc:sqlite:C:/sqlite/BosquetWallon.sqlite3";
			instance = DriverManager.getConnection(connectionUrl);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
			JOptionPane.showMessageDialog(null, "La base Wde données est inaccessible, fermeture du programme.");
			System.exit(0);
		}
	}

	public static Connection getInstance() {
		if (instance == null) {
			
			new SqliteConnection();
		}
		return instance;
	}
}
