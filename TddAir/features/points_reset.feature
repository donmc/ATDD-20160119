Feature: Points reset at end of year
	As an airline
	I want points/miles to reset every year
	So that I can motivate the member to fly
	
	Scenario: Member keeps zero miles
		Given a member with 0 YTD miles
		 When the new calendar year begins
		 Then the member has 0 YTD miles
	
	Scenario: Member loses YTD miles
		Given a member with more than 0 YTD miles
		 When the new calendar year begins
		 Then the member has 0 YTD miles