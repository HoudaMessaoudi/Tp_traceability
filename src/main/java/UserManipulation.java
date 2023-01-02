import java.util.ArrayList;
import java.util.Scanner;

public class UserManipulation {
	public static User currentUser;
	public 	ArrayList<User> Users;
	
	
	
	public UserManipulation(ArrayList<User> users) {
		Users = users;
	}
	
	

	public static User getCurrentUser() {
		return currentUser;
	}



	public static void setCurrentUser(User currentUser) {
		UserManipulation.currentUser = currentUser;
	}



	public ArrayList<User> getUsers() {
		return Users;
	}



	public void setUsers(ArrayList<User> users) {
		Users = users;
	}



	public void creatUser() {
		System.out.println("Enter user full name : ");
		Scanner scan = new Scanner(System.in);
		String name=scan.nextLine();
		System.out.println("Enter user age : ");
		int age = scan.nextInt();
		System.out.println("Enter user email : ");
		scan.nextLine();
		String email=scan.nextLine();
		System.out.println("Enter user password : ");
		String password=scan.nextLine();
		User newUser= new User(name,age,email,password);
		this.Users.add(newUser);
		System.out.println("Your account have been successfully created! you may login now");
		
		
	}
	public void loginUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter user email : ");
		String email=scan.nextLine();
		for (User u: Users) {
			
			if(u.getEmail().equals(email)) {
				System.out.println("Enter user password : ");
				String psswd=scan.nextLine();
				if(u.getPassword().equals(psswd)) {
					UserManipulation.currentUser=u;
					System.out.println("You are connected! : ");
					return;
				}else {
					System.out.println("incorrect password!! : ");
					return;
				}
				
			}
		}
		System.out.println("The email '"+email+"'doesn't exist!'");
		return;
		
	}
	public void logoutUser() {
		UserManipulation.currentUser=null;
	}
	
}


