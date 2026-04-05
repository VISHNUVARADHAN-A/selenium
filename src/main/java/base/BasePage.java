package base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor Injection (Industry Standard)
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================
    // Element Handling
    // =========================

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clear(By locator) {
        find(locator).clear();
    }

 // Select by visible text
    protected void selectByVisibleText(By locator, String text) {
        new Select(find(locator)).selectByVisibleText(text);
    }

    // Select by value attribute
    protected void selectByValue(By locator, String value) {
        new Select(find(locator)).selectByValue(value);
    }

    // Select by index
    protected void selectByIndex(By locator, int index) {
        new Select(find(locator)).selectByIndex(index);
    }
    
    protected List<String> getSelectedOptions(By locator) {
        Select select = new Select(find(locator));
        List<String> selectedTexts = new ArrayList<>();
        for (WebElement option : select.getAllSelectedOptions()) {
            selectedTexts.add(option.getText());
        }
        return selectedTexts;
    }


    protected String getText(By locator) {
        return find(locator).getText();
    }
    protected String getmutiple(By multiselect2) {
		
    	return find(multiselect2).getText();
	}
    protected boolean isEnabled(By locator) {
        return find(locator).isEnabled();
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    // =========================
    // Element Properties
    // =========================

    protected Point getLocation(By locator) {
        return find(locator).getLocation();
    }

    protected Dimension getSize(By locator) {
        return find(locator).getSize();
    }

    protected String getCssValue(By locator, String property) {
        return find(locator).getCssValue(property);
    }

    // =========================
    // Actions Class Methods
    // =========================

    protected void clickAndHold(By locator, int durationInMillis) {
        WebElement element = find(locator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(element)
               .pause(Duration.ofMillis(durationInMillis))
               .release()
               .perform();
    }

    // =========================
    // JavaScript Utilities
    // =========================

    protected void scrollBy(int pixels) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0," + pixels + ")");
    }

    protected void scrollIntoView(By locator) {
        WebElement element = find(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void jsClick(By locator) {
        WebElement element = find(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }
}