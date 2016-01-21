package com.tddair;

public enum Category {
	Red(25000, 10000),
	Green(50000, 9000),
	Blue(75000, 8000),
	Golden(0, 7000);
	
	private int maxMilesForCategory;
	private int upgradePurchasePrice;
	
	private Category(int maxMilesForCategory, int upgradePurchasePrice)
	{
		this.maxMilesForCategory = maxMilesForCategory;
		this.upgradePurchasePrice = upgradePurchasePrice;
	}
	
	public int getMaxMilesForCategory()
	{
		return this.maxMilesForCategory;
	}
	
	public Category getCategoryForMiles(int ytdMiles)
	{
		if(ytdMiles > this.getMaxMilesForCategory())
		{
			if(this.equals(Red))
				return Green;
			else if(this.equals(Green))
				return Blue;
			else
				return Golden;
		}
		else
			return this;
	}

	public int getUpgradePurchasePrice() 
	{
		// TODO Auto-generated method stub
		return upgradePurchasePrice;
	}
}
