@test
Feature: Functional verification of petstore ORDER REST APIs

  Scenario: Place a purchase order for a pet
    Given the following order:
    | quantity | petId | id |
    | 2     | 123      | 3  |
    When  I record the order
    Then status of response is 200
    And the response content is json
    And the pet order should have id


  Scenario: Reject the purchase order for pet
    Given the following order:
      | quantity | petId |
      | 2     | 1ada21 |
    When I record the order
    Then status of response is 500
    And the response content is json
    And the pet order should  fail

  Scenario Outline: Find the purchase order details by orderid
    Given order details for order <orderId>
    Then status of response is 200
    And the response content is json
    And the order details returned
    And the order details should have orderid
    Examples:
      | orderId |
      | "3"    |

  Scenario Outline: Unable to find purchase order details
    Given order details for order <orderId>
    Then status of response is 404
    And the response content is json
    And the order details returned with error message
    Examples:
      | orderId |
      | "-1000" |

  Scenario Outline: Wrong purchase order details
    Given order details for order <orderId>
    Then status of response is 404
    And the response content is json
    And the order details returned with unknown error message
    Examples:
      | orderId |
      | "2df3"   |

  Scenario Outline: Delete the purchase order by orderid
    Given delete the purchase order for order <orderId>
    Then status of response is 200
    And the response content is json
    And purchase order deleted with success message
    Examples:
      | orderId |
      | "3"   |

  Scenario Outline: Unknown purchase order deletion
    Given delete the purchase order for order <orderId>
    Then status of response is 404
    And the response content is json
    And the deletion of purchase order should throw error message
    Examples:
      | orderId |
      | "-123"   |

  Scenario Outline:  Wrong purchase order deletion
    Given delete the purchase order for order <orderId>
    Then status of response is 404
    And the response content is json
    And the deletion of wrong purchase order should throw error message
    Examples:
      | orderId |
      | "-123"   |

  Scenario: Find the petstore inventories by quantities
    Given the pet inventories in store
    Then status of response is 200
    And the response content is json
    And inventories details of petstore is returned