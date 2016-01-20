Feature: Enroll Flyer
As a frequent flyer
I want to register for an account
so that I can begin collection miles for rewards

Scenario: Happy Path - customer not already a flyer
When a customer registers and chooses username "username" and provides email address "user@name.com"
Then the customer with username "username" is added as a Flyer
And Flyer with username "username" has "Red" status
And Flyer with username "username" has 0 ytdMiles
And Flyer with username "username" has 10000 mile balance
And no error is returned

@Errors
Scenario: Duplicate username selected
Given a customer registers and chooses username "username" and provides email address "user@name.com"
When a customer registers and chooses username "username" and provides email address "other@name.com"
Then error "Duplicate Username!" is returned
