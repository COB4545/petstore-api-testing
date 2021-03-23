@test
Feature: Functional Verification Of petstore Pet related REST APIs

  Scenario: Add a pet to the petstore
    Given the following pet details:
    | id |
    | 2  |
    When  I add the pet
    Then status of response is 200
    And the response content is json
    And the pet should be added

  Scenario: Pet can not be added to the petstore
    Given the following pet details:
      | id |
      | 2-340-4  |
    When  I add the pet
    Then status of response is 500
    And the response content is json
    And the pet request should be failed

  Scenario: Update existing pet info with new data
    Given the following pet details:
      | id |
      | 10  |
    When  I update the pet data
    Then status of response is 200
    And the response content is json
    And the pet id should be updated as given id value