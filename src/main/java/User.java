
public class User {
	private int idUser;
	private String name;
	private int age;
	private String email;
	private String password;
	
	private static int count = 0;
	
	
	
	
	public User(String name, int age, String email, String password) {
		this.idUser = ++count;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
