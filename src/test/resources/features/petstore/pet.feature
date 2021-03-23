@test
Feature: Functional Verification Of petstore Pet related REST APIs

  Scenario: Add a pet to the petstore
    Given the following pet details:
    | id |
    | 2  |
    When  I add the pet
#    Then status of response is 200
#    And the response content is json
#    And the pet order should have id


