Feature: Testing google functionalities

  Scenario: Happy path Google search functionality
    Given I navigated to google.com
    When I search for mouse
    Then I get more than 10 results

  Scenario: Google search negative scenario
    Given I navigated to google.com
    When I search kladjfladdlkfjdklajf
    Then I should get 0 result
