package Banking;

public class Customer implements java.io.Serializable{

	
	public String username, password, fName, lName;
	public char acctType = 'c';
	public int acctNum;
	public boolean joint = false;
	public boolean approve = false;
	public double balance=0;
	
	public Customer()
	{
		String username, password, fName, lName;
		char acctType = 'c';
		int acctNum;
		boolean joint = false;
		boolean approve = false;
		double balance=0;
	}
	public Customer(String username1, String password1, String fName1, String lName1, char acctType1, int acctNum1, boolean joint1, boolean approve1, double balance1 ) {
		// TODO Auto-generated constructor stub
		String username = username1;
		String password, fName, lName;
		char acctType = 'c';
		int acctNum = acctNum1;
		boolean joint = joint1;
		boolean approve = approve1;
		double balance=balance1;
	}
	public Customer(String username1, String password1, String fName1, String lName1, int acctNum1) {
		// TODO Auto-generated constructor stub
		String username, password, fName, lName;
		int acctNum = acctNum1;
	}

	public void personalInfo()
	{
		System.out.println("-----------------------");
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Account Type is: " + acctType);
		System.out.println("First Name is: " + fName);
		System.out.println("Last Name is: " + lName);
		System.out.println("Joint Account: " + joint);
		System.out.println("Approved Account: " + approve);
		System.out.println("Account Number is: " + acctNum);
		System.out.println("-----------------------");
	}
	
	public void applyJointAccount()
	{
		joint=true;
		
	}
	
	public void deposit(int x)
	{
		balance = balance + x;
		//need to change in bankSerialization
		System.out.println("Balance has been updated. New Balance is: " + balance);
	}
	
	public void withdraw(int x)
	{
		if(balance - x < 0)
		{
			System.out.println("Insufficient Funds, Add a Deposit....");
			return;
		}
		else
		{
		balance= balance - x;
		//need to change in bankSerialization
		System.out.println("Balance has been updated. New Balance is: " + balance);
		}
		
	}
	
	public void transfer(int x, Customer user)
	{
		if(balance - x < 0)
		{
			System.out.println("Insufficient Funds, Add a Deposit....");
			return;
		}
		else
		{
			System.out.println(username + "'s balance is being reduced by " + x);
			balance = balance - x;
			
			System.out.println(user.username + "'s balance is being increased by " + x);
			user.balance = user.balance + x;
		}
	}
	
}
