package smartExpenseTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

public class ExpenseController {

	public void addExpense(Expense expense) {
		if (expense.getAmount() <= 0) {
	        System.out.println("Amount must be greater than 0.");
	        return;
	    }

	    if (expense.getCategory().isEmpty()) {
	        System.out.println("Category cannot be empty.");
	        return;
	    }
		
		String query = "INSERT INTO expenses (user_id, category, amount, description, expense_date) VALUES (?, ?, ?, ?, ?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setInt(1, expense.getUserId());
			ps.setString(2, expense.getCategory());
			ps.setDouble(3, expense.getAmount());
			ps.setString(4, expense.getDescription());
			ps.setDate(5, expense.getExpenseDate());
			
			ps.executeUpdate();
			System.out.println("Expense added successfully.");
			
		}
		catch(SQLException e) {
			System.out.println("Error adding expense: " + e.getMessage());
		}
	}
	
	public void editExpense(int expenseId, Expense expense) {
		 if (expense.getAmount() <= 0) {
		        System.out.println("Amount must be greater than 0.");
		        return;
		    }

		    if (expense.getCategory().isEmpty()) {
		        System.out.println("Category cannot be empty.");
		        return;
		    }
		
		String query = "UPDATE expenses SET category = ?, amount = ?, description = ?, expense_date = ? WHERE expense_id = ? AND user_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setString(1, expense.getCategory());
			ps.setDouble(2, expense.getAmount());
			ps.setString(3, expense.getDescription());
			ps.setDate(4, expense.getExpenseDate());
			ps.setInt(5, expenseId);
			ps.setInt(6, expense.getUserId());
			
			int rowsUpdated = ps.executeUpdate();
			
			if(rowsUpdated > 0) {
				System.out.println("Expense updated successfully.");
			} else {
				System.out.println("Expense not found.");
			}
			
		}
		catch(SQLException e) {
			System.out.println("Error updating expense: " + e.getMessage());
		}
	}
	
	public void deleteExpense(int expenseId, int userId) {
		
		String query = "DELETE FROM expenses WHERE expense_id = ? AND user_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setInt(1, expenseId);
			ps.setInt(2, userId);
			
			int rowsDeleted = ps.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Expense deleted successfully.");
			} else {
				System.out.println("Expense not found.");
			}
			
		}
		catch(SQLException e) {
			System.out.println("Error deleting expense: " + e.getMessage());
		}
	}

	public void viewExpenses(int userId) {
		
		String query = "SELECT expense_id, category, amount, description, expense_date FROM expenses WHERE user_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, userId);
			
			try(ResultSet rs = ps.executeQuery()){
				  System.out.println("ID\tCategory\t	Amount\tDescription\tDate");
		            System.out.println("-------------------------------------------------------");
		            while(rs.next()) {
		            	 int expenseId = rs.getInt("expense_id");
		                 String category = rs.getString("category");
		                 double amount = rs.getDouble("amount");
		                 String description = rs.getString("description");
		                 Date expenseDate = rs.getDate("expense_date");
		                 System.out.println(expenseId + "\t" + category + "\t\t" + amount + "\t" + description + "\t\t" + expenseDate);
		            }
			}
			
		}
		catch(SQLException e) {
			System.out.println("Unable to view expanse.");
		}
	}
	
	public void monthlyReport(int userId, int month, int year) {
		
		String query = "SELECT category, SUM(amount) AS total FROM expenses WHERE user_id = ? AND MONTH(expense_date) = ? AND YEAR(expense_date) = ? GROUP BY category";
		
		try (
		        Connection con = DBConnection.getConnection();
		        PreparedStatement pstmt = con.prepareStatement(query)
		    ) {

		        pstmt.setInt(1, userId);
		        pstmt.setInt(2, month);
		        pstmt.setInt(3, year);

		        try (ResultSet rs = pstmt.executeQuery()) {

		            System.out.println("MONTHLY EXPENSE REPORT");
		            System.out.println("----------------------------");
		            System.out.println("Category\t\tTotal");
		            System.out.println("----------------------------");

		            while (rs.next()) {

		                String category = rs.getString("category");
		                double total = rs.getDouble("total");

		                System.out.println(category + "\t\t" + total);
		            }
		        }

		    } catch (SQLException e) {

		        System.out.println("Unable to generate monthly report.");
		    }
	}
	
}
