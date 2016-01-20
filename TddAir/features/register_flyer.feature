Feature: Register Flyer
As a frequent flyer
I want to register for an account
So that I can begin collecting miles for rewards

Scenario: Happy Path

When a flyer with username "donmc" and email "don@improving.com" registers
Then system has a member with username "donmc"
	And member has "Red" status
	And member has 0 ytdMiles
	And member has 10000 mile balance

Scenario: Duplicate Username

Given a flyer with username "donmc" and email "don@improving.com" registers
When a flyer with username "donmc" and email "don@gmail.com" registers
Then return a failure message of "Username is already registered"