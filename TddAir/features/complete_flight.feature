Feature: Complete Flight

Scenario: Red to Green

Given a member "martymc" and "RED" status and 18000 YTD miles  
When member "martymc" completes flight "QF191"
Then member has status equal to "GREEN"


Scenario: Green to Green

Given a member "martymc" and "GREEN" status and 25000 YTD miles
When member "martymc" completes flight "QF191"
Then member has status equal to "GREEN"


Scenario: Green to Blue

Given a member "martymc" and "GREEN" status and 48000 YTD miles
When member "martymc" completes flight "QF191"
Then member has status equal to "BLUE"


Scenario: Blue to Gold

Given a member "martymc" and "GREEN" status and 68000 YTD miles
When member "martymc" completes flight "QF191"
Then member has status equal to "Gold"

