$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/BookStoreBookCollection.feature");
formatter.feature({
  "name": "BookStore Book Collection",
  "description": "  As a user I want to navigate to the DEMOQA website, log in, filter and add a book to my collection, and verify it on my profile page",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a Book to the Collection, Check and Log Out",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am logged in with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_am_logged_in_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the BookStore page",
  "keyword": "When "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_navigate_to_the_BookStore_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I filter the listed books using the keyword \"Guide\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_filter_the_listed_books_using_the_keyword(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on a book to view its details",
  "keyword": "And "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_click_on_a_book_to_view_its_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the book to my collection",
  "keyword": "And "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_add_the_book_to_my_collection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the book added on my profile page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_should_see_the_book_added_on_my_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I log out",
  "keyword": "When "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_log_out()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be redirected to the login page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDef.BookStoreBookCollectionStepDef.i_should_be_redirected_to_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});