Feature: login saucedemo test

  Scenario Outline: testing the successful login saucedemo
    Given the user is on the saucedemo page
    When attempts to log in
      | user   | pass   |
      | <username> | <password> |
    Then validate the text on screen <title>
    Examples:
      | username  | password | title |
      | standard_user | secret_sauce | Swag Labs |