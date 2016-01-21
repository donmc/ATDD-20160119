Feature: Complete Flight
  As a frequent flyer
  I want completed flight mileage recorded
  So that I can accumulate miles and increase status

  Scenario Outline: Blue to Golden
    Given member is <Start Status> status with <Start YtdMiles> ytdMiles and <Start Miles> miles balance
    When the member completes a flight of <Flying Miles> miles
    Then member status should be <End Status>
    And member should have <End YtdMiles> ytdMiles
    And member should have <End Miles> miles balance

    Examples: 
      | Start Status | Start YtdMiles | Start Miles | Flying Miles | End Status | End YtdMiles | End Miles |
      | "Red"        | 0              | 0           | 25000        | "Green"    | 25000        | 25000     |
      | "Green"      | 25000          | 25000       | 100          | "Green"    | 25100        | 25100     |
      | "Green"      | 25000          | 25000       | 25000        | "Blue"     | 50000        | 50000     |
      | "Blue"       | 50000          | 50000       | 25000        | "Golden"   | 75000        | 75000     |
