package com.revature.models;

public class Market {
	private String marketName;
	private String seeds;
	private int stock;
	private double price;
	
	public Market() {
		super();
	}
	
	public Market(String marketName, String seeds, int stock, double price) {
		super();
		this.marketName = marketName;
		this.seeds = seeds;
		this.stock = stock;
		this.price = price;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getSeeds() {
		return seeds;
	}

	public void setSeeds(String seeds) {
		this.seeds = seeds;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Market [seeds=" + seeds + ", stock=" + stock + ", price=" + price + "]";
	}
	
	
}
