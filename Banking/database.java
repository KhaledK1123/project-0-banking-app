package Banking;

import java.util.HashMap;


public class database implements java.io.Serializable{
	
	public String name;
	public String password;
	public String accountType;
	public double balance;
	
	public static HashMap<String, Object> map = new HashMap<String, Object>();
	
	public void map(String name, String password, String accountType, double balance)
	{
		database a = new database();
		a.name=name;
		a.password=password;
		a.accountType=accountType;
		a.balance=balance;
		database.map.put(name, a);
	}
}
