Feature: Test login page

  Scenario: Test positive login page
    Given I am on main application page
    When I login as correct user
    Then I see logout link
    When I compose message
    Then I see notification
