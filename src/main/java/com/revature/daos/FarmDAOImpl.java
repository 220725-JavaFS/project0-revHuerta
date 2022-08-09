package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Farm;
import com.revature.services.FarmService;
import com.revature.utils.ConnectionUtil;

public class FarmDAOImpl implements FarmDAO{
	
	@Override
	public void storeFarm(Farm user) {
		try(Connection connect = ConnectionUtil.getConnection()){

			String sql = "INSERT INTO farms(farm_name, farm_level, owner_user, farmer_one,"
					+ "farmer_two, farmer_three)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connect.prepareStatement(sql);

			int count = 0;
			statement.setString(++count, user.getFarmName());
			statement.setInt(++count, 0);
			statement.setString(++count, user.getOwnerUser());
			statement.setString(++count, null);
			statement.setString(++count, null);
			statement.setString(++count, null);

			statement.execute();

			count = 0;

			sql = "UPDATE account SET farm_name = ? WHERE user_name = ?;";

			statement = connect.prepareStatement(sql);
			statement.setString(++count, user.getFarmName());
			statement.setString(++count, user.getOwnerUser());

			statement.execute();

			sql = "UPDATE account SET is_owner = true";
			statement = connect.prepareStatement(sql);
			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("Unable to Connect to DB...Please Try Again Latter");
			e.printStackTrace();
		}
		
	}
	@Override
	public Farm getFarmByUserName(String userName) {
		try(Connection connect = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM farms WHERE owner_user ="+ "'" + userName + "'" + "OR farmer_one = "
					+ "'" + userName + "'" + "OR farmer_two = " + "'" + userName + "'"
					+ "OR farmer_three = " + "'" + userName + "'" +";";

			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Farm farm = new Farm(
							result.getString("farm_name"),
							result.getInt("farm_level"),
							result.getString("owner_user"),
							result.getString("farmer_one"),
							result.getString("farmer_two"),
							result.getString("farmer_three")
						);
				return farm;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateFarmName(String farmName, String newFarmName) {
		try(Connection connect = ConnectionUtil.getConnection()){
			String sql = "UPDATE farms SET farm_name = " + "'" + newFarmName + "'" + "WHERE farm_name =" + "'" + farmName + "'" + ";"; 
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.execute();
			
			sql = "UPDATE account SET farm_name = " + "'" + newFarmName + "'" + "WHERE farm_name =" + "'" + farmName + "'" + ";"; 
			statement = connect.prepareStatement(sql);
			statement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateFarmerOne(String farmName, String farmer) {
		try(Connection connect = ConnectionUtil.getConnection()){
			String sql = "UPDATE farms SET farmer_one = " + "'" + farmer + "'" + "WHERE farm_name =" + "'" + farmName + "'" + ";"; 
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.execute();
			
			sql = "UPDATE account SET farm_name = " + "'" + farmName + "'" + "WHERE user_name =" + "'" + farmer + "'" + ";"; 
			statement = connect.prepareStatement(sql);
			statement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void updateFarmerTwo(String farmName, String farmer) {
		try(Connection connect = ConnectionUtil.getConnection()){
			String sql = "UPDATE farms SET farmer_two = " + "'" + farmer + "'" + "WHERE farm_name =" + "'" + farmName + "'" + ";"; 
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.execute();
			
			sql = "UPDATE account SET farm_name = " + "'" + farmName + "'" + "WHERE user_name =" + "'" + farmer + "'" + ";"; 
			statement = connect.prepareStatement(sql);
			statement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void updateFarmerThree(String farmName, String farmer) {
		try(Connection connect = ConnectionUtil.getConnection()){
			String sql = "UPDATE farms SET farmer_three = " + "'" + farmer + "'" + "WHERE farm_name =" + "'" + farmName + "'" + ";";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.execute();
			
			sql = "UPDATE account SET farm_name = " + "'" + farmName + "'" + "WHERE user_name =" + "'" + farmer + "'" + ";"; 
			statement = connect.prepareStatement(sql);
			statement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Farm> getAllFarms() {
		try(Connection connect = ConnectionUtil.getConnection()){

			String sql = "SELECT * FROM farms;";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);

			List<Farm> farmList = new LinkedList<Farm>();

			while(result.next()) {
				Farm farm = new Farm(
						result.getString("farm_name"),
						result.getInt("farm_level"),
						result.getString("owner_user"),
						result.getString("farmer_one"),
						result.getString("farmer_two"),
						result.getString("farmer_three")
						);

				farmList.add(farm);
			}

			return farmList;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		FarmService fs = new FarmService();
//		
//		Farm farm = fs.getSingleFarm("");
//		if(farm != null) {
//		System.out.println(farm.toString());
//		}else {
//			System.out.println("No farms for that user");
//		}
//		
//		List<Farm> a = fs.allFarms();
//		for(Farm b: a) {
//			System.out.println(a);
//		}
//		
//		
//	}

}
