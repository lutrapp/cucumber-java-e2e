  #Author
  #Date
  # Description

  Feature: test login funcionallity

    Scenario Outline: : Check login is sucessful with valid credentials
      Given browser is open on page
      And user is on login page
      When user enters <username> and <password>
      And user clicks on login
      Then user is navigated to the home page
      Examples:
        | username | password |
        | standard_user | secret_sauce |
#        | locked_out_user | secret_sauce | >>>>>> to test error user
        | problem_user | secret_sauce |
        | performance_glitch_user | secret_sauce |
        | error_user | secret_sauce |
        | visual_user | secret_sauce |


  #
##    @SmokeFeature
#Feature: test login funcionallity
#
##  @smoketest
#  Scenario: Check login is sucessful with valid credentials
#    Given browser is open on page
#    And user is on login page
#    When user enters username and password
#    And user clicks on login
#    Then user is navigated to the home page
