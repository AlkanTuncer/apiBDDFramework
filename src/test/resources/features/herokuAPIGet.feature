Feature: Get Request

  @wip
  Scenario: Booking get request

    Given The "accept" should be "application/json"
    When user send a get request to "/booking/150"
    Then print the response body
    And response status code should be 200
    And response content type should be "application/json; charset=utf-8"
    And response body should contains "NewJJ"