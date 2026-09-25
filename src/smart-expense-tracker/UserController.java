package smartExpenseTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//This class is responsible for handling user-related operations such as registration, login, and user management. from database.

public class UserController {
	public void registerUser(User user) { // User registration method that takes a User object as a parameter
		// Implement user registration logic here
		
		String query = "INSERT INTO users (username, password) VALUES (?, ?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			System.out.println("User registered successfully.");
		}
		catch(SQLException e) {
			System.out.println("Error registering user: " + e.getMessage());
		}
	}
	
	public User loginUser(String username, String password) { // User login method that takes a username and password as parameters
		// Implement user login logic here
		
		String query = "SELECT user_id, username, password FROM users WHERE username = ? AND password = ?"; 
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			try(ResultSet rs = ps.executeQuery()){
				
				if(rs.next()) {
					int userId = rs.getInt("user_id");
					String dbUsername = rs.getString("username");
					String dbPassword = rs.getString("password");
					
					User user = new User(userId, dbUsername, dbPassword); // Create a new User object with the retrieved username and password
					System.out.println("User logged in successfully.");
					return user; // Return the User object if login is successful
				}
				else {
					System.out.println("Invalid username or password.");
			}
			}
		}
		catch(SQLException e) {
			System.out.println("Error logging in user: " + e.getMessage());
		}
		return null; // Return null if login fails
	}
}
