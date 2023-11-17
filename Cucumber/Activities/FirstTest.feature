Feature: Basic Syntax

  @Scenario1
  Scenario: This is the first scenario
    Given the user is on the TS homepage
    When the user clicks on the About Us link
    Then the user is redirected to the About page
    And close the browser