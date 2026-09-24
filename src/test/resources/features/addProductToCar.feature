Feature: add product to cart test

  Background:
    Given that the user is logged in
      | user   | password   |
      | standard_user | secret_sauce |

  Scenario Outline: Product added to cart successfull
    When select the product "<product>"
    And add the product to the shopping cart
    Then you should see the product '<product>' in the cart
    Examples:
      | product |
      | Sauce Labs Backpack |
