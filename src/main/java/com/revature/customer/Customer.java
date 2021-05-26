package com.revature.customer;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.revature.account.Account;

public class Customer implements Serializable{
	
	private int Id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	
	private static NumberFormat formatter = new DecimalFormat("#0.00");
	
	public Customer(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	public Customer(int id, String firstName, String lastName, String userName, String password) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	// array list for users
	public static ArrayList customers = new ArrayList(); {


	};
	
//	public Account getAccountInfo(Account acc) {
//		
//		Account res = null;
//		String name =  firstName + " "+ lastName;
//		if(acc.getAccountNumber() == accountNumber) {
//			res = new Account(accountNumber, acc.getBalance());
//		}
//		
//		return res;
//	}//end account info

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName() {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword() {
		this.password = password;
	}
	
  public String toString(Account acc) {
     Object id = null;
	Object department = null;
	Object name = null;
	Object stock = null;
	return String.format("ID: %d\r\nDepartment: %s\r\nName: %s\r\nBalance: %s\r\nStock: %d\r\n", 
              id, department, name, formatter.format(acc.getBalance()), stock);
  }
  
  public void printInfo() {
      System.out.println("username: " + firstName);
      System.out.println("email: " + lastName);
      System.out.println("password: " + password);
 //     System.out.println("birthday: " + accountNumber);
   //   System.out.println("age: " + age);
  }
	
	
	
	
	

}//end customer
