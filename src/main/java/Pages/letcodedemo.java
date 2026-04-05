//package Pages;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//
//
//public class letcodedemo {
//	private WebDriver driver;
//	
//	public letcodedemo(WebDriver driver) {
//		System.out.println(driver +" letcodedemo");
//		this.driver = driver;
//	}
//	public void landingpage() throws InterruptedException {
//		driver.get("https://letcode.in/test");
//	}
//	public void inputspage() {
//		LCInputsPage inputsPage = new LCInputsPage(driver);
//		inputsPage.clickAction();
//	}
//	public void buttonspage() {
//		LCButtonspage buttonpages = new LCButtonspage(driver);
//		buttonpages.buttonpages();
//	}
//	
//	public void selectpage() {
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//a[text()=' Drop-Down ']")).click();
//		WebElement selectdropdown = driver.findElement(By.id("fruits"));
//		Select sl = new Select(selectdropdown);
//		sl.selectByVisibleText("Banana");
//		System.out.println(driver.findElement(By.xpath("//p[text()='You have selected Banana']")).getText());
//		sl.selectByIndex(1);
//		sl.selectByValue("2");
//		System.out.println(sl.getOptions());
//		
//		
//		Select co = new Select(driver.findElement(By.id("country")));
//		System.out.println(co.getFirstSelectedOption().getText());
//		co.selectByValue("India");
//		System.out.println(co.getFirstSelectedOption());
//		System.out.println(co.getAllSelectedOptions());
//		Select s2 = new Select(driver.findElement(By.id("superheros")));
//		System.out.println(s2.isMultiple());
//		s2.selectByIndex(0);
//		s2.selectByIndex(5);
//		List<WebElement> allselected= s2.getAllSelectedOptions();
//		System.out.println(allselected);
//	}
//	
//	public void alertpage() throws InterruptedException {
//		driver.manage().window().maximize();
//		JavascriptExecutor JSE = (JavascriptExecutor)driver;
//		JSE.executeScript("window.scrollBy(0,500)");
//		driver.findElement(By.xpath("//a[text()=' Dialog ']")).click();
//		driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
//		driver.switchTo().alert().sendKeys("hello");
//		driver.switchTo().alert().accept();
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.id("myName")).getText());
//		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
//		driver.switchTo().alert().accept();
//		driver.findElement(By.xpath("//button[text()='Confirm Alert']")).click();
//		driver.switchTo().alert().accept();
//		driver.findElement(By.xpath("//button[text()='Confirm Alert']")).click();
//		driver.switchTo().alert().dismiss();
//		JSE.executeScript("window.scrollBy(0,500)");
//		driver.findElement(By.xpath("//button[text()='Modern Alert']")).click();
//		System.out.println(driver.findElement(By.xpath("//p[@class='title']")).getText());
//		driver.findElement(By.xpath("//button[@class='modal-close is-large']")).click();
//	}
//	
//	public void frames() throws InterruptedException {
//		driver.manage().window().maximize();
//		JavascriptExecutor JSE = (JavascriptExecutor)driver;
//		JSE.executeScript("window.scrollBy(0,500)");
//		WebElement framespage = driver.findElement(By.xpath("//a[text()=' Inner HTML ']"));
//		new Actions(driver)
//		        .scrollToElement(framespage)
//		        .perform();
//		framespage.click();
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='firstFr']")));
//		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("hello");
//		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("hello1");
//		Thread.sleep(1000);
//		System.out.println(driver.findElement(By.xpath("//p[@class='title has-text-info']")).getText());
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='innerframe']")));
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hello");
//		System.out.println(driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
//	}
//	public void radiobtn() throws InterruptedException {
//		driver.manage().window().maximize();
//		JavascriptExecutor JSE = (JavascriptExecutor)driver;
//		JSE.executeScript("window.scrollBy(0,500)");
//		driver.findElement(By.xpath("//a[text()=' Toggle ']")).click();
//		WebElement framespage = driver.findElement(By.xpath("//input[@id='yes']"));
//		new Actions(driver)
//		        .scrollToElement(framespage)
//		        .perform();
//		driver.findElement(By.xpath("//input[@id='yes']")).click();
//		driver.findElement(By.xpath("//input[@id='no']")).click();
//		driver.findElement(By.xpath("//input[@id='one']")).click();
//		System.out.println(driver.findElement(By.xpath("//input[@id='one']")).isSelected());
//		driver.findElement(By.xpath("//input[@id='two']")).click();
//		System.out.println(driver.findElement(By.xpath("//input[@id='one']")).isSelected());	
//		driver.findElement(By.xpath("//input[@id='bug']")).click();
//		System.out.println(driver.findElement(By.xpath("//input[@id='bug']")).isSelected());
//		driver.findElement(By.xpath("//input[@id='nobug']")).click();
//		System.out.println(driver.findElement(By.xpath("//input[@id='bug']")).isSelected());
//		System.out.println(driver.findElement(By.xpath("//input[@id='nobug']")).isSelected());
//		System.out.println(driver.findElement(By.xpath("//input[@id='maybe']")).isEnabled());
//		System.out.println(driver.findElement(By.xpath("//label[text()=' Remember me ']/input")).isSelected());
//		System.out.println(driver.findElement(By.xpath("//label[text()=' I agree to the ']/input")).isSelected());
//		driver.findElement(By.xpath("//label[text()=' I agree to the ']/input")).click();
//		System.out.println(driver.findElement(By.xpath("//label[text()=' I agree to the ']/input")).isSelected());
//	}
//	}
package pages;

