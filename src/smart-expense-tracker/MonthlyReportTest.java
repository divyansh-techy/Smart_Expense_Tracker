package smartExpenseTracker;

public class MonthlyReportTest {
	public static void main(String[] args) {

        ExpenseController controller = new ExpenseController();

        controller.monthlyReport(1, 9, 2026);
    }
}
