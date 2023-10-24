Feature: Login to the application

  @Regression @Positive @Login
  Scenario Outline: User Login using registered username and password
    Given Login Page
    When Input <username> as username
    And Input <password> as password
    And Click login button
    Then I verify <status> login result
    Examples:
      | username                 | password     | status  |
      | standard_user            | secret_sauce | success |
      | locked_out_user          | secret_sauce | locked  |
      | problem_user             | secret_sauce | success |
      | performance_glitch_user  | secret_sauce | success |
      | error_user               | secret_sauce | success |
      | visual_user              | secret_sauce | success |

  @Regression @NegativeLogin
  Scenario Outline: User Login using registered username and invalid password
    Given Login Page
    When Input <username> as username
    And Input <password> as password
    And Click login button
    Then User get error message
    Examples:
      | username                 | password     |
      | standard_user            | 12345        |
      | locked_out_user          | asd123       |