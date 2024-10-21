Feature: user can login and logout
  Scenario: Verify user can login and logout
    Given user open website
    Then  verify user is on login page
    Given user login username "Admin" and password "admin123"
    Then  verify user is logged in
    When user click on profile dropdown
    Then click on logout
    Then verify user is on login page