package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.Seleniumbase;
import utils.DriverFactory;

public class BaseTest2 {

    protected WebDriver driver;
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<Seleniumbase> sbThreadLocal = new ThreadLocal<>();
    public static WebDriver initDriver(ChromeOptions options) {
        return new ChromeDriver(options);
    }
    @BeforeMethod
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Modern headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // 2. Initialize WebDriver through DriverFactory by passing the options
        WebDriver driver = DriverFactory.initDriver(); 
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
        
        driver.get("C:/Users/vishn/Downloads/Web%20Testing%20Page.html");
        Seleniumbase sb = new Seleniumbase(driver);
        sbThreadLocal.set(sb);
    }

    public Seleniumbase getSb() {
        return sbThreadLocal.get();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    	if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
            sbThreadLocal.remove();
        }
    }
}