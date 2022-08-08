package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Farm;
import com.revature.services.FarmService;
import com.revature.utils.ConnectionUtil;

public class FarmDAOImpl implements FarmDAO{

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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
//	}

}
