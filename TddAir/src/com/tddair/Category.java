package com.tddair;

import java.util.HashMap;
import java.util.Map;

public enum Category {
	Red(25000),
	Green(50000),
	Blue(75000),
	Golden(0);
	
	private int maxMilesForCategory;
	
	private Category(int maxMilesForCategory)
	{
		this.maxMilesForCategory = maxMilesForCategory;
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
}
