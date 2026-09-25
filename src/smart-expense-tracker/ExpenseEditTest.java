package smartExpenseTracker;
import java.sql.Date;

public class ExpenseEditTest {
	 public static void main(String[] args) {

	        ExpenseController controller = new ExpenseController();

	        Expense expense = new Expense(1, "Food", 700, "Dinner", Date.valueOf("2026-09-16"));
	        
	        controller.editExpense(1, expense);
	    }

}
