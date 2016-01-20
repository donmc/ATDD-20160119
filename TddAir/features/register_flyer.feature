Feature: Enroll Flyer
As a frequent flyer
I want to register for an account
so that I can begin collection miles for rewards

Scenario: Happy Path - customer not already a flyer
When a customer registers and chooses username "username" and provides email address "user@name.com"
Then the customer is added as a Flyer
And Flyer has "Red" status
And Flyer has 0 ytdMiles
And Flyer has 10000 mile balance
And no error is returned

@Errors
Scenario: Duplicate username selected
Given a customer registers and chooses username "username" and provides email address "user@name.com"
When a customer registers and chooses username "username" and provides email address "other@name.com"
Then error "Duplicate Username!" is returned
