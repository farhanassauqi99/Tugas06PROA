Feature: Reset App State

  @Regression @Positive @Reset
  Scenario Outline: User add item to the cart
    Given Login Page
    When Input <username> as username
    And Input <password> as password
    And Click login button
    Then User on dashboard page
    When User add item
    Then Cart badge change
    When User click burger menu icon
    And User click reset app state
    Then Cart badge reset
    Examples:
      | username                 | password     |
      | standard_user            | secret_sauce |