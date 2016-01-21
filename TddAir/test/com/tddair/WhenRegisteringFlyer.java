package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private Member member;
	private Member member2;
	private static boolean setUpIsDone = false;
	
	@Before
	public void setup()
	{
		TddAirApplication app = new TddAirApplication();
		//setup 
		String userName = "user123";
		String email = "user1234@yahoo.com";
		String userName2 = "user12345";
		String email2 = "user1234@yahoo.com";
		
		if( !setUpIsDone)
		{
			try {
				app.registerAsMember(userName, email);
				app.registerAsMember(userName2, email2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			setUpIsDone = true;
		}
		
		member = app.lookupMember(userName);
		member2 = app.lookupMember(userName2);
	}
	
	@Test
	public void shouldSaveAsMember() { 
		
		assertNotNull(member);
		assertEquals("user123", member.getUserName());  
	}
	
	@Test
	public void shouldSaveAsMember_ForSecondMember() { 
		
		assertNotNull(member);
		assertEquals("user12345", member2.getUserName());  
	}
	
	@Test
	public void shouldHaveRedStatus() { 
		
		assertEquals("RED", member.getStatus().toString()); 
	}
	
	@Test
	public void shouldHaveRedStatus_ForSecondMember() { 
		
		assertEquals("RED", member2.getStatus().toString()); 
	}
	
	@Test
	public void shouldHave10000MilesForBalance() { 
		
		assertEquals(10000, member.getBalanceMiles()); 
	}
	
	@Test
	public void shouldHave10000MilesForBalance_ForSecondMember() { 
		
		assertEquals(10000, member2.getBalanceMiles()); 
	}
	
	@Test
	public void shouldHave0YtdMiles() { 
		
		assertEquals(0, member.getYtdMiles()); 
	}
	
	@Test
	public void shouldHave0YtdMiles_ForSecondMember() { 
		
		assertEquals(0, member2.getYtdMiles()); 
	}
	
	@Test
	public void shouldThrowError_WhenRegisteringWithDuplicateUsername() { 
		TddAirApplication app = new TddAirApplication();
		String username = "user123";
		try {
			app.registerAsMember(username, "user1234@yahoo.com");
			fail("Should throw an exception");
		}catch(Exception e) {
			assertEquals("Duplicate user name !!", e.getMessage());
		}
	}
	
	@Test
	public void shouldReturnErrorWhenRegisteringWithInvalidEmailFormat()
	{
		TddAirApplication app = new TddAirApplication();
		String userName = "user0001";
		String email = "user1234@invalid";
		
		try {
			app.registerAsMember(userName, email);
			fail();
			
		} catch (Exception e) {
			assertEquals("Invalid Email format !!", e.getMessage());
		}
	}
	
	@Test
	public void shouldReturnErrorWhenRegisteringWithEmptyUser()
	{
		TddAirApplication app = new TddAirApplication();
		String userName = "";
		String email = "user1234@yahoo.com";
		
		try {
			app.registerAsMember(userName, email);
			fail();
			
		} catch (Exception e) {
			assertEquals("User Name can not be null or Empty!!", e.getMessage());
		}
	}
	
	@Test
	public void shouldReturnErrorWhenRegisteringWithNullUser()
	{
		TddAirApplication app = new TddAirApplication();
		String userName = null;
		String email = "user1234@yahoo.com";
		
		try {
			app.registerAsMember(userName, email);
			fail();
			
		} catch (Exception e) {
			assertEquals("User Name can not be null or Empty!!", e.getMessage());
		}
	}
}
