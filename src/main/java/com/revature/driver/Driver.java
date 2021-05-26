package com.revature.driver;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.revature.account.Account;
import com.revature.account.AccountService;
import com.revature.customer.Customer;
import com.revature.customer.CustomerDaoImplement;
import com.revature.customer.CustomerService;
import com.revature.dataReader.Utility;
import com.revature.employee.Employee;
import com.revature.employee.EmployeeService;
import com.revature.utils.ConnectionUtil;


public class Driver {
	
	final static Logger logger = Logger.getLogger(Driver.class);
	static Scanner scanner = new Scanner(System.in);
	
	static ArrayList<Customer> customerList = new ArrayList<>();
	static ArrayList<Account> accountList = new ArrayList<>();
	static ArrayList<Employee> employeeList = new ArrayList<>();
	

	

	public static void main(String[] args) {
		 //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("log4j.properties");
		
	//	EmployeeService empServ = new EmployeeService();
		

//		
//		for (Employee emp : empServ.getListOfEmployee()) {
//            	System.out.println(emp.getUserName());
//            	
//		}
     //   getCustomerInfo();
//	CustomerService empServ = new CustomerService();
//	System.out.println(getIt(empServ, 1));
//	System.out.println(empServ.findById(1).getFirstName());
//	AccountService ac = new AccountService();
//	//Account acc = (Account) ac.getListOfAccount();
//		
//		for (Customer emp : empServ.getListOfCustomer()) {
//            	System.out.println(emp.getId());
            	//if(emp.getId() == )
            	
            	
            		
     
            	
//			if(emp.getUserName().equalsIgnoreCase("smith123") && emp.getPassword().equalsIgnoreCase("Smith123") ) {
//				System.out.println(emp.getUserName() + " "+emp.getPassword());
//        		customerMenu(emp);
//        		break;
//        	}
            	
	//	}
		
		//CustomerDaoImplement.getCustomerInfo();
        
    	bankMenu();
      //  getAccount();
		
		logger.debug("My Debug Log");
//		logger.info("My Info Log");
//		logger.warn("My Warn Log");
//		logger.error("My error log");
//		logger.fatal("My fatal log");
		
		 //Log in console in and log file
        logger.debug("Log4j appender configuration is successful !!");
 	
//		empServ.getListOfEmployee();
//		Customer customer = new Customer("tom","mark","mark1","pass1","100");
//		Customer customer2 = new Customer("tom2","mark2","mark2","pass2","200");
		
//		customerList.add(customer);
//		customerList.add(customer2);
		
		//get customer data
//		DataManager.serializeCustomer(customer, filePathCustomer);	
//		Customer savedCustomer = DataManager.deserializeCustomer(filePathCustomer);
		
		
		//get account data
		
	//	Account account = new Account("001", 20.00);
//		Account account2 = new Account("002", 50.00);
///		DataManager.serializeAccount(account, filePathAccount);	
//		Account savedAccount = DataManager.deserializeAccount(filePathAccount);
		
		
	

		
		
	}//end main
	
	public static void welcome() {
		 // Welcome screen
		
		
		String dash = "\t*******************************************************************\n\n";
	    System.out.print(dash);
	    System.out.print("\t\t\t\tWelcome to REVATURE BANK \n\n");
	    System.out.print(dash);

	    System.out.print("\tEnter (1) for customer: ? OR (2) for Employee or Admin:: ");
	    System.out.println();
	        
	}//end welcome
	
	public static void bankMenu() {
		
	    welcome();
		int ans = scanner.nextInt();
		
		   if(ans == 1) {
                     int num =0;
                     
                    
                     System.out.print("\tEnter username:"); 
					String username = scanner.next();
					System.out.print("\tEnter password: \n");
					String pass = scanner.next();
					
				   while((customerLogin(username, pass) ==true && num < 2 )) {
						System.out.println("\tInvalid password or username. Try again \n");
						System.out.print("\tEnter username:"); 
						 username = scanner.next();
						System.out.print("\tEnter password:");
						 pass = scanner.next();
						num++;
					}
				   
					System.out.println("\tYou don't seem to have an account Register: ");
					createCustomer();
					
//			    	  if( customerLogin(username, pass) ==true) {
//			    		//  customerLogin(username, pass);
//			    		  		    		  
//			    	  }else {
//			    		  createCustomer();
//			    	  }
			   
		   }else if(ans == 2) {
				System.out.print("\tEnter username:"); 
				String username = scanner.next();
				System.out.print("\tEnter password:");
				String pass = scanner.next();
				
				
			  if (employeeLogin(username, pass) == true ) {
				  
					System.out.println("\tLogin successfull");
			  }
			  else {
				  System.out.println("\tWrong username or password");
			  }
		   }else {
			   System.out.println("Error..Wrong input");
		   }
		   
		   
	}//end bank menu
	

