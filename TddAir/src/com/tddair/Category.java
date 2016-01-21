package com.tddair;

public enum Category {
	Red(25000, 10000, 100),
	Green(50000, 9000, 90),
	Blue(75000, 8000, 75),
	Golden(0, 7000, 60);
	
	private int maxMilesForCategory;
	private int upgradeMilesCost;
	private int upgradeDollarsCost;
	
	private Category(int maxMilesForCategory, int upgradePurchasePrice, int upgradeDollarsCost)
	{
		this.maxMilesForCategory = maxMilesForCategory;
		this.upgradeMilesCost = upgradePurchasePrice;
		this.upgradeDollarsCost=upgradeDollarsCost;
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

	public int getUpgradeMilesCost() 
	{
		// TODO Auto-generated method stub
		return upgradeMilesCost;
	}

	public int getUpgradeDollarsCost() {
		return upgradeDollarsCost;
	}

}
