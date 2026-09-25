package smartExpenseTracker;
import java.sql.Date;

public class Expense {
	
	private int expenseId;
	private int userId;
    private String category;
    private double amount;
    private String description;
    private Date expenseDate;
	
    public Expense(int userId, String category, double amount, String description, Date expenseDate) {

    		this.userId = userId;
    		this.category = category;
    		this.amount = amount;
   			this.description = description;
   			this.expenseDate = expenseDate;
}

	public int getExpenseId() {
		return expenseId;
	}

	public int getUserId() {
		return userId;
	}

	public String getCategory() {
		return category;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}
    
	
    
}
