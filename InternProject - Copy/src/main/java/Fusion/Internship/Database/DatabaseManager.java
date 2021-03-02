package Fusion.Internship.Database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseManager {
	public static Connection connection = null;

	public static Connection openConnection() throws Exception {
		//throw in properties
		final String URL = "jdbc:mysql://localhost:3306";
		final String USER = "root";
		final String PASSWORD = "A5009221356a";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			if(connection != null) {
				return connection;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return connection;
	}
	
}