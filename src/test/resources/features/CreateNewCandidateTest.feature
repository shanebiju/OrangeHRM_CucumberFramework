Feature: user can create new candidate
  Scenario: Verify user can create new candidate
    Given user open website
    Then  verify user is on login page
    Given user login username "Admin" and password "admin123"
    Then  verify user is logged in
    When user click on recruitment on sidebar
    Then verify user is on recruitment page
    Then click on add button on recruitment page
    Then enter candidate creation details
    When user click save button on recruitment page
    Then verify success message is displayed
    Then wait for candidate profile to load
    When user click on recruitment on sidebar
    Then verify user is on recruitment page
    Then  enter candidate search details
    When user clicks search button
    Then verify candidate is retrieved
