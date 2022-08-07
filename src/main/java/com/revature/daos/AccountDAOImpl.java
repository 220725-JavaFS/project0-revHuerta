package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Account;
import com.revature.services.AccountService;
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

	@Override
	public Account getAccountByUser(String user) {
		
		try(Connection connect = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM account WHERE user_name ="+ "'" + user + "'" + ";";

			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Account account = new Account(
							result.getString("account_name"),
							result.getString("account_last_name"),
							result.getString("user_email"),
							result.getString("user_name"),
							result.getInt("user_level"),
							result.getDouble("user_currency"),
							result.getBoolean("is_banned"),
							result.getBoolean("is_Owner"),
							result.getBoolean("is_Admin")
						);
				return account;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Account> getAllUsers() {
		try(Connection connect = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM account;";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> accountList = new LinkedList<Account>();
			
			while(result.next()) {
				Account account = new Account(
						result.getString("account_name"),
						result.getString("account_last_name"),
						result.getString("user_email"),
						result.getString("user_name"),
						result.getInt("user_level"),
						result.getDouble("user_currency"),
						result.getBoolean("is_banned"),
						result.getBoolean("is_Owner"),
						result.getBoolean("is_Admin")
					);
				
				accountList.add(account);
			}
			
			return accountList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean getIsUserRegistered(String user, String pwd) {
			
		try(Connection connect = ConnectionUtil.getConnection()){
			
			
			String sql = "SELECT * FROM passwords WHERE user_name = " + "'" + user + "'" + " AND " + "user_pwd" +" = "+ "'" + pwd + "'" + ";";

			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		AccountService gas = new AccountService();
		
		Account a = gas.User("admin");
		System.out.println(a.getUserEmail());
		
		List<Account> list = gas.AllUsers();
		System.out.println(list);
		
		boolean b = gas.isUserRegistered("t1", "321");
		System.out.println(b);
		
	}

}
