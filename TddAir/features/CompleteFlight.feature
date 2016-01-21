Feature: Complete Flights  
As a registered flyer 
I want to get right status after completing each flight  
so that I can get more rewards

Scenario: Happy Path RED to GREEN
Given a "RED" member "user1234" with 20000 YTD milage with 30000 miles balance
When member "user1234" completes flight "QF191" 
Then member "user1234" has "GREEN" status 
And member "user1234" has 27490 ytdMiles 
And member "user1234" has 37490 miles balance 

Scenario: Happy Path GREEN to GREEN
Given a "GREEN" member "user1234" with 40000 YTD milage with 50000 miles balance
When member "user1234" completes flight "AF38" 
Then member "user1234" has "GREEN" status 
And member "user1234" has 43620 ytdMiles 
And member "user1234" has 53620 miles balance 

Scenario: Happy Path GREEN to BLUE
Given a "GREEN" member "user1234" with 48000 YTD milage with 58000 miles balance
When member "user1234" completes flight "AF38" 
Then member "user1234" has "BLUE" status 
And member "user1234" has 51620 ytdMiles 
And member "user1234" has 61620 miles balance 

Scenario: Happy Path BLUE to GOLD
Given a "BLUE" member "user1234" with 70000 YTD milage with 80000 miles balance
When member "user1234" completes flight "QF191" 
Then member "user1234" has "GOLDEN" status 
And member "user1234" has 77490 ytdMiles 
And member "user1234" has 87490 miles balance 

