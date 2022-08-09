package com.revature.daos;

import java.sql.Connection;
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
						result.getInt("owner_user"),
						result.getDouble("farmer_one")
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
		// TODO Auto-generated method stub
		
	}
	
	
}
