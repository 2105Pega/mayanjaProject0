package com.revature.customer;

import java.util.List;

import com.revature.account.Account;

public interface CustomerDAO {
	
	public List<Customer> getListOfCustomer();
	public boolean createAccount(double amount, int id);
	public boolean depositAccount(Customer customer, double amount);
	public boolean withdrawAccount(Customer customer, double amount);
	public boolean checkCredentials();
	public boolean createCustomer(String f_name, String l_name, String customer_username, String customer_password);
	public boolean deleteAccount(int acc);

}//end interface
