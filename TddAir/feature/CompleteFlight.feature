Feature: Complete Flight

Scenario: Red -> Green

Given a member with 20000 YtdMiles and "RED" status
When member completes an 8000 mile flight
Then member will have "GREEN" status.

Scenario: Green -> Green

Given a member with 30000 YtdMiles and "GREEN" status
When member completes an 8000 mile flight
Then member will have "GREEN" status.

Scenario: Green -> Blue

Given a member with 45000 YtdMiles and "GREEN" status
When member completes an 8000 mile flight
Then member will have "BLUE" status.

Scenario: Blue -> Gold

Given a member with 70000 YtdMiles and "BLUE" status
When member completes an 8000 mile flight
Then member will have "GOLD" status.

Scenario Outline: Increasing Status
Given a <start status> member <user name> with <start ytd> ytd miles
When they complete flight <flight>
Then member <user name> has <end status> status
And member <user name> has <end ytd> ytd miles

Examples:
|user name|start status|start ytd|flight |end status|end ytd|
|"donmc"  |"RED"       |20000    |"QF191"|"Green"   |27490  |
|"bob"    |"GREEN"     |45000    |"QF191"|"Blue"    |52490  |
|"bob2"   |"GREEN"     |40000    |"QF191"|"Green"   |47490  |
