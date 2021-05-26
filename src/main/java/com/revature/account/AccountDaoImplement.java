package com.revature.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.customer.Customer;
import com.revature.utils.ConnectionUtil;

public class AccountDaoImplement implements AccountDAO {

	@Override
	public List<Account> getListOfAccount() {
		try (Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "select * from account_table";
					Statement statement = conn.createStatement();
					
					ResultSet result = statement.executeQuery(sql);
					
					List<Account> accList = new ArrayList<Account>();
					
					while(result.next())
					{
						Account e = new Account (
								result.getInt("acc_id"),
								result.getDouble("acc_balance"),
								result.getInt("customer_id")

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

}
