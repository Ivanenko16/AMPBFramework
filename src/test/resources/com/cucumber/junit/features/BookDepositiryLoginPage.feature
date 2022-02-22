Feature: As a user I want to see clear button in text field

  @smoke
  Scenario: Clear button is appeared
    Given the user opens BookDepositoryLogin page
    When the user fills email field
    Then clear button is appeared on email field