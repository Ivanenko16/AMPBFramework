Feature: As a user I want to add the product to the cart

  @api
  Scenario: The product appears on the cart
    Given the user opens the 'Kruidvat' page
    When the user clears all cookies
    When the user adds the required cookies
    When the user refreshes the page
    When the user navigates to the Cart page
    When the user verifies that Cart contains expected product