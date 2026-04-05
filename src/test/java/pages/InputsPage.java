package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class InputsPage extends BasePage {

    // Locators (NON-static)
    private final By inputPageLink = By.xpath("//a[text()=' Edit ']");
    private final By nameField = By.xpath("//input[@placeholder='Enter first & last name']");
    private final By prefilledField = By.xpath("//input[@value='I am good']");
    private final By getValueField = By.id("getMe");
    private final By clearField = By.id("clearMe");
    private final By disabledField = By.id("noEdit");
    private final By enabledField = By.id("dontwrite");

    // Constructor
    public InputsPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Actions (Atomic Methods)
    // =========================

    public void openInputsPage() {
        scrollBy(200);
        click(inputPageLink);
    }

    public void enterFullName(String name) {
        sendKeys(nameField, name);
    }

    public void updatePrefilledText(String text) {
        sendKeys(prefilledField, text);
    }

    public void clearInputField() {
        clear(clearField);
    }

    // =========================
    // Getters (No Printing)
    // =========================

    public String getInputValue() {
        return getText(getValueField);
    }

    public String getClearedFieldValue() {
    	System.out.println("hello");
        return getText(clearField);
    }

    public boolean isFieldDisabled() {
        return !isEnabled(disabledField);
    }

    public boolean isFieldEnabled() {
        return isEnabled(enabledField);
    }
}