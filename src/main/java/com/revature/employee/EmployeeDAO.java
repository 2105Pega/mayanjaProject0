package com.revature.employee;

import java.util.List;

public interface EmployeeDAO {
	
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(int e);
	public List<Employee> getListOfEmployee();
	public Employee findById(int id);
	public double[] getAvgAndSum();
	

}
