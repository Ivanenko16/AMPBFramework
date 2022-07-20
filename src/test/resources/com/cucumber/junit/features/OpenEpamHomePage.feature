@parallel
Feature: Open Epam Home page for parallel test

  Scenario: User opens Epam Home page
    Given I configured WebDriver
    When I open the 'https://www.epam.com/' page
    Then I verify header is 'EPAM | Enterprise Software Development, Design & Consulting'
    And I close browser