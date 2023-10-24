Feature: Add item to the cart

  @Regression @Positive @Cart
  Scenario Outline: User add item to the cart
    Given Login Page
    When Input <username> as username
    And Input <password> as password
    And Click login button
    Then User on dashboard page
    When User add item
    Then Cart badge change
    When User click cart icon
    And User on cart page
    And Cart has item
    Then Remove item from cart
    Examples:
      | username                 | password     |
      | standard_user            | secret_sauce |