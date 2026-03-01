package testngdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	private static void log(String message) {
		System.out.println(LocalDateTime.now().format(formatter) + " | " + message);
	}

	WebDriver driver;

	@BeforeMethod
	void startup() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	void teardown() {
		driver.quit();
	}
@Test(priority=1)
void priorityRunner() {
	driver.get("https://letcode.in/test");
	System.out.println(driver.getTitle());
}
	@Test
	void runner() {
		log("runner");
		driver.get("https://www.google.com");
	}
}
