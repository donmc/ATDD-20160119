Feature: Points tracking
	As a member
	I want flights tracked
	So that I can get to the next status and get more rewards
	
	Scenario: Member reaches the green status
		Given the member has an account
		  And the members status is lower than green
		 When the member has passed the 25,000 YTD mile mark
		 Then the members status changes to green
	
	Scenario: Member reaches the blue status
		Given the member has an account
		  And the members status is lower than blue
		 When the member has passed the 50,000 YTD mile mark
		 Then the members status changes to blue
	
	Scenario: Member completes a flight without changing status
		Given the member has an account
		 When the member accumulates more miles but does not pass any milestone
		 Then the members status remains the same
		  