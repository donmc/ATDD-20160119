Feature: Register Flyer
As a frequent flyer
I want to register for an account
so that I can begin collecting miles for rewards

Scenario: Happy Path

When a flyer with username "donmc" and email "don@improving.com" registers

Then system has user with username "donmc"
And member has "RED" status
And member has 0 ytd miles
And member has 10000 mile balance

Scenario: Duplicate User Name

Given a flyer with username "bob" and email "bob@improving.com" registers
When a flyer with username "bob" and email "bob@gmail.com" registers
Then "Duplicate username" is returned
