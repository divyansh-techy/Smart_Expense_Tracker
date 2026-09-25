package smartExpenseTracker;
import java.sql.Date;
import java.util.Scanner;

public class SmartExpenseTracker {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserController userController = new UserController();
        ExpenseController expenseController = new ExpenseController();
        
        while(true) {
        	System.out.println("\n=================================");
            System.out.println("      SMART EXPENSE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice==1) {
            	 System.out.print("Enter username: ");
                 String username = sc.nextLine();

                 System.out.print("Enter password: ");
                 String password = sc.nextLine();

                 User user = new User(username, password);

                 userController.registerUser(user);
                 
            }else if(choice==2) {
            	System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();
                
                User loggedInUser = userController.loginUser(username, password);
                
                if(loggedInUser!=null) {
                	System.out.println("Welcome, " + loggedInUser.getUsername());
                	
                	while(true) {
                		 System.out.println("\n=================================");
                         System.out.println("       EXPENSE MENU");
                         System.out.println("=================================");
                         System.out.println("1. Add Expense");
                         System.out.println("2. View Expenses");
                         System.out.println("3. Edit Expense");
                         System.out.println("4. Delete Expense");
                         System.out.println("5. Monthly Report");
                         System.out.println("6. Logout");
                         System.out.print("Enter your choice: ");
                         int expenseChoice = sc.nextInt();
                         sc.nextLine();
                         
                         if(expenseChoice==1) {
                        	 System.out.print("Enter category: ");
                             String category = sc.nextLine();

                             System.out.print("Enter amount: ");
                             double amount = sc.nextDouble();
                             sc.nextLine();

                             System.out.print("Enter description: ");
                             String description = sc.nextLine();

                             System.out.print("Enter date (YYYY-MM-DD): ");
                             String dateInput = sc.nextLine();
                             
                             Date expenseDate = Date.valueOf(dateInput);
                             
                             Expense expense = new Expense(loggedInUser.getUserId(), category, amount, description, expenseDate);
                             expenseController.addExpense(expense);
                         }
                         else if(expenseChoice==2) {
                        	 expenseController.viewExpenses(loggedInUser.getUserId());
                         }
                         else if(expenseChoice==3) {
                        	 System.out.print("Enter expense ID: ");
                             int expenseId = sc.nextInt();
                             sc.nextLine();

                             System.out.print("Enter new category: ");
                             String category = sc.nextLine();

                             System.out.print("Enter new amount: ");
                             double amount = sc.nextDouble();
                             sc.nextLine();

                             System.out.print("Enter new description: ");
                             String description = sc.nextLine();

                             System.out.print("Enter new date (YYYY-MM-DD): ");
                             String dateInput = sc.nextLine();

                             Date expenseDate = Date.valueOf(dateInput);
                             Expense expense = new Expense(loggedInUser.getUserId(), category, amount, description, expenseDate);

                             expenseController.editExpense(expenseId, expense);
                        	 
                         }
                         else if(expenseChoice==4) {
                        	 System.out.print("Enter expense ID: ");
                             int expenseId = sc.nextInt();
                             sc.nextLine();

                             expenseController.deleteExpense(expenseId, loggedInUser.getUserId());
                         }
                         else if(expenseChoice==5) {
                        	 System.out.print("Enter month (1-12): ");
                             int month = sc.nextInt();

                             System.out.print("Enter year: ");
                             int year = sc.nextInt();
                             sc.nextLine();
                             expenseController.monthlyReport(loggedInUser.getUserId(), month, year);
                         }
                         else if(expenseChoice==6) {
                        	 System.out.println("Logged out successfully.");
                             break;
                         }
                         else {
                        	 System.out.println("Invalid choice.");
                         }
                         
                	}
                	
                }
                
            }
            
            else if(choice==3) {
            	System.out.println("Thank you for using Smart Expense Tracker.");
                break;
            }
            else {
            	 System.out.println("Invalid choice.");
            }
            
        }

        sc.close();

	}

}
