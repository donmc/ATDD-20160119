Feature: Complete Flight
As a frequent flyer
I want completed flight mileage recorded
So that I can accumulate miles and increase status

Scenario: Red to Green

Given member is "Red" status with 0 ytdMiles and 0 miles balance
When the member completes a flight of 25000 miles
Then member status should be "Green"
And member should have 25000 ytdMiles
And member should have 25000 miles balance

Scenario: Green to Green

Given member is "Green" status with 25000 ytdMiles and 25000 miles balance
When the member completes a flight of 100 miles
Then member status should be "Green"
And member should have 25100 ytdMiles
And member should have 25100 miles balance

Scenario: Green to Blue

Given member is "Green" status with 25000 ytdMiles and 25000 miles balance
When the member completes a flight of 25000 miles
Then member status should be "Blue"
And member should have 50000 ytdMiles
And member should have 50000 miles balance

Scenario: Blue to Golden

Given member is "Blue" status with 50000 ytdMiles and 50000 miles balance
When the member completes a flight of 25000 miles
Then member status should be "Golden"
And member should have 75000 ytdMiles
And member should have 75000 miles balance