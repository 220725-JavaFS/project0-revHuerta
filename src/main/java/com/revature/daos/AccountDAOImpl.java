package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void storeAccount(Account user) {
		
		try(Connection connect = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO account(account_name, account_last_name, user_email, user_name,"
					+ "user_level, user_currency, is_banned, is_Owner,is_Admin)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connect.prepareStatement(sql);
			
			int count = 0;
			statement.setString(++count, user.getName());
			statement.setString(++count, user.getLastName());
			statement.setString(++count, user.getUserEmail());
			statement.setString(++count, user.getUserName());
			
			statement.setInt(++count, 0); //user_level
			statement.setDouble(++count, 1000); //user_currency
			statement.setBoolean(++count, false); //is_banned
			statement.setBoolean(++count, false); //is_Owner
			statement.setBoolean(++count, false); //is_Admin
			
			statement.execute();
			
			count = 0;
			
			sql = "INSERT INTO passwords(user_name, user_pwd)"
					+ " VALUES (?, ?)";
			
			statement = connect.prepareStatement(sql);
			
			statement.setString(++count, user.getUserName());
			statement.setString(++count, user.getUserPwd());
			
			statement.execute();
	
			
		}catch(SQLException e) {
			System.out.println("Unable to Connect to DB...Please Try Again Latter");
			e.printStackTrace();
		}
		
	}

}
