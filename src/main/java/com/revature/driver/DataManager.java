package com.revature.driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.account.Account;
import com.revature.customer.Customer;
import com.revature.employee.Employee;

public class DataManager {
	
	static final String filePath = "";
    
    static void serializeCustomer(Customer customer, String path) {
    	//ArrayList<Account> accounts = new ArrayList<>();
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(customer);
            outputStream.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }//end serializer
     
    static Customer deserializeCustomer(String path) {
    	
        Customer savedCustomer = null;
         
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            savedCustomer = (Customer) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
         
        return savedCustomer;
    }
    
    //account
    static void serializeAccount(Account account, String path) {
    	//ArrayList<Account> accounts = new ArrayList<>();
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(account);
            outputStream.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }//end serializer
     
    static Account deserializeAccount(String path) {
    	
        Account savedCustomer = null;
         
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            savedCustomer = (Account) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
         
        return savedCustomer;
    }
    
    //employee
    static void serializeEmployee(Employee employee, String path) {
    	//ArrayList<Account> accounts = new ArrayList<>();
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(employee);
            outputStream.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }//end serializer
     
    static Employee deserializeEmployee(String path) {
    	
        Employee savedCustomer = null;
         
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            savedCustomer = (Employee) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
         
        return savedCustomer;
    }

}//end data manager
