package Banking;

public class Employee implements java.io.Serializable{
	
	public int empID;
	public String fName, lName, username, password;
	public char acctType = 'e';
	
	public Employee()
	{
		String username, password, fName, lName;
		int empID;
		
	}
	
	public Employee(String username1, String password1, String fName1, String lName1, int empID1) {
		// TODO Auto-generated constructor stub
		String username = username1;
		String password = password1;
		String fName = fName1;
		String lName = lName1;
		int empID = empID1;
	}
	
	public void personalInfo()
	{
		System.out.println("-----------------------");
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Account Type is: " + acctType);
		System.out.println("First Name is: " + fName);
		System.out.println("Last Name is: " + lName);
		System.out.println("Employee ID is: " + empID);
		System.out.println("-----------------------");
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
