package com.revature.dataReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.revature.account.Account;
import com.revature.customer.Customer;
import com.revature.employee.Employee;

public class Utility {
	
	/*
	 * read in data for accounts
	 * @param filename is the name for the data file
	 * */
	public static ArrayList<Account> readAccountData(String fileName) {
		
		ArrayList<Account> accounts = new ArrayList<>();
		
		try {
			FileReader file = new FileReader(fileName);
			
		
			BufferedReader br = new BufferedReader(file);
			String  line;
			while((line = br.readLine()) != null) {
			      String[] currentAccount = line.split(",");

			     String accNumber = currentAccount[0];
			     double balance = Double.parseDouble(currentAccount[1]);
			     
			     System.out.println(currentAccount[0] + ' ' +currentAccount[1]);
	
		     
//			     //account info
  		 //        Account account = new Account(accNumber, balance);
		//	     accounts.add(account);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}//end account data
	
	
	/*
	 * read in data for customer
	 * @param filename is the name for the data file
	 * */
	public static ArrayList<Customer> readCustomerData(String fileName) {
		
		ArrayList<Customer> customers = new ArrayList<>();
		
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);
			String  line;
			while((line = br.readLine()) != null) {
			     String[] currentAccount = line.split(",");
			     String firstName = currentAccount[0];
			     String lastName = currentAccount[1];
			     String userName = currentAccount[2];
			     String password = currentAccount[3];
			     String accNumber = currentAccount[4];
			     
			 //    System.out.println(firstName + ' ' +lastName + ": "+ userName+' '+password +' '+accNumber);
			     
			     //account info
//			     Customer account = new Customer(firstName, lastName, userName, password, accNumber);
//			     customers.add(account);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return customers;
	}//end customer data
	
	
	/*
	 * read in data for employee
	 * @param filename is the name for the data file
	 * */
	public static ArrayList<Employee> readEmployeeData(String fileName) {
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);
			String  line;
			while((line = br.readLine()) != null) {
			     String[] currentAccount = line.split(",");
			     String firstName = currentAccount[0];
			     String lastName = currentAccount[1];
			     String status = currentAccount[2];
			 
			     String name = firstName+' '+lastName;
			     System.out.println(firstName + ' ' +lastName + ": "+ status);
			     
			     //account info
//			     Employee employee = new Employee(name,status);
//			     employees.add(employee);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return employees;
	}//end employee data

}//end utility
