package com.tddair.features;

import com.tddair.TddAirApplication;

public class TddAirSingleton {

	private static TddAirApplication app = null;
	
	public static TddAirApplication getInstance() {
		if (app == null) {
			app = new TddAirApplication();
		}
		return app;
	}
}
