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
import org.testng.asserts.SoftAssert;

//verifyProfilePage(): Verifies if the profile page is displayed by asserting the header text.
//deleteExistingBook(): Deletes the existing book by clicking the delete button and handling the alert messages.
//clickBookStoreButton(): Clicks the BookStore button to navigate to the BookStore page.

public class ProfilePage extends BasePage {

	WebDriver driver;
	
	// The constructor initializes the WebDriver instance.
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement List
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[1]/div")
	WebElement PROFILE_PAGE_HEADER;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button")
	WebElement DELETE_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"closeSmallModal-ok\"]")
	WebElement OK_BUTTON_FOR_POPUP;
	@FindBy(how = How.ID, using = "gotoStore")
	WebElement BOOKSTORE_BUTTON;

	public void verifyProfilePage() {

		// SoftAssert to perform assertions without stopping the execution
		SoftAssert softAssert = new SoftAssert();
		String expectedText = "Profile";
		String ActualText = PROFILE_PAGE_HEADER.getText();
		// Asserting the actual text with the expected text
		softAssert.assertEquals(ActualText, expectedText, "Headers dont match");
		System.out.println("Profile page header: " + ActualText);
		//assertTextEquals(PROFILE_PAGE_HEADER, expectedText);
	}

	public void deleteExistingBook() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Clicking the delete button
		js.executeScript("arguments[0].click()", DELETE_BUTTON);
		System.out.println("Delete Button Clicked");

		// Clicking the OK button in the delete books popup
		js.executeScript("arguments[0].click()", OK_BUTTON_FOR_POPUP);
		System.out.println("Delete Books Pop-up Clicked");

		// Handling the alert message after deleting books
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			String alertMessage = alert.getText();

			if (alertMessage.contains(" All Books deleted.")) {
				// Handle the specific alert message
				js.executeScript("alert(' All Books deleted.');");
				System.out.println(" All Books deleted.");
			}
			if (alertMessage.contains(" No books available in your's collection!")) {
				js.executeScript("alert(' No books available in your's collection!');");
				System.out.println("No books available in your's collection!");
			}
			// Accept the alert
			alert.accept();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("Failed to handle the alert: " + e.getMessage());
		}

	}

	public void clickBookStoreButton() {
		// Clicking the BookStore button
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", BOOKSTORE_BUTTON);

	}
}
