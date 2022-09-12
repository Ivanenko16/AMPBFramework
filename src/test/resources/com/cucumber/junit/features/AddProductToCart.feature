@api
Feature: As a user I want to add the product to the cart via API

  Scenario: The corresponding product appears on the cart
    Given the user create cart via API
    When the user adds product for guid path param to cart via API
    Then the user verifies that cart response has expected schema
    Then the user verifies that cart response has expected quantity
    Then the user verifies that cart response has expected product code
    Then the user opens the 'Kruidvat' page
    When the user clears all cookies
    When the user adds the required cookies
    When the user refreshes the page
    When the user navigates to the Cart page
    Then the user verifies that Cart contains expected product

