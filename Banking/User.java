package Banking;

import java.util.Scanner;

import Banking.Employee;

import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.*;
//main
public class User extends database{

	static Scanner input= new Scanner(System.in);
	static Customer c1 = new Customer("unknown", "pass", "khaled", "khalil", 'c', 1234, false, false, 100);
	static Customer c2 = new Customer("unknown1", "pass1", "khaled1", "khalil1", 'c', 12345, false, false, 0);
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
				System.out.println("-----------------------");
				break;
			case 2:
				System.out.println("Going to Login Page!");
				System.out.println("-----------------------");
				break;
			default:
				System.out.println("Please enter a valid choice!");
			}
			
		}while(userChoice!=1 && userChoice!=2);
		
		if(userChoice==1)
		{
			//checks what the user is. Are they a C, E, or A.
			int role1= 0;
				
			do {
				role1 = pickRole();
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
			System.out.println("idk how you got here, restart terminal....");
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
		HashMap<String,Customer> map1 = new HashMap<String, Customer>();
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
		map1.put(c.username, c);
		map.put(c.username, c);
		try {
			
				FileOutputStream fileOut = new FileOutputStream("./src/serializationCustomer.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(map1);
				out.close();
				fileOut.close();
			}
			catch(IOException error)
			{	
				error.printStackTrace();
			}
		deserializeCustomer(c);
		
	}
	
	private static void createEmployee()
	{
		HashMap<String, Employee> map = new HashMap<String, Employee>();
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
		map.put(e.username, e);
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream("./src/serializationEmployee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(map);
			out.close();
			fileOut.close();
		}
		catch(IOException error)
		{	
			error.printStackTrace();
		}
		
		deserializeEmployee(e);
	}
	
	private static void createAdmin()
	{
		HashMap<String, Admin> map = new HashMap<String, Admin>();
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
		map.put(a.username, a);
		try {
			
			FileOutputStream fileOut = new FileOutputStream("./src/serializationAdmin.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(map);
			out.close();
			fileOut.close();
		}
		catch(IOException error)
		{	
			error.printStackTrace();
		}
		
		deserializeAdmin(a);
	}
	
	public static boolean checkAccountA(String user, String pass)
	{
		if(map.containsKey(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean checkAccountE(String user, String pass)
	{
		if(map.containsKey(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean checkAccountC(String user, String pass)
	{
		
		if(map.containsKey(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void deserializeCustomer()
	{	
		HashMap<String, Customer> map1 = new HashMap<String, Customer>();
		Customer c = null;
		//database.map = null;
		//map = null;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/serializationCustomer.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			map1.put(c.username, c);
			//map1=(HashMap) in.readObject();
			map1.get(c.username).personalInfo();
			in.close();
			fileIn.close();
		}
		catch(IOException error)
		{
			error.printStackTrace();
		}
	}
	public static void deserializeCustomer(Customer customer)
	{	
		HashMap<String, Customer> map1 = new HashMap<String, Customer>();
		Customer c = customer;
		//database.map = null;
		//map = null;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/serializationCustomer.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			map1.put(c.username, c);
			//map1=(HashMap) in.readObject();
			map1.get(c.username).personalInfo();
			in.close();
			fileIn.close();
		}
		catch(IOException error)
		{
			error.printStackTrace();
		}
	}
	
	public static void deserializeEmployee(Employee employee)
	{	
		HashMap<String, Employee> map1 = new HashMap<String, Employee>();
		Employee e = employee;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/serializationEmployee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			map1.put(e.username, e);
			//map1=(HashMap) in.readObject();
			map1.get(e.username).personalInfo();
			in.close();
			fileIn.close();
		}
		catch(IOException error)
		{
			error.printStackTrace();
		}
	}
	
	public static void deserializeAdmin(Admin admin)
	{	
		HashMap<String, Admin> map1 = new HashMap<String, Admin>();
		Admin a = admin;
		//database.map = null;
		//map = null;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/serializationAdmin.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			map1.put(a.username, a);
			//map1=(HashMap) in.readObject();
			map1.get(a.username).personalInfo();
			in.close();
			fileIn.close();
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
		
		 //boolean a = checkAccountC(user, pass);
//		int role = 0;
//		do
//		{
//			
//			if(checkAccountA(user,pass)==true)
//				role=3;
//			else if(checkAccountE(user,pass)==true)
//				role=2;
//			else if(checkAccountC(user,pass)==true)
//				role=1;
//			else
//				role=0;
//			switch(role)
//			{
//			case 1:
//				System.out.println("Hello Customer, what would you like to do?");
//				//System.out.println();
//				break;
//			case 2:
//				System.out.println("Hello Employee, what would you like to do?");
//				
//				break;
//			case 3:
//				System.out.println("Hello Admin, what would you like to do?");
//				
//				break;
//			default:
//				System.out.println("You are not enrolled");
//			}	
//		}
//			while(role != 1 && role != 2 && role != 3);
//			
			
		System.out.println("Login Successful");
		int menuChoice = 0;
		do
		{
			System.out.println("Hello, what would you like to do?");
			System.out.println("----------------------------");
			System.out.println("1: Deposit");
			System.out.println("2: Withdraw");
			System.out.println("3: Transfer Funds");
			System.out.println("4: Apply for a Joint Account");
			System.out.println("5: Exit");
			menuChoice=input.nextInt();
			
			switch(menuChoice)
			{
			case 1:
				System.out.println("How much would you like to deposit?");
				System.out.println("Current Balance is: " + c1.balance);
				
				int moneyDeposit = input.nextInt();
				c1.deposit(moneyDeposit);
				
				System.out.println("Deposited " + moneyDeposit);
				break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				System.out.println("Current Balance is: " + c1.balance);
			
				int moneyWithdraw = input.nextInt();
				c1.withdraw(moneyWithdraw);
				
				System.out.println("Withdrew " + moneyWithdraw);
				System.out.println("");
				break;
			case 3:
				System.out.println("How much would you like to transfer?");
				System.out.println("Current Balance is: " + c1.balance);
			
				int moneyTransfer = input.nextInt();
				
				c1.transfer(moneyTransfer, c2);
				
				System.out.println("Transfering " + moneyTransfer);
				System.out.println("Current Balance for " + c1.username + " is: " + c1.balance);
				System.out.println("New Balance for " + c2.username + " is: " + c2.balance);
				System.out.println("");				
				break;
			case 4:
				System.out.println("Current joint Status: " + c1.joint);
				c1.applyJointAccount();
				System.out.println("Joint Status has been changed!");
				System.out.println("Current joint Status: " + c1.joint);
				System.out.println("");
			default:
				System.out.println("Logged Out");
			}	
		}
			while(menuChoice != 5);	
		}
		//else
		//{
			//System.out.println("Login Unsuccessful. Try again.");
			//Login();
		//}
		
		
		//if user and pass match and customer is approved then login is successful
		//tell user if they are a user, manager, or employee
		
		//give them menu for respective role
	}
	
	
	
