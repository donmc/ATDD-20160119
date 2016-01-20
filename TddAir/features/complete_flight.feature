Feature: Complete Flight
As a member
I want completed flight mileage recorded
so that I can accumulate miles and increase status

Scenario: Red to Green
Given a "Red" member "donmc" with 24500 ytdmiles
When member completes flight "AA242" 
 #924 miles

Then member has "Green" status
And member has 25424 ytdmiles 


Scenario: Green to Green
Given a "Green" member "donmc" with 25500 ytdmiles
When member completes flight "AF38" 
 #3620 miles

Then member has "Green" status
And member has 29120 ytdmiles 

Scenario: Green to Blue
Given a "Green" member "donmc" with 42511 ytdmiles
When member completes flight "QF191" 
 #7490 miles

Then member has "Blue" status
And member has 50001 ytdmiles 

Scenario: Blue to Golden
Given a "Blue" member "donmc" with 74100 ytdmiles
When member completes flight "AF38" 
 #3620 miles

Then member has "Golden" status
And member has 77720 ytdmiles 

Scenario: Flight not found
Given a "Blue" member "donmc" with 74100 ytdmiles
When member completes flight "AF404" 
 #Not real flight

Then error "No flight found" is returned