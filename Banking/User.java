package Banking;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//main
public class User {

	static Scanner input= new Scanner(System.in);
	static Customer c1 = new Customer("unknown", "pass", "khaled", "khalil", 'c', 1234, false, false, 100);
	static Customer c2 = new Customer("unknown1", "pass1", "khaled1", "khalil1", 'c', 12345, false, false, 1001);
	static boolean x = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int userChoice;
		do {
			//checks if user is a new user or existing user
			System.out.println("Hello, press 1 for New User, and 2 for Existing User");
			userChoice=input.nextInt();
			System.out.println(userChoice);
			
			switch(userChoice)
			{
			case 1:
				System.out.println("Creating an Account!");
				break;
			case 2:
				System.out.println("Going to Login Page!");
				break;
			default:
				System.out.println("Please enter a valid choice!");
			}
			
		}while(userChoice!=1 && userChoice!=2);
		
		if(userChoice==1)
		{
			//checks what the user is. Are they a C, E, or A.
			int role1= pickRole();
				
			do {
				
				switch(role1)
				{
				case 1:
					System.out.println("Customer");
					createCustomer();
					break;
				case 2:
					System.out.println("Employee");
					createEmployee();
					break;
				case 3:
					System.out.println("Admin");
					createAdmin();
					break;
				default:
					System.out.println("Invalid Entry");
				}				
			}
			while(role1!=1 && role1!= 2 && role1 !=3 );
			
			System.out.println("Moving to Login Section. ");
			Login();
		}
		else if(userChoice==2)
		{
			System.out.println("Moving to Login Section. ");
			Login();
		}
		else
		{
			System.out.println("idk how you got here, restart terminal you clown....");
		}
		
		
		
		
		
		input.close();
		}
	
	
	
	private static int pickRole()
	{
		
		
		System.out.println("Please enter an Account Type. Options are Customer, Employee, Admin. Write C, E, A respectfully: ");
		char roles = input.next().charAt(0);
		System.out.println("Account Type is: " + roles);
		
		int role = 0;
		if(roles == 'C' || roles == 'c')
		{
			role=1;
		}
		else if(roles == 'E' || roles == 'e')
		{
			role=2;
		}
		else if(roles == 'A' || roles == 'a')
		{
			role=3;
		}
		
		return role;
				
	}
	
	private static void createCustomer()
	{
		Customer c = new Customer();
		//asking for all user info
		System.out.println("Choose a New Username: ");
		c.username = input.next();
		System.out.println("Username is: " + c.username);
		
		System.out.println("Choose a New Password: ");
		c.password = input.next();
		System.out.println("Password is: " + c.password);
			
		System.out.println("Please enter an Account Number: ");
		c.acctNum = input.nextInt();
		System.out.println("Account Number is: " + c.acctNum);
			
		System.out.println("Please enter a first name: ");
		c.fName=input.next();
		System.out.println("First Name is: " + c.fName);
			
		System.out.println("Please enter a last name: ");
		c.lName=input.next();
		System.out.println("Last Name is: " + c.lName);
		
		System.out.println("Successfully made a customer account. Ask for Approval before Login.");
		
		try {
			
				FileOutputStream fileOut = new FileOutputStream("./src/bankSerialization.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(c);
				out.close();
				fileOut.close();
			}
			catch(IOException error)
			{	
				error.printStackTrace();
			}
		
	}
	
	private static void createEmployee()
	{
		Employee e = new Employee();
		//asking for all user info
		System.out.println("Choose a New Username: ");
		e.username = input.next();
		System.out.println("Username is: " + e.username);
		
		System.out.println("Choose a New Password: ");
		e.password = input.next();
		System.out.println("Password is: " + e.password);
		
		System.out.println("Please enter a first name: ");
		e.fName=input.next();
		System.out.println("First Name is: " + e.fName);
			
		System.out.println("Please enter a last name: ");
		e.lName=input.next();
		System.out.println("Last Name is: " + e.lName);

		System.out.println("Please enter an Employee ID Number: ");
		e.empID=input.nextInt();
		System.out.println("EmpID is: " + e.empID);
		
		System.out.println("Successfully made an employee account!");
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream("./src/bankSerialization.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
		}
		catch(IOException error)
		{	
			error.printStackTrace();
		}
	}
	
	private static void createAdmin()
	{
		Admin a = new Admin();
		//asking for all user info
		System.out.println("Choose a New Username: ");
		a.username = input.next();
		System.out.println("Username is: " + a.username);
		
		System.out.println("Choose a New Password: ");
		a.password = input.next();
		System.out.println("Password is: " + a.password);
		
		System.out.println("Please enter a first name: ");
		a.fName=input.next();
		System.out.println("First Name is: " + a.fName);
			
		System.out.println("Please enter a last name: ");
		a.lName=input.next();
		System.out.println("Last Name is: " + a.lName);
		
		System.out.println("Please enter an Admin ID Number: ");
		a.adminID=input.nextInt();
		System.out.println("Admin ID is: " + a.adminID);
		
		System.out.println("Successfully made an Admin account!");
		try {
			
			FileOutputStream fileOut = new FileOutputStream("./src/bankSerialization.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a);
			out.close();
			fileOut.close();
		}
		catch(IOException error)
		{	
			error.printStackTrace();
		}
	}
	
	private static void Login()
	{
		System.out.println("Enter your Username: ");
		String user = input.next();
		System.out.println("Enter your Password: ");
		String pass = input.next();
		//hard coding a successful login
		if(user==c1.username && pass==c1.password)
		{
		System.out.println("Login Successful");
		int menuChoice = 0;
		do
		{
			System.out.print("Hello");
			
			switch(menuChoice)
			{
			case 1:
				System.out.println("new switch");
				
				break;
			case 2:
				System.out.println("new switch");
				
				break;
			case 3:
				System.out.println("new switch");
				
				break;
			default:
				System.out.println("Invalid Entry");
			}	
		}
		while(menuChoice != 1 && menuChoice != 2 && menuChoice != 3);	
		}
		else
		{
			System.out.println("Login Unsuccessful. Try again.");
			Login();
		}
		
		
		//if user and pass match and customer is approved then login is successful
		//tell user if they are a user, manager, or employee
		
		//give them menu for respective role
	}
	
	}
