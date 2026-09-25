package smartExpenseTracker;

public class RegistrationTest {
	 public static void main(String[] args) {

	        User user = new User("rahul", "1234");

	        UserController controller = new UserController();

	        controller.registerUser(user);
	    }
}
