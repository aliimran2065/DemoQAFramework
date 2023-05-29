Feature: BookStore Book Collection
  As a user I want to navigate to the DEMOQA website, log in, filter and add a book to my collection, and verify it on my profile page
  
  Scenario: Add a Book to the Collection, Check and Log Out
    Given I am logged in with valid credentials
    When I navigate to the BookStore page
    And I filter the listed books using the keyword "Guide"
    And I click on a book to view its details
    And I add the book to my collection
    Then I should see the book added on my profile page
    When I log out
    Then I should be redirected to the login page
