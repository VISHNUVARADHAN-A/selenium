package testngdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
public class test2 {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	private static void log(String message) {
		System.out.println(LocalDateTime.now().format(formatter) + " | " + message);
	}

	WebDriver driver;
	@BeforeClass
	void BeforeClass(){
	    log("before class");
	}
	@AfterClass
	void AfterClass(){
	    log("After class");
	}
	@BeforeMethod
	void startup() {
		log("startup");
		driver = new ChromeDriver();
	}

	@AfterMethod
	void teardown() {
		log("warp up");
		driver.quit();
	}
@Test(priority=1)
void priorityRunner() {
	log("start up1");
	driver.get("https://letcode.in/test");
	System.out.println(driver.getTitle());
}
	@Test(priority=0)
	void runner() {
		log("start up0");
		driver.get("https://seleniumbase.io/demo_page");
	}
}
