Feature: User can create new user
  Scenario: verify that user can create new user
    Given user open website
    Then  verify user is on login page
    Given user login username "Admin" and password "admin123"
    Then  verify user is logged in
    When user click on admin on sidebar
    Then verify user is on admin page
    When user click on add button on admin page
    Then verify user is on add user page
    Then enter new user details
    When user click save button on admin page
    Then verify success message is displayed
    Then verify user is on System Users page
    Then enter new user search details
    Then user clicks on Search button on admin page
    Then delete the obtained user after search