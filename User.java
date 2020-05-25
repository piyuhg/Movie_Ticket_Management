
public class User {

	private String Username;
	private String Password;
	private String UserType;
	
	public User() {//for admin
		Username = "Admin";
		Password = "Admin";
		UserType = "Admin";
		System.out.println("Admin created successfully!!");
	}	
	public User(String Username, String Password) { //for agent
		this.Username = Username;
		this.Password = Password;
		this.UserType = "Agent";
		System.out.println("Agent Created Successfully");
	}	
	public void setUsername(String Username) {
		this.Username=Username;
	}
	public void setPassword(String Password) {
		this.Password=Password;
	}
	public void setUserType(String UserType) {
		this.UserType=UserType;
	}
	public String getUsername() {
		return this.Username;
	}
	public String getPassword() {
		return this.Password;
	}
	public String getUserType() {
		return this.UserType;
	}
	public void printUserDetails() {
		System.out.println("Username: "+this.getUsername());
		System.out.println("Password: "+this.getPassword());
		System.out.println("UserType: "+this.getUserType());
	}
}
