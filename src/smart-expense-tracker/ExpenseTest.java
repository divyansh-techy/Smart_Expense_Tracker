package smartExpenseTracker;
import java.sql.Date;

public class ExpenseTest {
	 public static void main(String[] args) {

	        Expense expense = new Expense(
	                1,
	                "Food",
	                500,
	                "Lunch",
	                Date.valueOf("2026-09-16")
	        );

	        ExpenseController controller = new ExpenseController();

	        controller.addExpense(expense);
	    }

}
