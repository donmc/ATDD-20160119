package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final int RED_STATUS = 1;
	public static final Map<Integer, String> STATUS_MAP = new HashMap<Integer,String>() {{
        put(RED_STATUS, "Red");
    }};

	
}
