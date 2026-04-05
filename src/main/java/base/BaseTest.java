package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.get("https://letcode.in/test");
        WebElement pathElement = null;

        for (int i = 0; i < 2; i++) { 
            try {
                // 1. Try to find the shadow host first
                List<WebElement> hosts = driver.findElements(By.cssSelector(".grippy-host"));
                
                if (!hosts.isEmpty()) {
                    // 2. If host exists, look inside the shadow root
                    SearchContext shadowRoot = hosts.get(0).getShadowRoot();
                    pathElement = shadowRoot.findElement(By.cssSelector("path[d^='M10,26']"));
                    
                    if (pathElement != null) {
                        System.out.println("Element found inside shadow root.");
                        break; 
                    }
                } else {
                    System.out.println("Shadow host '.grippy-host' not found yet, retrying... (" + i + ")");
                }
            } catch (Exception e) {
                // Fall through to sleep and retry if element is not yet in the DOM
            }
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        if (pathElement != null) {
            // --- PUT THE SOLUTION HERE ---
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            // This forces the click event on the path element, bypassing the ad iframe
            js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true}));", pathElement);
            
            System.out.println("Element clicked successfully via JavaScript.");
        } else {
            System.out.println("Element not found after waiting.");
        }

        // Final wait for 3 seconds as requested
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}