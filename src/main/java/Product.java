import java.util.Date;

public class Product {
	private int productId;
	private String name;
	private int price;
	private Date expirationDate;
	
	
	
	
	
	public Product(int productId,String name, int price, Date expirationDate) {
		this.productId=productId;
		this.name = name;
		this.price = price;
		this.expirationDate = expirationDate;
		Product pro;
		if(ProductManipulation.products!=null) {
		for(Product p:ProductManipulation.products) {
			if(p.price<price) {
				ProductManipulation.mostExpensiveProduct=this;
			}
		}
		}else {
			ProductManipulation.mostExpensiveProduct=this;
		}
	}
	
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
