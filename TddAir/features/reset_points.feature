Feature: Reset Points
As an airline I want the points/miles reset every year so that I can motivate flyers to fly.

Scenario: 
	When the time passes midnight on January 1st
	Then their year to date balance is reset to 0
	
Scenario: 
	Given a members acheives a new level on the previous year
	When time passes midnight on January 1st
	Then their category remains the same level it was.
	
Scenario: 
	Given a member does not have the amount of miles needed to maintain the category from the previous year
	When the time passes midnight on January 1st
	Then their category is decremented by one category.
