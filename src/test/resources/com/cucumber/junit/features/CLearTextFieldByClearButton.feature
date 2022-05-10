Feature: As a user I want clear text field by clicking  the corresponding clear button

  @smoke
  Scenario Outline: The clear button clears the text field after clicking on it
    Given the user opens BookDepositoryLogin page
    When the user fills "<field>" field
    And the user click on the clear button in the "<field>" field
    Then the "<field>" field is empty
    Examples:
      | field                  |
      | Email                  |
      | BookDepositoryPassword |
      | Name                   |
      | YourEmailAddress       |
      | CreateAPassword        |

