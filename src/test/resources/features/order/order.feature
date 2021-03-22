@test
Feature: Place an order for a pet
          with help of store order API

  Scenario: Order should placed successfully

    Given the following order:
    | quantity | petId |
    | 3     | 9222968140497517054 |
    When  I record the order
    Then status of response is 200
    And the pet order should have id

  Scenario: Order should fail when Incorrect petID received

    Given the following order:
      | quantity | petId |
      | 3     | adddd124 |
    When I record the order
    Then status of response is 500
    And the pet order should  fail

  Scenario Outline: Order details should retrieved successfully
    Given order details for order <orderId>
    Then status of response is 200
    And the order details returned
    Examples:
      | orderId |
      | "1"    |

  Scenario Outline: Order details should not be retrieved successfully
    Given order details for order <orderId>
    Then status of response is 404
    And the order details returned is empty
    Examples:
      | orderId |
      | "2"    |
    

