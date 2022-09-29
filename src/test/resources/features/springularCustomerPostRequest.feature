Feature: Customer create Test

  @wip
  Scenario: Create a new customer successfully
    Given login SprinGular api using username "guidersoft" and password "quality_hunter"
    Then add customer payloads
    Then user sends a Post request to "/api/customers"
    And "operationStatus" in response body is "SUCCESS"
    And "operationMessage" in response body is "Customer Added"
