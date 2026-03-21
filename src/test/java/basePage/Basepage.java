package basePage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Basepage {
    // Using ThreadLocal to manage driver instances per thread
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driverThread.set(driver);
        
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public WebDriver getDriver() {
        return driverThread.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driverThread.remove(); // Clean up memory
        }
    }
}