Feature: As a user I want to use the icons in the navigation bar to navigate to the relevant pages

  @smoke
  Scenario Outline: Navigation to the relevant page
    Given the user opens BookDepositoryHomePage page
    When the user click on the "<icon>" icon
    Then the page with "<icon>" url is displayed
    Examples:
      | icon         |
      | Help         |
      | Order Status |
      | Contact us   |
      | Wishlist     |
      | Sign in/Join |