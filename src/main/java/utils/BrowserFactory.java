package utils;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	static WebDriver driver;
	static String url = ConfigurationReader.getProperty("url");

	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "/Users/aliimran/Desktop/SeleniumFiles/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