	private static void checkBalance() {
		System.out.println("\tcheck balance........................");
		
		CustomerService cust = new CustomerService();
		AccountService acc = new AccountService();
	
   }//end login

	
	public static boolean customerLogin(String username, String pass) {
		
	CustomerService empServ = new CustomerService();
	
		String name = "";
		for (Customer emp : empServ.getListOfCustomer()) {
            //	System.out.println(emp.getRoleId());
			//int id = emp.getRoleId();
            	
            	if(emp.getUserName().equalsIgnoreCase(username) && emp.getPassword().equalsIgnoreCase(pass) ) {
            		customerMenu(emp);
            		break;
            	}
            	
            //	return false;
            	
		}
		
		
		return true;
	}//end getemployee
	
	public static boolean employeeLogin(String username, String pass) {

	EmployeeService empServ = new EmployeeService();
	
		String name = "";
		for (Employee emp : empServ.getListOfEmployee()) {
            	//System.out.println(emp.getRoleId());
			int id = emp.getRoleId();
			
	
            	
            	if(emp.getUserName().equalsIgnoreCase(username) && emp.getPassword().equalsIgnoreCase(pass) ) {
            		if(id == 1) {
            			name = emp.getFirstName();

            			employeeMenu(name);
            			

            		}else {

            			adminMenu(emp.getFirstName());
            			
            			
            		}
            		
            	//	break;
   
		    }
		}
		
		return true;
	}//end getemployee
	
	private static void employeeMenu(String name) {
		CustomerService cust = new CustomerService();
		Customer customer;
		int in = 0;
		
		System.out.println("\t*************************************************\n");
		System.out.print("\t\t\t Employee Login: " + name); //customer.getFirstName());
		System.out.println("\n ");
		System.out.println("\t1: View Customer Information");
		System.out.println("\t2: Pending Accounts awaiting approval");
		System.out.println("\t3: Exit \n");
		
     int option=0;
		
		while(option != 3) {
			//	System.out.println("****************************************** ");
				System.out.print("\tChoose a task: ");
			//	System.out.println("\n");
				option = scanner.nextInt();
		  	   System.out.println();
				
				switch(option) {
				case 1:
	
					getCustomerInfo();
	
					break;
					
				case 2:

					System.out.println("\n ");
					break;
					
				case 3:
				//	System.out.println("***********************************");
					System.out.print("\tEnter an amount to withdraw: ");

					System.out.println("\n ");
					break;
					
					
				default:
					System.out.println("\tInvalid option. Please enter a valid option  ");
					break;
				
				}
				
			}
			
			System.out.println("\t\tThank you for using our services");
	  
		
	}

	public static void getAccount() {
		CustomerService cust = new CustomerService(); //
		Customer cc = new Customer(1, "Mike", "Smith", "Smith123", "Smith123");
		System.out.println(cust.getListAccount(cc));
	}
	
