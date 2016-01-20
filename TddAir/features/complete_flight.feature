Feature: Track Points
As a member I want flights tracked so that I can get to the next status and get more rewards:

Scenario: 
	Given a member with username "Bob" 
	And member is currently a "Red" status
	And currentYtdMileage is 10000
	When a member completes flight "AA242"
	Then their member status is "Red"
	
Scenario: 
	Given a member with username "Bob" 
	And member is currently a "Green" status
	And currentYtdMileage is 26000
	When a member completes flight "AA242"
	Then their member status is "Green"
	
Scenario: 
	Given a member with username "Bob" 
	And member is currently a "Blue" status
	And currentYtdMileage is 55000
	When a member completes flight "AA242"
	Then their member status is "Blue"
	
Scenario: 
	Given a member with username "Bob" 
	And member is currently a "Golden" status
	When a member completes flight "AA242"
	Then their member status is "Golden"
	
Scenario: 
	Given a member with username "Bob"
	And member is currently a "Red" status
	And currentYtdMileage is 24999
	When a member completes flight "AA242"
	Then their member status is "Green"

Scenario: 
	Given a member with username "Bob" 
	And member is currently a "Green" status
	And currentYtdMileage is 49999
	When a member completes flight "AA242"
	Then their member status is "Blue"
	
Scenario: 
	Given a member with username "Bob" 
	And member is currently a "Blue" status
	And currentYtdMileage is 74999
	When a member completes flight "AA242"
	Then their member status is "Golden"