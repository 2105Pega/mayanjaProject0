package com.revature.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDAO{

	@Override
	public boolean addEmployee(Employee e) {
		try (Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "insert into employees(f_name, l_name, roles_id, employee_username, employee_password)"
							+ "values(?,?,?,?,?)";
					
					PreparedStatement statement = conn.prepareStatement(sql);
					
					//Adds the first name variable from the Employee object to the first "?" of our prepared statement
					statement.setString(1, e.getFirstName()); 
					statement.setString(2, e.getLastName());
					statement.setInt(3, e.getRoleId()); //Since roleID is an integer you must use setInt() instead
					statement.setString(4, e.getUserName()); 
					statement.setString(5, e.getPassword());
					statement.execute();
					
					return true;
					
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
		
		return false;
	}

	@Override
	public boolean removeEmployee(int id) {
		try (Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "Delete from employees where employees_id = ?";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setInt(1, id);
				
				statement.execute();
				
				return true;
				
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		return false;
	}

	@Override
	public List<Employee> getListOfEmployee() {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from employees";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Employee> empList = new ArrayList<Employee>();
			
			while(result.next())
			{
				Employee e = new Employee (
						result.getInt("employees_id"),
						result.getString("f_name"),
						result.getString("l_name"),
						result.getInt("roles_id"),
						result.getString("employee_username"),
						result.getString("employee_password")
				);
				
				empList.add(e);
			}
			
			return empList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee findById(int id) {
	try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from employees where employees_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id); //Inputs id value into the first "?"
			
			ResultSet result = statement.executeQuery();
			
			result.next(); //Gets the first row from our select statement
			
			Employee e = new Employee(
					result.getInt("employees_id"),
					result.getString("f_name"),
					result.getString("l_name"),
					result.getInt("roles_id")
			);
			
			return e;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public double[] getAvgAndSum() {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from get_avg_and_sum()";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			result.next(); //Gets the first row of our table
			
			return new double[] {result.getDouble("avg_salary"), result.getDouble("sum_salary")};
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}//end calss
