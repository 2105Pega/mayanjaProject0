package com.revature.account;

import java.util.List;

import com.revature.employee.Employee;
import com.revature.employee.EmployeeDAO;
import com.revature.employee.EmployeeDaoImpl;

public class AccountService {
	
	private AccountDAO aDao = new AccountDaoImplement();
	
	public List<Account> getListOfAccount()
	{
		return aDao.getListOfAccount();
	}
	
	
	

}//end class
