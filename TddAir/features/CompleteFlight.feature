Feature: Complete Flights  
As a registered flyer 
I want to get right status after completing each flight  
so that I can get more rewards

Scenario: Happy Path RED to GREEN
Given a "Red" member "user1234" with 20000 YTD milage
When member completes flight "QF191" 
Then member has "GREEN" status 
And member has 27490 ytdMiles 
And member has 37490 miles balance 

