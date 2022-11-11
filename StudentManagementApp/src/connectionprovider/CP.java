package connectionprovider;

import java.sql.Connection;
import java.sql.DriverManager;
 

public class CP {
	
	static Connection connection;
	
	public static Connection createConnection() {
		
		try {
			
			//1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Create the Connection
			String userString = "root";
			String passString = "root";
			String urlString = "jdbc:mysql://localhost:3306/student_manage";
			
			connection = (Connection) DriverManager.getConnection(urlString,userString,passString);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
