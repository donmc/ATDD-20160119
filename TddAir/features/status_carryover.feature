Feature: Points reset at end of year
	As an airline
	I want points/miles to reset every year
	So that I can motivate the member to fly
	
	Scenario: Member drops down from blue
		Given a member with Golden status
		  And the member has 10,000 YTD miles
		 When the new calendar year begins
		 Then the member has a new status of Blue