Feature:

Registering must be:

	unique user name
	email address (not unique)
	
	
	
Given (Optional) -- A precondition:

When (Required) -- an Event: 

Then (Required) -- Result/State is achieved:


As a flyer I want to register as a frequent flyer member so that I can start collecting miles to get rewards:

	Given a unique username and an email
	when the user hits submit 
	then the users username and email are recorded
	
	When the user is registered  
	then the user has an initial balance of zero and is a red member
	
	Given the user provides a duplicated username
	when the user hits submit
	then the system will provide feedback that the username is taken.
	
	
As a member I want flights tracked so that I can get to the next status and get more rewards:

	When a member arrives at their destination
	then the system gives them credit for the mileage traveled.
	
	Given a member arrives at their destination and is in red status
	When a member hits or exceeds 25k miles
	then their category is increased to the green status
	
	Given a member arrives at their destination and is in green status
	When a member hits or exceeds 50k miles
	then their category is increased to the blue status
	
As an airline I want the points/miles reset every year so that I can motivate flyers to fly.

	When the time passes midnight on January 1st
	Then their year to date balance is reset to 0
	
	Given a members acheives a new level on the previous year
	when time passes midnight on January 1st
	then their category remains the same level it was.
	
	Given a member does not have the amount of miles needed to maintain the category from the previous year
	when the time passes midnight on January 1st
	then their category is decremented by one category.
	
	
	