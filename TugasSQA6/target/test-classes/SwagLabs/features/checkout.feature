Feature: Add item to the cart

  @Regression @Positive @Checkout
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
    Then Click checkout button
    When Input <firstname> as firstname
    And Input <lastname> as lastname
    And Input <postal> as postal
    And Click continue button
    Then User on checkout overview page
    When Click finish button
    Then User on checkout complete page
    Examples:
      | username      | password     | firstname | lastname | postal |
      | standard_user | secret_sauce | standard  | user     | 20123      |