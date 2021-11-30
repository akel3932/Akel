Feature: Amazon most important features testing
  Scenario: Positive scenario for amazon search
    When I navigated to Amazon home page
    And I search for iPhone 13 case
    Then I should get more than 20 results
    And I validate the search result number