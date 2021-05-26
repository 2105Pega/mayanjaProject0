package com.revature.account;

import java.io.Serializable;

import com.revature.customer.Customer;

public class Account {
	
	private int Id;
	protected double balance;
	private int customer_id;

	public Account(int id, double balance, int cust) {
		this.balance = balance;
		this.Id = id;
		this.customer_id = cust;
	}
	

	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	

}//end account
