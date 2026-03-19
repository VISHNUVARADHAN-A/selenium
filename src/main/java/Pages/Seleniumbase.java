package Pages;

import org.openqa.selenium.WebDriver;

public class Seleniumbase {
private WebDriver driver;
public Seleniumbase(WebDriver driver) {
	this.driver = driver;
}
public void seleniumhome(){
	driver.get("https://seleniumbase.io/demo_page");
	
}
}
