package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.ConfigurationReader;

//The class is a representation of the LoginPage in the application.
//The class extends the BasePage class, which suggests that it inherits common functionality from the base page.
//The constructor initializes the WebDriver instance.
//All methods perform actions on the respective WebElements to interact with the login page.

public class LoginPage extends BasePage {

	WebDriver driver;
	

	// The constructor initializes the WebDriver instance.
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// USERNAME_TEXTBOX, PASSWORD_TEXTBOX, and LOGIN_BUTTON are WebElements
	// representing the corresponding elements on the login page.

	@FindBy(how = How.XPATH, using = "//*[@id=\"userName\"]")
	WebElement USERNAME_TEXTBOX;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_TEXTBOX;
	@FindBy(how = How.ID, using = "login")
	WebElement LOGIN_BUTTON;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[1]/div")
	WebElement LOGIN_PAGE_HEADER;

	// The enterUsername method enters the provided user name in the user name text
	// box.
	public void enterUsername(String username) {
		USERNAME_TEXTBOX.sendKeys(username);
	}

	// The enterPassword method enters the provided password in the password text
	// box.
	
	public void enterPassword(String password) {
		PASSWORD_TEXTBOX.sendKeys(password);
	}

	// The clickLoginButton method clicks on the login button.
	public void clickLoginButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", LOGIN_BUTTON);

	}

	// Validates the header text on the login page. Compares the actual header text
	// with the expected header text and asserts their equality.
	public void loginPageValidation() {
		String ExpectedLoginPageHeader = "Login";
		String actualText = LOGIN_PAGE_HEADER.getText();
		System.out.println("Login Page header: " + actualText);
		assertTextEquals(LOGIN_PAGE_HEADER, ExpectedLoginPageHeader);
	}

}
