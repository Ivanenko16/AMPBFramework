@api1
Feature: As a user I want to add the product to the cart via API

  Scenario: The corresponding product appears on the cart
    Given the user create cart via API
    When the user adds product for guid path param to cart via API
    Then the user verifies that cart response has expected schema
    Then the user verifies that cart response has expected quantity
    Then the user verifies that cart response has expected product code


