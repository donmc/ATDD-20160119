Feature: Register Flyer
As a flyer I want to register as a frequent flyer member so that I can start collecting miles to get rewards:

Scenario: Happy path
	When a flyer with username "bob" and email "bob@bob.com" registers
	Then system has user with username "bob"
	 And member has "Red" status
	 And member has 0 ytdMiles
	 And member has 10000 mile balance
	
Scenario: Duplicate user name
	Given a flyer with username "bob" and email "bob@test.com" registers
	 When a flyer with username "bob" and email "bob@bob.com" registers
	 Then error "Duplicate user name" is returned
	 