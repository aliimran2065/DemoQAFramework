package utils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		// Convert WebDriver object to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture screenshot as File
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

		String timeStamp = getCurrentTimestamp();
		// Define the destination path for the screenshot
		String destinationPath = "/Users/aliimran/Desktop/Selenium/DemoQAAutomationProject/screenshots/screenshots"
				+ screenshotName + timeStamp + ".png";

		try {
			// Copy the screenshot file to the destination path
			Files.copy(Paths.get(screenshotFile.getAbsolutePath()), Paths.get(destinationPath));
			System.out.println("Screenshot captured: " + destinationPath);
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}

	private static String getCurrentTimestamp() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		return now.format(formatter);
	}
}
