package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private String usuario = "root";
	private String senha = "root";
	private static DatabaseConnection instance;
	
	public DatabaseConnection() {}
	
	public static DatabaseConnection getInstance() {
		if(instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastros?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					usuario, 
					senha);
			
			return conn;
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
}
