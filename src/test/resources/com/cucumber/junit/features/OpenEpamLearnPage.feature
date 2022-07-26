@parallel
Feature:  Open Epam Learn page for parallel test

  Scenario: User opens Epam Learn page
    Given I configured WebDriver
    When I open the 'https://learn.epam.com/start' page
    Then I verify header is 'Learn'
    And I close browser