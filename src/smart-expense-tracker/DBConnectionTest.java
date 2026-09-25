package smartExpenseTracker;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
	
	public static void main(String[] args) {
		try {
			Connection con =  DBConnection.getConnection();
			System.out.println("Database connection successful!");
			con.close();
		} catch (SQLException e) {
			System.out.println("Database connection failed: " + e.getMessage());
		}
	}
	
}
