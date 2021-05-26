package com.revature.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.account.Account;
import com.revature.employee.Employee;
import com.revature.utils.ConnectionUtil;

public class CustomerDaoImplement implements CustomerDAO {

	
    public List<Customer> getListOfCustomer() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from customer_table";
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Customer> accList = new ArrayList<Customer>();
			
			while(result.next())
			{
				Customer e = new Customer (
						result.getInt("customer_id"),
						result.getString("f_name"),
						result.getString("l_name"),
						result.getString("customer_username"),
						result.getString("customer_password")
				);
				
				accList.add(e);
			}
			
			return accList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return null;
	}
    
 
	public boolean createCustomer(String f_name, String l_name, String customer_username, String customer_password) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "insert into customer_table(f_name, l_name, customer_username, customer_password)values (?,?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, f_name);
			statement.setString(2, l_name);
			statement.setString(3, customer_username);
			statement.setString(4, customer_password);
			statement.execute();

			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean deleteAccount(int acc) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "Delete from account_table where acc_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, acc);
			
			statement.execute();
			
			return true;
			
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean depositAccount(Customer customer, double amount) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Update account_table set acc_balance = acc_balance + ? " + "where acc_id = ("
					+ "select acc_id from customer_table" + "	where customer_id = ?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			//statement.setInt(1, acc_id);
			statement.setDouble(1, amount);
			statement.setInt(2, customer.getId());

			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean withdrawAccount(Customer customer, double amount) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Update account_table set acc_balance = acc_balance - ? " + "where acc_id = ("
					+ "select acc_id from customer_table" + "	where customer_id = ?) ";

			PreparedStatement statement = conn.prepareStatement(sql);

//			statement.setDouble(1, amount);
//			statement.setInt(2, customer.getId());
		//	statement.setString(3, accountType);
			
			statement.setDouble(1, amount);
			statement.setInt(2, customer.getId());

			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}
	
	public Customer findById(int id) {
		   try (Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "select * from customer_table where customer_id = ?";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setInt(1, id); //Inputs id value into the first "?"
				
				ResultSet result = statement.executeQuery();
				
				result.next(); //Gets the first row from our select statement
				
				Customer e = new Customer(
						result.getInt("customer_id"),
						result.getString("f_name"),
						result.getString("l_name"),
						result.getString("customer_username"),
						result.getString("customer_password")
				);
				
				return e;
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
			return null;
		}


	
	
	public void getCustomer() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM user_table");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
              //  getCustomer.add(rs);
            }
            rs.close();
            ps.close();


		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	public boolean createAccount(double amount, int id) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "insert into account_table(acc_balance,customer_id)values(?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setDouble(1, amount);
			statement.setInt(2, id);
//			statement.setString(3, cust.getUserName());
//			statement.setString(4, cust.getPassword());
			statement.execute();

			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean checkCredentials() {
		// TODO Auto-generated method stub
		return false;
	}

}//end class

