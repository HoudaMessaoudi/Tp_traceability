import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class test {
	final public static Logger logger = LogManager.getLogger(test.class);
	public static void main(String[] args){
		
		LogManipulation logMan=new LogManipulation();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
		User user= new User("NoR El Houda",23,"houda@esi.dz","psswd");
		User user1= new User("Rayen",24,"rayan@esi.dz","pss");
		User user2= new User("Sliman",62,"sliman@esi.dz","pss");
		User user3= new User("user3",63,"user3@esi.dz","pss");
		User user4= new User("user4",64,"user4@esi.dz","pss");
		User user5= new User("user5",65,"user5@esi.dz","pss");
		User user6= new User("user6",67,"user6@esi.dz","pss");
		User user7= new User("user7",67,"user7@esi.dz","pss");
		User user8= new User("user8",68,"user8@esi.dz","pss");
		User user9= new User("user9",69,"user9@esi.dz","pss");
		ArrayList<User> listUsers= new ArrayList<User> ();
		
		listUsers.add(user);listUsers.add(user1);listUsers.add(user2);listUsers.add(user3);listUsers.add(user4); listUsers.add(user5);listUsers.add(user6);
		listUsers.add(user7); listUsers.add(user8); listUsers.add(user9);
		
		UserManipulation userman=new UserManipulation(listUsers);
		Date date = null;
		try {
			date = formatter.parse("2024-11-10");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Product p1= new Product(50,"Face cream",300,date);
		try {
			date=formatter.parse("2023-12-30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Product p2= new Product(51,"Sausage",10,date);
		try {
			date=formatter.parse("2023-12-20");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Product p3= new Product(52,"Yoghurt",4,date);
		
		ArrayList<Product> list= new ArrayList<Product> ();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		ProductManipulation productMan= new ProductManipulation(list);
		
		int choix;
		do {
			
			System.out.println("********************Login********************");
			System.out.println("1: Login");
			System.out.println("2: Creat new account");
			if(UserManipulation.getCurrentUser()!=null) {
				System.out.println("3: Logout");
				System.out.println("4: Generate profiles");
			}
			
			System.out.println("5: Quit");
			Scanner scan = new Scanner(System.in);
			choix= scan.nextInt();
			switch (choix){
			case 1:
				userman.loginUser();
				if(UserManipulation.currentUser!=null) {
					int choice;
					do {
						System.out.println("********************Command Options********************");
						System.out.println("1: Display All products");
						System.out.println("2: Fetch a product by ID");
						System.out.println("3: Add a new product");
						System.out.println("4: Delete a product by ID");
						System.out.println("5: Update a product’s info");
						System.out.print("6: Quit");
						
						choice= scan.nextInt();
						
						switch (choice){
						    case 1:
						    	productMan.displayProducts();
						        break;
						    case 2:
								try {
									productMan.fetchProduct();
								} catch (ProductNotFound e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        break;
						    case 3:
								try {
									productMan.addProduct();
								} catch (ProductNotFound e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        break;
						    case 4:
						    	try {
									productMan.DeleteProduct();
								} catch (ProductNotFound e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        break;
						    case 5:
							try {
								productMan.updateProduct();
							} catch (ProductNotFound e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						        break;
						        
						    case 6:
								 break;	

						        }  
						}while (choice != 6);
				}
				 break;
			case 2:
				userman.creatUser();
				 break;	
			case 3:
				userman.logoutUser();
				 break;	
			case 4:
				logMan.updateProfile();
				 break;	
			case 5:
				 break;
				 
			}
		}while (choix != 5);	
	}
	
	
}
