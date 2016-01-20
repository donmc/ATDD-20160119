Feature: Registration
	As a frequent flyer
	I want to register as a Frequent-Flyer Member
	So that I can start collecting miles to get rewards
	
	Background:
		Given no members exist
	
	Scenario: Everything is simple
		Given a flyer with the username "test1" and the email address "test1@tddair.com"
		 When the flyer sumbits the registration form
		 Then a member record is created in the database
		  And the status for "test1" is "Red"
		  And the reward balance for "test1" is 10000 miles
		  And the YTD balance for "test1" is 0 miles
	
	Scenario: Shared emails
		Given existing members
		      | userName | emailAddress     | status | rewardBalance | ytdBalance |
		      | test1    | test1@tddair.com | Golden | 100000        | 100000     |
		  And a flyer with the username "test2" and the email address "test1@tddair.com"
		 When the flyer sumbits the registration form
		 Then a member record is created in the database
		  And the status for "test2" is "Red"
		  And the reward balance for "test2" is 10000 miles
		  And the YTD balance for "test2" is 0 miles

	Scenario: Existing user name
		Given existing members
		      | userName | emailAddress     | status | rewardBalance | ytdBalance |
		      | test1    | test1@tddair.com | Golden | 100000        | 100000     |
		  And a flyer with the username "test1" and the email address "test1a@tddair.com"
		 When the flyer sumbits the registration form
		 Then a "duplicate user name" error message is displayed
		  And a reset password link is displayed