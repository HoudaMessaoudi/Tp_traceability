import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProductManipulation {

public static	ArrayList<Product> products;

public static Product mostExpensiveProduct;

	public ProductManipulation(ArrayList<Product> products) {
	this.products = products;
}

	
	public static void displayProduct(Product p) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		System.out.println("product id :"+p.getProductId()+"");
		System.out.println("product name :"+p.getName()+"");
		System.out.println("product price :"+p.getPrice()+"");
        String strDate = dateFormat.format(p.getExpirationDate());  
		System.out.println("product experation date :"+strDate+"");
	}
	
	public void displayProducts() {
				
				System.out.println("Display Products :");
				for (Product p: products) {
					System.out.println("-----------------------------");
					displayProduct(p);
					
				}
				
				System.out.println("-----------------------------");
				
				test.logger.info("User *{}* with id /{}/, did a reading operation", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser());
		
	}

	public void fetchProduct() throws ProductNotFound {
		System.out.println("Enter product ID :");
		Scanner scan = new Scanner(System.in);
		int idProduct = scan.nextInt();
		for (Product p : products) {
			
			if (p.getProductId()==idProduct) {
				
				displayProduct(p);
				test.logger.info("User *{}* with id /{}/, did a reading operation", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser());
				if(p==this.mostExpensiveProduct) {
					test.logger.info("\nUser *{}* with id /{}/, searched expensive product id{}", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser(),this.mostExpensiveProduct.getProductId());
				}
				return;
				
			}
		}
		throw new ProductNotFound("The product with id "+idProduct +" doesnt exist ");
	}
	
	public void addProduct() throws ProductNotFound {
		System.out.println("Enter product ID : ");
		Scanner scan = new Scanner(System.in);
		int ID = scan.nextInt();
		for (Product p : products) {
			if (p.getProductId()==ID) {
			  throw new ProductNotFound("The product with id :"+ ID +" Already Exists");	
				
			}
		}
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
				
				System.out.println("Enter product name : ");
				scan.nextLine();
				String Name=scan.nextLine();
				System.out.println("Enter product price : ");
				int price = scan.nextInt();
				System.out.println("Enter product expiration date in yyyy-MM-dd format : ");
				scan.nextLine();
				String date = scan.nextLine();
				Date dateExp = null;
				
				try {
					dateExp = formatter.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Product product = new Product(ID,Name,price,dateExp);
				products.add(product);
				test.logger.info("User *{}* with id /{}/, did a writing operation", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser());
			}
		
	
	
	public void DeleteProduct() throws ProductNotFound {
		
		System.out.println("Enter product ID : ");
		Scanner scan = new Scanner(System.in);
		int ID = scan.nextInt();
		for (Product p : products) {
			if (p.getProductId()==ID) {
			  
				products.remove(p);
				test.logger.info("User *{}* with id /{}/, did a writing operation", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser());
				return;
			}
		}
		throw new ProductNotFound("The product with id :"+ ID + " doesn't Exists");
	}
	
	public void updateProduct() throws ProductNotFound {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
	
		System.out.println("Enter product ID : ");
		Scanner scan = new Scanner(System.in);
		int ID = scan.nextInt();
		for (Product p : products) {
			if (p.getProductId()==ID) {
				System.out.println("Enter new product name: ");
				scan.nextLine();
				String Name=scan.nextLine();
				System.out.println("Enter new product price: ");
				int price = scan.nextInt();
				System.out.println("Enter new product expiration date in yyyy-MM-dd format :");
				scan.nextLine();
				String date = scan.nextLine();
				Date dateExp = null;
				try {
					dateExp = formatter.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p.setName(Name);
				p.setPrice(price);
				p.setExpirationDate(dateExp);
				test.logger.info("User *{}* with id /{}/, did a reading operation", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser());
				test.logger.info("User *{}* with id /{}/, did a reading operation", UserManipulation.currentUser.getEmail(), UserManipulation.currentUser.getIdUser());
				return;
			}
			}
		throw new ProductNotFound("The product with id :"+ ID + " doesn't Exists");	
	
	}
}
