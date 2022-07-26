
Feature: Create new account

  Scenario: Create new account
    Given the user opens BookDepositoryHomePage page
    When the user navigate to the LoginPage page
    When the user fills join fields
      | Katya | as.bulk@mail.com | 09qwerty87654321 |
    When the user click on the CreateYourAccount button
    Then the Homepage is opened with corresponding welcome message