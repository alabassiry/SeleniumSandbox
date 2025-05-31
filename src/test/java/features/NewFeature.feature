Feature: New Feature Under Test
  Scenario: Testing login using valid credentials
    Given User in on the login page
    When User enters valid username and valid password
    And User clicks on the login button
    Then User is directed to the successful login page
