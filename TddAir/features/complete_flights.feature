Feature: Flight tracking/points accumulation
	As a member
	I want completed flights tracked
	So that I can get to the next status and get more rewards
	
	Background:
		Given no members exist
	
	Scenario: Member reaches the green status
		Given existing members
		      | userName | emailAddress     | status | rewardBalance | ytdBalance |
		      | test1    | test1@tddair.com | Red    | 24999         | 24999      |
		 When "test1" completes flight "AA242"
		  And the status for "test1" is "Green"
		  And the reward balance for "test1" is 25923 miles
		  And the YTD balance for "test1" is 25923 miles

	Scenario: Member maintains the green status
		Given existing members
		      | userName | emailAddress     | status | rewardBalance | ytdBalance |
		      | test1    | test1@tddair.com | Green  | 10000         | 30000      |
		 When "test1" completes flight "AA242"
		 Then the status for "test1" is "Green"
		  And the reward balance for "test1" is 10924 miles
		  And the YTD balance for "test1" is 30924 miles

	Scenario: Member reaches the blue status
		Given existing members
		      | userName | emailAddress     | status | rewardBalance | ytdBalance |
		      | test1    | test1@tddair.com | Green  | 11000         | 49999      |
		 When "test1" completes flight "AA242"
		 Then the status for "test1" is "Blue"
		  And the reward balance for "test1" is 11924 miles
		  And the YTD balance for "test1" is 50923 miles

	Scenario: Member reaches the golden status
		Given existing members
		      | userName       | emailAddress     | status | rewardBalance | ytdBalance |
		      | backwardsFlyer | test1@tddair.com | Blue   | 11000         | 60000      |
		 When "backwardsFlyer" completes flight "WN666"
		 Then the status for "backwardsFlyer" is "Golden"
		  And the reward balance for "backwardsFlyer" is 35891 miles
		  And the YTD balance for "backwardsFlyer" is 84891 miles
