Feature: Registration
	As a flyer
	I want to register as a Frequent-Flyer Member
	So that I can start collecting miles to get rewards
	
	Scenario: Everything is simple
		Given the flyer is using an available user name
		  And the flyer is using valid email address
		 When the flyer sumbits the registration form
		 Then a member record is created in the database
		  And the status for that member is Red
		  And the balance for that member is 0 miles
		  And the YTD balance for that member is 0 miles
		  And a success confirmation screen is displayed to the member
		  And a welcome email is sent to the new member
	
	Scenario: Shared emails
		Given the flyer is using an available user name
		  And the flyer is using an email address already used by another registered member
		 When the flyer sumbits the registration form
		 Then a member record is created in the database
		  And the status for that member is Red
		  And the balance for that member is 0 miles
		  And the YTD balance for that member is 0 miles
		  And a success confirmation screen is displayed to the member
		  And a welcome email is sent to the new member

	Scenario: Existing user name
		Given the flyer is using a user name already used by another registered member
		 When the flyer sumbits the registration form
		 Then an error message is displayed
		  And a reset password link is displayed