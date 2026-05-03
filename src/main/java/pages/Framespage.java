package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class Framespage extends BasePage {
public Framespage(WebDriver driver) {
	super(driver);
}

public void navigatto() {
	driver.navigate().to("https://letcode.in/frame");
	System.out.println(driver.getTitle());
}

}
