package com.tddair;

import java.util.HashMap;
import java.util.Map;

import com.tddair.exception.InvalidCCException;

public class CAS {
	protected Map<String,String> validCC = new HashMap<String,String>();
	
	public void approve(String ccNum, int amt) {
		if( !validCC.containsKey(ccNum) )
		{
			throw new InvalidCCException();
		}
	}

}
