Feature: Complete Flights  
As a registered flyer 
I want to get right status after completing each flight  
so that I can get more rewards

Scenario Outline: Updating Mileage
Given a <startStatus> member <userName> with <startYtd> YTD milage with <startBalance> miles balance
When member <userName> completes flight <flightNumber> 
Then member <userName> has <endStatus> status 
And member <userName> has <endYtd> ytdMiles 
And member <userName> has <endBalance> miles balance 

Examples:
|userName  |startStatus|startYtd   |startBalance|flightNumber|endStatus|endYtd|endBalance|
|"user1234"|"RED"      |20000      |30000       |"QF191"     |"GREEN"  |27490 |37490     |
|"user1234"|"GREEN"    |40000      |50000       |"AF38"      |"GREEN"  |43620 |53620     |
|"user1234"|"GREEN"    |48000      |58000       |"AF38"      |"BLUE"   |51620 |61620     |
|"user1234"|"BLUE"     |70000      |80000       |"QF191"     |"GOLDEN" |77490 |87490     |

