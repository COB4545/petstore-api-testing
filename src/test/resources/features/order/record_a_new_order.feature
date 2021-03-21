Feature: Record a new Order

  Scenario: Each trade has a unique ID
    Given the following order:
    | quantity | petId |
    | 3     | 9222968140497517054   |
    When I record the order
    Then the order should have id



