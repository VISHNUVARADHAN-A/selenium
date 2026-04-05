package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize Driver
    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();

        driver.set(new ChromeDriver());

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        return getDriver();
    }

    // Get Driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit Driver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}