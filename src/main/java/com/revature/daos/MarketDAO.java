package com.revature.daos;

import java.util.List;

import com.revature.models.Market;

public interface MarketDAO {

	List<Market> getAllMarkets();

	void updateStock(String seedName, int stockDecreased);

	Market getItemByName(String item);

}
