  #Author
  #Date
  # Description
#    @SmokeFeature
Feature: test login funcionallity

#  @smoketest
  Scenario: Check login is sucessful with valid credentials
    Given browser is open on page
    And user is on login page
    When user enters username and password
    And user clicks on login
    Then user is navigated to the home page
