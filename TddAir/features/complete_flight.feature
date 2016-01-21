Feature: Track Points
As a member I want flights tracked so that I can get to the next status and get more rewards:

Scenario Outline: 
	Given a member with username <userName>
	And member is currently a <startStatus> status
	And currentYtdMileage is <currentYtdMileage>
	When a member completes flight <completeFlight>
	Then their member status is <newStatus>

Examples:
|userName|startStatus|currentYtdMileage|completeFlight|newStatus|
#Status promotions#
|"Bob"   |"Red"      |24999            |"AA242"		  |"Green"	|
|"Bob"   |"Green"    |49999            |"AA242"		  |"Blue"	|
|"Bob"   |"Blue"     |74999            |"AA242"		  |"Golden"	|

#Status remains year over year#
|"Bob"   |"Golden"   |0                |"AA242"		  |"Golden"	|
|"Bob"   |"Blue"     |0                |"AA242"		  |"Blue"	|
|"Bob"   |"Green"    |0                |"AA242"		  |"Green"	|
|"Bob"   |"Red"      |0                |"AA242"		  |"Red"	|

#Status doesn't change, hasn't met the next level criteria
|"Bob"   |"Golden"   |85000            |"AA242"		  |"Golden"	|
|"Bob"   |"Blue"     |55000            |"AA242"		  |"Blue"	|
|"Bob"   |"Green"    |26000            |"AA242"		  |"Green"	|
|"Bob"   |"Red"      |10000            |"AA242"		  |"Red"	|
