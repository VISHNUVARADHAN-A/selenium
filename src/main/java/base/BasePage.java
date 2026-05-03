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
        element.sendKeys(text);
    }
    protected void clearandsendKeys(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clear(By locator) {
        find(locator).clear();
    }

    
//select drop down
    //---------------------------------------------------------
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
//selected option
    protected String selectedoption(By locator) {
      String val=   new Select(find(locator)).getFirstSelectedOption().getText();
        return val;
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
    
    // =========================
    // Element enabled disabled
    // =========================
    protected boolean isEnabled(By locator) {
        return find(locator).isEnabled();
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }
    protected boolean isselected(By locator) {
        return find(locator).isSelected();
    }
    
    // =========================
    // Element value
    // =========================
    
    protected String getatttext(By locator) {
        return find(locator).getAttribute("text");
    }
    protected String getattvalue(By locator) {
        return find(locator).getAttribute("value");
    }
    protected boolean getreadonly(By locator) {
    	String readOnlyAttribute =find(locator).getAttribute("readonly");
    	boolean isReadOnly = readOnlyAttribute != null && readOnlyAttribute.equals("true");
        return isReadOnly;
    }
    protected String getattplaceholder(By locator) {
        return find(locator).getAttribute("placeholder");
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
    	Actions actions = new Actions(driver);
        WebElement element = find(locator);
        actions.clickAndHold(element)
               .pause(Duration.ofMillis(durationInMillis))
               .release()
               .perform();
    }
    protected void hover(By locator) {
        WebElement element = find(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element)      
               .perform();
    }
    protected void drag(By locator, int val) {
        WebElement element = find(locator);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, val, 0).build().perform();
    }
    protected String draganddrop(By locator, By locator2  ) {
    	Actions actions = new Actions(driver);
        WebElement element = find(locator);
        WebElement destination = find(locator2);
        Point targetLocation = destination.getLocation();
        actions.dragAndDrop(element,destination).build().perform();
        Point sourceLocation = element.getLocation();
        return ("Before: "+ targetLocation +"After: "+ sourceLocation);
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
    protected String jsvalue(By locator , String id) {
    return (String) ((JavascriptExecutor) driver).executeScript("return document.getElementById('"+id+"').value;");
    }
    
    protected boolean isImageLoaded(By locator) {
    	WebElement element = find(locator);
        
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
            "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;", 
            element
        );
    }
    
    
}