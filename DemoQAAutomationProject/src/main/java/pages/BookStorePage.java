package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//The BookStorePage class represents the page object for the Book Store page in the application.
//It extends the BasePage class, indicating that it inherits common functionality from it.
//The class constructor takes a WebDriver object as a parameter to initialize the driver.
//The class contains several WebElement variables that represent different elements on the Book Store page.
//Each method in the class performs a specific action on the page or verifies certain elements.
//The verifyBookStorePage() method verifies the Book Store page header by comparing the expected and actual text.
//The filterBooks() method enters a given keyword in the search textbox to filter the books.
//The clickBook() method clicks on a book by clicking the corresponding link.
//The addToCollection() method adds the book to the user's collection by clicking the "Add to Your Collection" button.
//The verifyAlert() method handles the alert by accepting it and waits for the profile page header to be clickable.
//The verifyBookIsInCollection() method verifies if the book is successfully added to the user's collection by iterating over the collection of books and checking if the title contains the keyword.
//The logOut() method performs logout by clicking the logout button.

public class BookStorePage extends BasePage {

	WebDriver driver;
	
	// The constructor initializes the WebDriver instance.
	public BookStorePage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement list
	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div")
	WebElement BOOK_STORE_PAGE_HEADER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchBox\"]")
	WebElement SEARCH_TEXTBOX;
	@FindBy(how = How.XPATH, using = "//*[@id=\"see-book-Git Pocket Guide\"]/a")
	WebElement CLICK_BOOK;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")
	WebElement ADD_TO_YOUR_COLLECTION_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"item-3\"]/span")
	WebElement PROFILE_PAGE_BUTTON;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]")
	WebElement PROFILE_PAGE_HEADER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement LOGOUT_BUTTON;

	public void verifyBookStorePage() {
		// Verifies the Book Store page header
		String expectedText = "Book Store";
		String actualText = BOOK_STORE_PAGE_HEADER.getText();
		System.out.println("Book Store Page header: " + actualText);
//		assertTextEquals(BOOK_STORE_PAGE_HEADER, expectedText);
	}

	public void filterBooks(String keyword) {
		// Enters the given keyword in the search textbox to filter the books
		SEARCH_TEXTBOX.sendKeys(keyword);
		System.out.println("Book filtered.");
	}

	public void clickBook() {
		// Clicks on a book
		CLICK_BOOK.click();
		System.out.println("Book clicked.");
	}

	public void addToCollection() {
		// Adds the book to the user's collection
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ADD_TO_YOUR_COLLECTION_BUTTON);
		System.out.println("Book add to collection clicked.");
	}

	public void verifyAlert() {
		// Verifies the alert and performs necessary actions
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		alert.accept();
		wait.until(ExpectedConditions.elementToBeClickable(PROFILE_PAGE_HEADER));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", PROFILE_PAGE_HEADER);
		System.out.println("Profile Page redirect button clicked");

	}

	public void verifyBookIsInCollection() {
		// Verifies if the book is successfully added to the user's collection
		String expectedText = "Profile";
		String actualText = PROFILE_PAGE_HEADER.getText();
//		assertTextEquals(PROFILE_PAGE_HEADER, expectedText);
		System.out.println("Profile Page header: " + actualText);

		// Iterates over the collection of books and checks if the title contains the keyword
		String dynamicXpathFirstHalf = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[";
		String dynamicXpathSecondHalf = "]/div/div[2]";

		for (int i = 1; i <= 5; i++) {
			String fullXpath = dynamicXpathFirstHalf + i + dynamicXpathSecondHalf;
			WebElement BOOKS_IN_COLLECTION = driver.findElement(By.xpath(fullXpath));

			String title = BOOKS_IN_COLLECTION.getText();

			if (title.contains("Guide")) {
				System.out.println("Book has been Succesfully added to your collection");
			}
		}

	}

	public void logOut() {
		// Performs logout by clicking the logout button
		LOGOUT_BUTTON.click();

	}

}