	public static void customerMenu(Customer customer){
		//AccountService acc = new AccountService();
		
		CustomerService cust = new CustomerService();
		
		int option= 0;
		//	getCustomer();
			
			
			System.out.println("\t*************************************************\n");
			System.out.print("\t\t\t Welcome back : "  + customer.getFirstName());
			System.out.println("\n ");
			System.out.println("\t1: Check Balance");
			System.out.println("\t2: Deposit ");
			System.out.println("\t3: Withdraw ");
			System.out.println("\t4: Create Account ");
			System.out.println("\t5: Delete Account ");
			System.out.println("\t6: Register as new User: ");
			System.out.println("\t7: Logout \n");
			
			
			while(option != 7) {
			//	System.out.println("****************************************** ");
				System.out.print("\tChoose a task: ");
			//	System.out.println("\n");
				option = scanner.nextInt();
		  	   System.out.println();
				
				switch(option) {
				case 1:
			
					cust.getListAccount(customer);
					System.out.println("\t************************************");
	
					break;
					
				case 2:
	
					cust.depositAccount(customer);
//					deposit(amout);
					System.out.println("\n ");
					break;
					
				case 3:
			
					System.out.print("\tEnter amount to withdraw: ");
			
					cust.withdrawAccount(customer);

					System.out.println("\n ");
					break;
					
				case 4:

					System.out.print("\tEnter your customer ID: ");
					int customer_id = scanner.nextInt();
					System.out.print("\tEnter starting amount: ");
					double balance = scanner.nextDouble();
					cust.createAccount(balance, customer_id);
					System.out.println("\tCreating Account ................ ");
					break;
					
				case 5:
					cust.deleteAccount();
					break;
					
				case 6:
					
					System.out.print("\tEnter first name: ");
					String f_name = scanner.next();
					System.out.print("\tEnter last name: ");
					String l_name = scanner.next();
					System.out.print("\tEnter username: ");
					String customer_username = scanner.next();
					System.out.print("\tEnter password: ");
					String customer_password = scanner.next();
					System.out.println();

				//	Customer cust = new Customer(f_name, l_name, customer_username, customer_password);
					
					System.out.print("\tGenerating your information............................\n");
					
					cust.createCustomer(f_name, l_name, customer_username, customer_password);
			
					break;
					
				default:
					System.out.println("\tInvalid option. Please enter a valid option  ");
					break;
				
				}
				
			}
//			}while(option != 5);
			
			System.out.println("\t\tThank you for using our services");
	  
	
		
	}//end show menu
	
	
	public static void adminMenu(String name) {
		CustomerService cust = new CustomerService();
		Customer customer;
		int in = 0;
		
		
		System.out.println("\t*************************************************\n");
		System.out.print("\t\t\t Admin Login: " + name); 
		System.out.println("\n ");
		System.out.println("\t1: View Customer Information");
		System.out.println("\t2: Update User Information");
		System.out.println("\t3: Create User");
		System.out.println("\t4: Delete User");
		System.out.println("\t5: Logout \n");
		
		int option = 0;
		
		while(option != 5) {
			//	System.out.println("****************************************** ");
				System.out.print("\tChoose a task: ");
			//	System.out.println("\n");
				option = scanner.nextInt();
		  	   System.out.println();
				
				switch(option) {
				case 1:
					getCustomerInfo();
				
					break;
					
				case 2:
					System.out.println("\n ");
					break;
					
				case 3:
					System.out.println("\tTo create Employee (1), for Customer (2): ");
					in = scanner.nextInt();
					if(in == 1) {
						createEmployee();
						System.out.println("\tEmployee succesfully created........ ");
					}else {
						createCustomer();
						System.out.println("\tCustomer succesfully created........ ");
					}
					
					break;
					
				case 4:
					EmployeeService emp = new EmployeeService();
					System.out.println("\tEnter employee id:");
					int n = scanner.nextInt();
                  //  cust.deleteAccount(n);
					System.out.println("\n ");
					break;
					
				case 5:
					System.out.println("\t*********************************** ");
					break;
					
				default:
					System.out.println("\tInvalid option. Please enter a valid option  ");
					break;
				
				}
				
			}
			
			System.out.println("\t\tThank you for using our services");
	  
		
	}//end menu
	
	public static void getCustomerInfo() {
		 CustomerService cust = new CustomerService();
		 
		System.out.print("\tEnter Customer ID: ");
		int in = scanner.nextInt();
	
		String fname = cust.findById(in).getFirstName();
		String lname =  cust.findById(in).getLastName();

		  System.out.println("\t"+fname  +"\t  "+ lname +"\t  ");
	
			  System.out.println("\tAccounts: "+cust.getListAccount(cust.findById(in)));
			  System.out.println("\n");
	

	}
	

	
	
	
	public static Customer createCustomer() {
		
		System.out.print("\tEnter first name: ");
		String f_name = scanner.next();
		System.out.print("\tEnter last name: ");
		String l_name = scanner.next();
		System.out.print("\tEnter username: ");
		String customer_username = scanner.next();
		System.out.print("\tEnter password: ");
		String customer_password = scanner.next();
		System.out.println();

		Customer cust = new Customer(f_name, l_name, customer_username, customer_password);
		
		System.out.print("\tGenerating your information............................\n");
		
		return cust;
	}//end 
	
	public static Employee createEmployee() {
		
//		System.out.println("\tTo create Employee (1), for Customer (2): ");
//		int in = scanner.nextInt();
		
		System.out.print("\tEnter first name: ");
		String f_name = scanner.next();
		System.out.print("\tEnter last name: ");
		String l_name = scanner.next();
		System.out.print("\tEnter Role ID: (1) Employee: (2) Admin: ");
		int roles_id = scanner.nextInt();
		System.out.print("\tEnter username: ");
		String employee_username = scanner.next();
		System.out.print("\tEnter password: ");
		String employee_password = scanner.next();
		System.out.println();

		Employee emp = new Employee(f_name, l_name, roles_id, employee_username, employee_password);
		
		return emp;
	}//end 
	
	
	
	


}//end driver
