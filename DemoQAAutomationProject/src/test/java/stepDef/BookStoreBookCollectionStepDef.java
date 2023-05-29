package stepDef;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookStorePage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.BrowserFactory;
import utils.ConfigurationReader;
import utils.ScreenshotUtils;



public class BookStoreBookCollectionStepDef {
	
	WebDriver driver;
	LoginPage loginPage;
	ProfilePage profilePage;
	BookStorePage bookStorePage;
	String username = ConfigurationReader.getProperty("username");
    String password = ConfigurationReader.getProperty("password");
    String keyword = ConfigurationReader.getProperty("keyword");
    Scenario scenario;
    

	@Before
	public void launchBrowser(){
		driver=BrowserFactory.init();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		profilePage= PageFactory.initElements(driver, ProfilePage.class);
		bookStorePage= PageFactory.initElements(driver, BookStorePage.class);
		
		
	}
	
	@Given("I am logged in with valid credentials")
	public void i_am_logged_in_with_valid_credentials(){
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		profilePage.verifyProfilePage();
		profilePage.deleteExistingBook();
	}

	@When("I navigate to the BookStore page")
	public void i_navigate_to_the_BookStore_page() {
		profilePage.clickBookStoreButton();
	    bookStorePage.verifyBookStorePage();
	}

	@When("I filter the listed books using the keyword {string}")
	public void i_filter_the_listed_books_using_the_keyword(String keyword) {
		bookStorePage.filterBooks("Guide");
	}

	@When("I click on a book to view its details")
	public void i_click_on_a_book_to_view_its_details() {
		bookStorePage.clickBook();
	}

	@When("I add the book to my collection")
	public void i_add_the_book_to_my_collection() {
		bookStorePage.addToCollection();
		bookStorePage.verifyAlert();
	}

	@Then("I should see the book added on my profile page")
	public void i_should_see_the_book_added_on_my_profile_page() {
		 bookStorePage.verifyBookIsInCollection();
	}

	@When("I log out")
	public void i_log_out() {
		bookStorePage.logOut();
	}

	@Then("I should be redirected to the login page")
	public void i_should_be_redirected_to_the_login_page() {
		loginPage.loginPageValidation();
	}

	@After
	public void tearDown() {
		BrowserFactory.tearDown();
	}
	
	@After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(driver, scenario.getName());
        }

}
	
}
	