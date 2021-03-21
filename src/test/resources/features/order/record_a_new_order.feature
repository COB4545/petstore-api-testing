Feature: Record a new Order

  Scenario: Each trade has a unique ID
    Given the following order:
    | quantity | petId |
    | 3     | 9222968140497517054   |
    When I record the order
    Then status of response is 200
    And the order should have id




