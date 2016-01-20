package com.tddair.features;

import com.tddair.TddAirApplication;

public class TddSingleton {

	private static TddAirApplication app;
	
	private TddSingleton()
	{
		//nothing to do.
	}
	
	public static TddAirApplication getTddAirApp()
	{
		if(null == app)
		{
			app = new TddAirApplication();
		}
		
		return app;
	}
	
}
