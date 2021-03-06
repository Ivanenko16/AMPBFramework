Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  @run_test
  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the "Initial home page"
    And I search for "Thinking in Java"
    And I am redirected to a "Search page"
    And Search results contain the following products
      | Thinking in Java       |
      | Thinking Java Part I   |
      | Core Java Professional |
    And I apply the following search filters
      | Price range  | 30 € +        |
      | Availability | In Stock (5)  |
      | Language     | English (17)  |
      | Format       | Paperback (5) |
    And Search results contain only the following products
      | Thinking in Java                                                  |
      | Think Java                                                        |
      | Thinking Recursively - A 20th Anniversary Edition with Java (WSE) |
      | Think Data Structures                                             |
    And I click Add to basket button for product with name "Thinking in Java"
    And I select "Basket / Checkout" in basket pop-up
    And I am redirected to a "Basket page"
    And Basket order summary is as following:
      | Delivery cost | Total   |
      | FREE          | 83,23 € |
    And I click Checkout button on Basket page
    And I checkout as a new customer with email "test@user.com"
    And Checkout order summary is as following:
      | Sub-total | Delivery | VAT    | Total   |
      | 83,23 €   | FREE     | 0,00 € | 83,23 € |
    And I fill delivery address information manually:
      | Full name | Delivery country | Address line 1   | Address line 2   | Town/City | County/State | Postcode |
      | John      | United States    | Random address 1 | Random address 2 | Dnipro    | Random State | 087756   |
    Then There is no validation error messages displayed on Delivery Address form
    When I enter my card details
      | cardNumber  | 4111111111111111 |
      | Expiry date | 122022           |
      | Cvv         | 123              |
