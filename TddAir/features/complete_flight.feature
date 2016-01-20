Feature: Complete Flight

As a flyer
I want my status to be updated when I complete a flight
So that I can enjoy my rewards

Scenario:
Given a Flyer with username "username" and email "user@name.com" has booked a flight with status "Red" and ytdMiles 24999
When the flyer completes flight "QF191"
Then Flyer with username "username" has "Green" status

Scenario:
Given a Flyer with username "username1" and email "user@name.com" has booked a flight with status "Green" and ytdMiles 25000
When the flyer completes flight "QF191"
Then Flyer with username "username1" has "Green" status

Scenario:
Given a Flyer with username "username2" and email "user@name.com" has booked a flight with status "Green" and ytdMiles 49999
When the flyer completes flight "QF191"
Then Flyer with username "username2" has "Blue" status

Scenario:
Given a Flyer with username "username3" and email "user@name.com" has booked a flight with status "Blue" and ytdMiles 74999
When the flyer completes flight "QF191"
Then Flyer with username "username3" has "Gold" status
