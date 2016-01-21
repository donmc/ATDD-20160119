Feature: Register Flyer 
As a frequent flyer 
I want to register for an account 
so that I can begin collecting miles for rewards 

Scenario: Happy Path 

When a flyer with username "user1234" and email "user1234@yahoo.com" register

Then system has user with username "user1234"
And member "user1234" has "RED" status 
And member "user1234" has 0 ytdMiles 
And member "user1234" has 10000 miles balance 

Scenario: Duplicate User Name  

Given a flyer with username "user1234" and email "user1234@yahoo.com" register
When a flyer with username "user1234" and email "user1234@gmail.com" register
Then error "Duplicate user name !!" is returned 

Scenario: Duplicate Email Name  

Given a flyer with username "user1234" and email "user1234@yahoo.com" register
When a flyer with username "user12345" and email "user1234@yahoo.com" register
Then system has user with username "user12345"

Scenario: Invalid Email format  

When a flyer with username "user12345" and email "user1234@invalid" register
Then display error "Invalid Email format !!" 

Scenario: Invalid Email format  

When a flyer with username "" and email "user1234@yahoo.com" register
Then display error "User Name can not be null or Empty!!" 