package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class letcodedemo {
	private WebDriver driver;
	public letcodedemo(WebDriver driver) {
		System.out.println(driver);
		this.driver = driver;
	}
	public void landingpage() throws InterruptedException {
		
		driver.get("https://letcode.in/test");
		driver.manage().window().fullscreen();
		Thread.sleep(3000);
	}
	public void inputspage() {
	driver.findElement(By.xpath("//a[text()=' Edit ']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Enter first & last name']")).sendKeys("Bot 1999");
	driver.findElement(By.xpath("//input[@value='I am good']")).sendKeys(" newly added");
	System.out.println(driver.findElement(By.id("getMe")).getText());
	driver.findElement(By.id("clearMe")).clear();
	System.out.println(driver.findElement(By.id("noEdit")).isEnabled());
	System.out.println(driver.findElement(By.id("dontwrite")).isEnabled());
	}
	public void buttonspage() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()=' Click ']")).click();
		driver.findElement(By.xpath("//button[text()='Goto Home']")).click();
		driver.navigate().back();
		System.out.println(driver.findElement(By.xpath("//button[text()='Find Location']")).getLocation());
		System.out.println(driver.findElement(By.xpath("//button[text()='What is my color?']")).getCssValue("color"));
		System.out.println(driver.findElement(By.xpath("//button[text()='How tall & fat I am?']")).getSize());
		System.out.println(driver.findElement(By.xpath("//button[text()='Disabled']")).isEnabled());
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(By.xpath("//h2[text()=' Button Hold!']")))
		.pause(3000).release().perform();
		System.out.println(driver.findElement(By.xpath("//div/button[@id='isDisabled']/div/h2")).getText());
		
	}
	public void selectpage() {
		driver.findElement(By.xpath("//a[text()=' Drop-Down ']")).click();
		WebElement selectdropdown = driver.findElement(By.id("fruits"));
		Select sl = new Select(selectdropdown);
		sl.selectByVisibleText("Banana");
		System.out.println(driver.findElement(By.xpath("//p[text()='You have selected Banana']")).getText());
		sl.selectByIndex(1);
		sl.selectByValue("2");
		System.out.println(sl.getOptions());
		
		
		Select co = new Select(driver.findElement(By.id("country")));
		System.out.println(co.getFirstSelectedOption().getText());
		co.selectByValue("India");
		System.out.println(co.getFirstSelectedOption());
		System.out.println(co.getAllSelectedOptions());
		Select s2 = new Select(driver.findElement(By.id("superheros")));
		System.out.println(s2.isMultiple());
		s2.selectByIndex(0);
		s2.selectByIndex(5);
		List<WebElement> allselected= s2.getAllSelectedOptions();
		System.out.println(allselected);
	}
	
	public void alertpage() throws InterruptedException {
		JavascriptExecutor JSE = (JavascriptExecutor)driver;
		JSE.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//a[text()=' Dialog ']")).click();
		driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
		driver.switchTo().alert().sendKeys("hello");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("myName")).getText());
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[text()='Confirm Alert']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[text()='Confirm Alert']")).click();
		driver.switchTo().alert().dismiss();
		JSE.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//button[text()='Modern Alert']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='title']")).getText());
		driver.findElement(By.xpath("//button[@class='modal-close is-large']")).click();
	}
	}