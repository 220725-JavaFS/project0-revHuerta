package com.revature.services;

import java.util.List;

import com.revature.daos.MarketDAO;
import com.revature.daos.MarketDAOImpl;
import com.revature.models.Farm;
import com.revature.models.Market;

public class MarketService {
	MarketDAO marketDao = new MarketDAOImpl();
	
	public Market getItem(String item) {
		return marketDao.getItemByName(item);
	}
	public List<Market> allMarkets(){
		return marketDao.getAllMarkets();
	}
	
	public void updateStock(String seedName, int stockDecreased) {
		marketDao.updateStock(seedName, stockDecreased);
	}
}
