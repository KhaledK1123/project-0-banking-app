package Banking;

public class Admin extends Employee implements java.io.Serializable{

	public int adminID;
	public String fName, lName, username, password;
	public char acctType = 'a';
	
	public void personalInfo()
	{
		System.out.println("-----------------------");
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Account Type is: " + acctType);
		System.out.println("First Name is: " + fName);
		System.out.println("Last Name is: " + lName);
		System.out.println("Admin ID is: " + adminID);
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
	
	public void cancel(Customer user)
	{
		//delete user from bankSerialization
	}
	
	public void deposit(int x, Customer user)
	{
		user.balance = user.balance + x;
		//need to change in bankSerialization
		System.out.println("Balance has been updated for " + user.username +". New Balance is: " + user.balance);
	}
	
	public void withdraw(int x, Customer user)
	{
		if(user.balance - x < 0)
		{
			System.out.println("Insufficient Funds, Ask for a Deposit....");
			return;
		}
		else
		{
		user.balance= user.balance - x;
		//need to change in bankSerialization
		System.out.println("Balance has been updated for " + user.username +". New Balance is: " + user.balance);
		}
	}
	
	public void transfer(int x, Customer user1, Customer user2)
	{
		if(user1.balance - x < 0)
		{
			System.out.println("Insufficient Funds, Ask for a Deposit from " + user1.username);
			return;
		}
		else
		{
			System.out.println(user1.username + "'s balance is being reduced by " + x);
			user1.balance = user1.balance - x;
			
			System.out.println(user2.username + "'s balance is being increased by " + x);
			user2.balance = user2.balance + x;
		}
	}
}
