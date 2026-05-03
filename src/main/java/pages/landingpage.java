package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;


public class landingpage extends BasePage {
		public landingpage(WebDriver driver) {
			super(driver);
		}
	
	public void open_landing_page() {
		driver.navigate().to("https://letcode.in/");	
	  
	}
	public void get_the_page_title() {
	    System.out.println(driver.getTitle());
	}
}
