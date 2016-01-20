package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final int RED_STATUS = 1;
	public static final int GREEN_STATUS = 2;
	public static final int BLUE_STATUS = 3;
	public static final int GOLDEN_STATUS = 4;
	
	public static final Map<Integer, String> STATUS_MAP = new HashMap<Integer,String>() {{
        put(RED_STATUS, "Red");
        put(GREEN_STATUS, "Green");
        put(BLUE_STATUS, "Blue");
        put(GOLDEN_STATUS, "Golden");
    }};

	

	
}
