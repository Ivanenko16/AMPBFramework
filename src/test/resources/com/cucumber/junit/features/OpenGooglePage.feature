@parallel
Feature: Open Google page for parallel test

  Scenario: User opens Google Home page
    Given I configured WebDriver
    When I open the 'http://google.com' page
    Then I verify header is 'Google'
    And I close browser