Feature: Registration
	As a frequent flyer
	I want to register as a Frequent-Flyer Member
	So that I can start collecting miles to get rewards
	
	Scenario: Everything is simple
		Given a flyer with the username "test1"
		  And the flyer has email address "test1@tddair.com"
		 When the flyer sumbits the registration form
		 Then a member record is created in the database
		  And the status for that member is "Red"
		  And the balance for that member is 0 miles
		  And the YTD balance for that member is 0 miles
	
	Scenario: Shared emails
		Given existing members
		      | userName | emailAddress     | status | totalBalance | ytdBalance |
		      | test1    | test1@tddair.com | Golden | 100000       | 100000     |
		  And a flyer with the username "test2"
		  And the flyer has email address "test1@tddair.com"
		  And the flyer's email address already used by another registered member
		 When the flyer sumbits the registration form
		 Then a member record is created in the database
		  And the status for that member is "Red"
		  And the balance for that member is 0 miles
		  And the YTD balance for that member is 0 miles

	Scenario: Existing user name
		Given existing members
		      | userName | emailAddress     | status | totalBalance | ytdBalance |
		      | test1    | test1@tddair.com | Golden | 100000       | 100000     |
		  And a flyer with the username "test1"
		Given the flyer's user name already used by another registered member
		 When the flyer sumbits the registration form
		 Then an error message is displayed
		  And a reset password link is displayed