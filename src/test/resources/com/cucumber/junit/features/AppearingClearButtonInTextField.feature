Feature: As a user I want to see clear button in the text field after it is filled

  Scenario Outline: The Clear button appears in the text field after it is filled
    Given the user opens "Login page"
    When the user fills "<field>" field
    Then clear button is appeared on "<field>" field
    Examples:
      | field                  |
      | Email                  |
      | BookDepositoryPassword |
      | Name                   |
      | YourEmailAddress       |
      | CreateAPassword        |
