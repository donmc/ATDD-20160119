Feature: Register Flyer
As a frequent flyer
I want to register for an account
so that I can begin collecting miles for rewards.

Scenario: Happy Path

#Given a frequent flyer
When a flyer with username "martym" and email "martymcfly@future.com" registers
Then system has use with username "martym"
	And member has "RED" status
	And member has 0 ytdMiles
	And member has 10000 mile balance

Scenario: Duplicate User Name
Given a flyer with username "martym" and email "martymcfly@future.com" registers
When a flyer with username "martym" and email "martymcfly@future.com" registers
Then error "Duplicate username!" is returned

