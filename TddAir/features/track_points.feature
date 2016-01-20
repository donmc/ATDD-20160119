Feature: Track Points
As a member I want flights tracked so that I can get to the next status and get more rewards:

Scenario: 
	When a member arrives at their destination
	Then the system gives them credit for the mileage traveled.
	
Scenario: 
	Given a member arrives at their destination and is in red status
	When a member hits or exceeds 25k miles
	Then their category is increased to the green status
	
Scenario: 
	Given a member arrives at their destination and is in green status
	When a member hits or exceeds 50k miles
	Then their category is increased to the blue status
	