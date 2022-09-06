Feature: As a user I want filter bestseller book by price

  Scenario Outline: The bestsellers are corresponding filtered after selecting price
    Given the user opens BookDepositoryBestsellers page
    When the user select "<price>" price
    And the user click on the refine results button
    Then the books are filtered by "<price>"
    Examples:
      | price      |
      | Under €15  |
      | €15 to €30 |
      | €30 +      |