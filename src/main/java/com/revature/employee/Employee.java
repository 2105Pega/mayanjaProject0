package com.revature.employee;

import java.io.Serializable;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private int roleId;
	
	//logininfo
	private String userName;
	private String password;
	
	public Employee(int id, String firstName, String lastName, int roleId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
	}
	
	


	public Employee(int id, String firstName, String lastName, int roleId, String userName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
		this.userName = userName;
		this.password = password;
	}


	public Employee(String f_name, String l_name, int roles_id, String employee_username, String employee_password) {
		// TODO Auto-generated constructor stub
		this.firstName = f_name;
		this.lastName = l_name;
		this.roleId = roles_id;
		this.userName = employee_username;
		this.password = employee_password;
	}




	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", roleId=" + roleId + ", userName=" + userName
				+ "]";
	}
	
	
//    @Override
//    public String toString() {
//        return String.format("ID: %d\r\nDepartment: %s\r\nName: %s\r\nPrice: %s\r\nStock: %d\r\n", 
//                id, department, name, formatter.format(price), stock);
//    }
//	
	
	
	

}//end employee
