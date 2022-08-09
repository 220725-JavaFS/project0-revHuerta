package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Market;
import com.revature.utils.ConnectionUtil;

public class MarketDAOImpl implements MarketDAO {


	@Override
	public List<Market> getAllMarkets() {
		try(Connection connect = ConnectionUtil.getConnection()){

			String sql = "SELECT * FROM market;";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);

			List<Market> marketList = new LinkedList<Market>();
			//market_name,seeds,stock,price
			while(result.next()) {
				Market market = new Market(
						result.getString("market_name"),
						result.getString("seeds"),
						result.getInt("stock"),
						result.getDouble("price")
						);

				marketList.add(market);
			}

			return marketList;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateStock(String seedName, int stockDecreased) {
		try(Connection connect = ConnectionUtil.getConnection()){
			String sql = "UPDATE market SET stock = " + "'" + stockDecreased + "'" + "WHERE seeds =" + "'" + seedName + "'" + ";"; 
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Market getItemByName(String item) {
		try(Connection connect = ConnectionUtil.getConnection()){

			String sql = "SELECT * FROM market WHERE seeds = " +"'" + item + "'" + ";";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);

			if(result.next()) {
				Market market = new Market(
						result.getString("market_name"),
						result.getString("seeds"),
						result.getInt("stock"),
						result.getDouble("price")
						);

				return market;	
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	
}
