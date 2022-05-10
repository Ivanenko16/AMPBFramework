Feature: As a user I want to see the book with the correct prices on the payment page

  @smoke
  Scenario Outline: The book appears on the payment page with the correct prices
    Given the user opens BookDepositoryHomePage page
    When the user searches for "<book>" book
    When the user get the price of the first book
    When the user adds the first book to the basket
    When the user navigates to the basket page
    When the user navigates to the payment page
    Then the order contains corresponding prices
    Examples:
      | book         |
      | Harry Potter |
      | Time Machine |
