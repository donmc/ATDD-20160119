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
