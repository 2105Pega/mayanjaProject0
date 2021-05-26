package com.revature.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.AccountService;
import com.revature.employee.Employee;
import com.revature.utils.ConnectionUtil;

public class CustomerService {
	
	private CustomerDaoImplement uDao = new CustomerDaoImplement();
	
	public void depositAccount(Customer customer)
	{
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Account ID: ");
//		int id = sc.nextInt();
		System.out.println("\tEnter amount to deposit: ");
		double money = sc.nextDouble();
		
			uDao.depositAccount(customer, money);

	}
	
	public void withdrawAccount(Customer customer)
	{
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Account ID: ");
//		int id = sc.nextInt();
	//	System.out.println("How much money do you want to withdraw?");
		double money = sc.nextDouble();
		
			uDao.withdrawAccount(customer, money);

	}//end withdraw
	
	public List<Customer> getListOfCustomer() //get list of accounts
	{
		return uDao.getListOfCustomer();
	}//end get customer
	
	public List<Account> getListAccount(Customer customer){
		AccountService accList = new AccountService();
		List<Account> account = new ArrayList<Account>();
		

		try {
			for(Account acc: accList.getListOfAccount()) {
				
				if(acc.getCustomer_id() == customer.getId()) {
					System.out.println("\tAccount ID: " + acc.getId() +"\tAccount balance: " + acc.getBalance());
					account.add(acc);
				}
				

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;
	}//end get accounts
	
	public boolean createAccount(double amount, int id)
	{
		//Main we have service class is to add any business logic you want
		return uDao.createAccount(amount, id);
	}
	
	public boolean createCustomer(String f_name, String l_name, String customer_username, String customer_password)
	{
		//Main we have service class is to add any business logic you want
		return uDao.createCustomer(f_name, l_name, customer_username, customer_password);
	}
	
	public boolean deleteAccount()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID of account to be deleted: ");
		int cust = sc.nextInt();
		//Main we have service class is to add any business logic you want
		return uDao.deleteAccount(cust);
	}
	
	public boolean getCustomerAccountInfo(List<Account> account) {
//		AccountService accList = new AccountService();
//		List<Account> account = new ArrayList<Account>();
//		List<Customer> cust = getListOfCustomer();
		
		for(Account acc: account) {
			
			//if(acc.getCustomer_id() == customer.getId()) {
			//	System.out.println("\tAccount balance: " + acc.getBalance());
				System.out.println( "\t"+ acc.getId() +"\t"+ acc.getBalance());
			//	account.add(acc);
	//		}
			

		}
		
		
		return false;
	}
	
	public Customer findById(int id)
	{
		return uDao.findById(id);
	}
	
	
	
}//end class

