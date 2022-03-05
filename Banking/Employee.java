package Banking;

public class Employee implements java.io.Serializable{
	
	public int empID;
	public String fName, lName, username, password;
	public char acctType = 'e';
	
	public void personalInfo()
	{
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Account Type is: " + acctType);
		System.out.println("First Name is: " + fName);
		System.out.println("Last Name is: " + lName);
		System.out.println("Employee ID is: " + empID);
	}
	public void viewCustomer(Customer user)
	{
		user.personalInfo();
	}
	
	public void deny(Customer user)
	{
		user.approve = false;
	}
	
	public void approve(Customer user)
	{
		user.approve = true;
	}
	
}
